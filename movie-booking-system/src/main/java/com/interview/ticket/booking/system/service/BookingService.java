package com.interview.ticket.booking.system.service;

import com.interview.ticket.booking.system.dto.BookTicketRequestDto;
import com.interview.ticket.booking.system.dto.BookTicketResponseDto;
import com.interview.ticket.booking.system.entity.Booking;
import com.interview.ticket.booking.system.entity.Show;
import com.interview.ticket.booking.system.enums.BookingStatus;
import com.interview.ticket.booking.system.exception.CustomException;
import com.interview.ticket.booking.system.repository.BookingRepository;
import com.interview.ticket.booking.system.repository.ShowRepository;
import com.interview.ticket.booking.system.util.DtoUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class BookingService {

    @Autowired
    LoginService loginService;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ShowService showService;

    public BookTicketResponseDto bookTicket(String authorization, String userId, BookTicketRequestDto bookTicketRequestDto) throws InterruptedException, CustomException {
        loginService.authenticate(authorization, userId);

        validateBookingRequest(bookTicketRequestDto);

        showService.reserveSeats(bookTicketRequestDto.getShowId(), bookTicketRequestDto.getSeatNumbers());

        Booking newBooking = Booking
                .builder()
                .seatNumbers(bookTicketRequestDto.getSeatNumbers())
                .bookingTime(LocalDateTime.now())
                .bookingStatus(BookingStatus.INITIATED)
                .showId(bookTicketRequestDto.getShowId())
                .userId(bookTicketRequestDto.getUserId())
                .numberOfSeats(bookTicketRequestDto.getSeats())
                .paymentMethod(bookTicketRequestDto.getPaymentMethod())
                .build();

        bookingRepository.addBooking(newBooking);

        try {
            checkPaymentStatus(newBooking.getBookingId());
        } catch (Exception e) {
            newBooking.setBookingStatus(BookingStatus.FAILED);
            bookingRepository.addBooking(newBooking);
            showService.unReserveSeats(bookTicketRequestDto.getShowId(), bookTicketRequestDto.getSeatNumbers());
            throw e;
        }

        newBooking.setBookingStatus(BookingStatus.COMPLETED);
        bookingRepository.addBooking(newBooking);

        return DtoUtil.toBookingResponseDto(newBooking);
    }

    private void validateBookingRequest(BookTicketRequestDto bookTicketRequestDto) throws CustomException {
        Show show = showRepository.getAllShows().getOrDefault(bookTicketRequestDto.getShowId(), null);
        if( Objects.isNull(show) || !show.getIsActive())
            throw new CustomException("Show Not Found");
        if(bookTicketRequestDto.getSeats() > show.getAvailableSeats())
            throw new CustomException("Not Enough Seats");
        for(Integer seatNo : bookTicketRequestDto.getSeatNumbers()) {
            if(!show.getAvailableSeatNumbers().contains(seatNo))
                throw new CustomException("Seat Not Available");
        }
        if(bookTicketRequestDto.getSeatNumbers().size() != bookTicketRequestDto.getSeats())
            throw new CustomException("Seat Number mismatch");
    }

    private void checkPaymentStatus(String bookingId) throws InterruptedException {
        Thread.sleep(2000);
    }
}
