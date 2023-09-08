package com.interview.ticket.booking.system.repository;

import com.interview.ticket.booking.system.entity.Show;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShowRepository {
    
    private static final Map<String, Show> SHOW_REPOSITORY = new HashMap<>();
    
    public void addShow(Show show) {SHOW_REPOSITORY.put(show.getShowId(), show);
    }
    
    public Map<String, Show> getAllShows() {
        return SHOW_REPOSITORY;
    }
    
    
}
