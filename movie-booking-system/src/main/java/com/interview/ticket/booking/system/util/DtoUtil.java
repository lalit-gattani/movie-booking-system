package com.interview.ticket.booking.system.util;

import com.interview.ticket.booking.system.dto.BookTicketResponseDto;
import com.interview.ticket.booking.system.dto.MovieDto;
import com.interview.ticket.booking.system.dto.ShowDto;
import com.interview.ticket.booking.system.entity.*;

import java.util.ArrayList;
import java.util.List;

public class DtoUtil {
    public static MovieDto toMovieDto(Movie movie) {
        return MovieDto
                .builder()
                .movieId(movie.getMovieId())
                .name(movie.getName())
                .poster(movie.getPoster())
                .rating(movie.getRating())
                .build();
    }

    public static Movie toMovie(MovieDto movieDto) {
        return Movie
                .builder()
                .name(movieDto.getName())
                .poster(movieDto.getPoster())
                .rating(movieDto.getRating())
                .build();
    }

    public static List<ShowDto> toShowDto(List<Show> showList, List<Theater> theaterList, List<Screen> screenList) {
        List<ShowDto> showDtoList = new ArrayList<>();
        for(int i = 0; i < showList.size(); i++){
            showDtoList.add(toShowDto(showList.get(i), theaterList.get(i), screenList.get(i)));
        }
        return showDtoList;
    }

    public static ShowDto toShowDto(Show show, Theater theater, Screen screen) {
        return ShowDto
                .builder()
                .showId(show.getShowId())
                .availableSeats(show.getAvailableSeats())
                .cost(show.getCost())
                .isActive(show.getIsActive())
                .language(show.getLanguage())
                .screenNumber(screen.getScreenNumber())
                .showEndTime(show.getShowEndTime())
                .showStartTime(show.getShowStartTime())
                .theaterId(show.getTheaterId())
                .movieId(show.getMovieId())
                .theaterName(theater.getTheaterName())
                .seatNumbers(show.getAvailableSeatNumbers())
                .screenId(screen.getScreenId())
                .showType(show.getShowType())
                .build();
    }

    public static BookTicketResponseDto toBookingResponseDto(Booking newBooking) {
        return BookTicketResponseDto
                .builder()
                .bookingId(newBooking.getBookingId())
                .bookingStatus(newBooking.getBookingStatus())
                .failureReason(newBooking.getFailureReason())
                .build();
    }

    public static Show toShow(ShowDto showDto, Screen screen) {
        return Show
                .builder()
                .movieId(showDto.getMovieId())
                .availableSeats(screen.getCapacity())
                .availableSeatNumbers(screen.getSeatNumberList())
                .cost(showDto.getCost())
                .isActive(Boolean.TRUE)
                .showType(showDto.getShowType())
                .language(showDto.getLanguage())
                .showEndTime(showDto.getShowEndTime())
                .showStartTime(showDto.getShowStartTime())
                .theaterId(screen.getTheaterId())
                .showType(showDto.getShowType())
                .build();
    }
}
