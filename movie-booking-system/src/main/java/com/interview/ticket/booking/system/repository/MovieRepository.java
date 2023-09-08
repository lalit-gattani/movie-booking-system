package com.interview.ticket.booking.system.repository;

import com.interview.ticket.booking.system.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MovieRepository {
    
    private static final Map<String, Movie> MOVIE_REPOSITORY = new HashMap<>();
    
    public void addMovie(Movie movie) {
        MOVIE_REPOSITORY.put(movie.getMovieId(), movie);
    }
    
    public Map<String, Movie> getAllMovies() {
        return MOVIE_REPOSITORY;
    }
    
    
}
