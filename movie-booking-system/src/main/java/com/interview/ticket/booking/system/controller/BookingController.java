package com.interview.ticket.booking.system.controller;

import com.interview.ticket.booking.system.dto.BookTicketRequestDto;
import com.interview.ticket.booking.system.dto.BookTicketResponseDto;
import com.interview.ticket.booking.system.exception.CustomException;
import com.interview.ticket.booking.system.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/book")
    public BookTicketResponseDto bookTicket(@RequestHeader String authorization,
                                            @RequestHeader String userId,
                                            @RequestBody BookTicketRequestDto bookTicketRequestDto) throws Exception {
        try {
            return bookingService.bookTicket(authorization, userId, bookTicketRequestDto);
        } catch (CustomException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Something went Wrong");
        }
    }
}
