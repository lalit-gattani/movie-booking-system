package com.interview.ticket.booking.system.service;

import com.interview.ticket.booking.system.dto.MovieDto;
import com.interview.ticket.booking.system.entity.Movie;
import com.interview.ticket.booking.system.exception.CustomException;
import com.interview.ticket.booking.system.repository.MovieRepository;
import com.interview.ticket.booking.system.util.DtoUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired MovieRepository movieRepository;

    public List<MovieDto> getAllMovies() {
        return movieRepository.getAllMovies().values().stream()
                .filter(Movie::getIsPlaying)
                .map(DtoUtil::toMovieDto)
                .collect(Collectors.toList());
    }

    public MovieDto searchMovie(String movieName) throws CustomException {
        Map<String, Movie> allMovies = movieRepository.getAllMovies();
        Movie storedMovie = null;
        for (Movie movie : allMovies.values()) {
            if (movie.getName().equals(movieName) && movie.getIsPlaying()) storedMovie = movie;
        }
        if (Objects.isNull(storedMovie)) {
            throw new CustomException("Movie Does not Exist");
        }
        return DtoUtil.toMovieDto(storedMovie);
    }

    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = DtoUtil.toMovie(movieDto);
        movieRepository.addMovie(movie);
        return DtoUtil.toMovieDto(movie);
    }
}
