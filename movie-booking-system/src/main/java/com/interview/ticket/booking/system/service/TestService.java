package com.interview.ticket.booking.system.service;

import com.interview.ticket.booking.system.entity.Movie;
import com.interview.ticket.booking.system.entity.Screen;
import com.interview.ticket.booking.system.entity.Show;
import com.interview.ticket.booking.system.entity.Theater;
import com.interview.ticket.booking.system.enums.Language;
import com.interview.ticket.booking.system.enums.ShowType;
import com.interview.ticket.booking.system.repository.MovieRepository;
import com.interview.ticket.booking.system.repository.ScreenRepository;
import com.interview.ticket.booking.system.repository.ShowRepository;
import com.interview.ticket.booking.system.repository.TheaterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@Service
public class TestService {
    @Autowired
    ScreenRepository screenRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowRepository showRepository;

    public void testData() {
        Theater theater1 = Theater
                .builder()
                .theaterAddress("ABC")
                .theaterName("Theater1")
                .build();

        Theater theater2 = Theater
                .builder()
                .theaterAddress("XYZ")
                .theaterName("Theater2")
                .build();

        theaterRepository.addTheater(theater1);
        theaterRepository.addTheater(theater2);

        Screen screen1 = Screen.builder()
                .screenNumber(1)
                .capacity(10)
                .theaterId(theater1.getTheaterId())
                .seatNumberList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5,6, 7, 8, 9, 10)))
                .build();
        Screen screen2 = Screen.builder()
                .screenNumber(2)
                .capacity(8)
                .theaterId(theater1.getTheaterId())
                .seatNumberList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5,6, 7, 8)))
                .build();
        Screen screen3 = Screen.builder()
                .screenNumber(1)
                .capacity(10)
                .theaterId(theater2.getTheaterId())
                .seatNumberList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5,6, 7, 8, 9, 10)))
                .build();
        Screen screen4 = Screen.builder()
                .screenNumber(2)
                .capacity(8)
                .theaterId(theater2.getTheaterId())
                .seatNumberList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5,6, 7, 8)))
                .build();

        screenRepository.addScreen(screen1);
        screenRepository.addScreen(screen2);
        screenRepository.addScreen(screen3);
        screenRepository.addScreen(screen4);

        Movie movie1 = Movie.builder()
                .name("Barbie")
                .rating(4.5).build();

        Show show = Show
                .builder()
                .cost(200.0)
                .showType(ShowType._2D)
                .showEndTime(LocalDateTime.now().plusDays(1))
                .showStartTime(LocalDateTime.now().plusDays(1).minusHours(3))
                .movieId(movie1.getMovieId())
                .screenId(screen1.getScreenId())
                .theaterId(theater1.getTheaterId())
                .availableSeats(screen1.getCapacity())
                .availableSeatNumbers(screen1.getSeatNumberList())
                .language(Language.ENGLISH)
                .build();

        movieRepository.addMovie(movie1);
        showRepository.addShow(show);
    }
}
