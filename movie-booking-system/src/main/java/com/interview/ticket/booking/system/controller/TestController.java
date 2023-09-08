package com.interview.ticket.booking.system.controller;

import com.interview.ticket.booking.system.dto.MovieDto;
import com.interview.ticket.booking.system.exception.CustomException;
import com.interview.ticket.booking.system.repository.*;
import com.interview.ticket.booking.system.service.MovieService;

import com.interview.ticket.booking.system.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    ScreenRepository screenRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    BookingRepository bookingRepository;

    @PostMapping("/")
    public void addMovie() throws Exception {
        testService.testData();
    }

    @GetMapping("/theater")
    public Map getAllTheaters() {
        return theaterRepository.getAllTheaters();
    }

    @GetMapping("/screen")
    public Map getAllScreens() {
        return screenRepository.getAllScreens();
    }

    @GetMapping("/user")
    public Map getAllUsers() {
        return userRepository.getAllUsers();
    }

    @GetMapping("/movie")
    public Map getAllMovies() {
        return movieRepository.getAllMovies();
    }
    @GetMapping("/show")
    public Map getAllShows() {
        return showRepository.getAllShows();
    }

    @GetMapping("/booking")
    public Map getAllBookings() {
        return bookingRepository.getAllBookings();
    }

}
