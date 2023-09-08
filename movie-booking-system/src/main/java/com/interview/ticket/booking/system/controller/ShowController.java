package com.interview.ticket.booking.system.controller;

import com.interview.ticket.booking.system.dto.ShowDto;
import com.interview.ticket.booking.system.exception.CustomException;
import com.interview.ticket.booking.system.service.ShowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService;

    @GetMapping("/movie/{movieId}")
    public List<ShowDto> getAllShowsForMovie(@PathVariable String movieId) throws Exception {
        try {
            return showService.getAllShowsForMovie(movieId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Something went Wrong");
        }
    }

    @PostMapping("/")
    public ShowDto addShow(@RequestBody ShowDto showDto) throws Exception {
        try {
            return showService.addShow(showDto);
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Something went Wrong");
        }
    }
}
