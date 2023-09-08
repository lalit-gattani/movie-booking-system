package com.interview.ticket.booking.system.repository;

import com.interview.ticket.booking.system.entity.Theater;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class TheaterRepository {
    
    private static final Map<String, Theater> THEATER_REPOSITORY = new HashMap<>();
    
    public void addTheater(Theater theater) {
        THEATER_REPOSITORY.put(theater.getTheaterId(), theater);
    }
    
    public Map<String, Theater> getAllTheaters() {
        return THEATER_REPOSITORY;
    }
    
    
}
