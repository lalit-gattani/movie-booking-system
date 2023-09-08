package com.interview.ticket.booking.system.controller;

import com.interview.ticket.booking.system.dto.MovieDto;
import com.interview.ticket.booking.system.exception.CustomException;
import com.interview.ticket.booking.system.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;
    @GetMapping("/all")
    public List<MovieDto> getAllMovies() throws Exception {
        try {
            return movieService.getAllMovies();
        } catch (Exception e) {
            throw new Exception("Something went Wrong");
        }
    }

    @GetMapping("/{movieName}")
    public MovieDto searchMovie(@PathVariable String movieName) throws Exception {
        try {
            return movieService.searchMovie(movieName);
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Something went Wrong");
        }
    }

    @PostMapping("/")
    public MovieDto addMovie(@RequestBody MovieDto movieDto) throws Exception {
        try {
            return movieService.addMovie(movieDto);
        } catch (Exception e) {
            throw new Exception("Something went Wrong");
        }
    }
}
