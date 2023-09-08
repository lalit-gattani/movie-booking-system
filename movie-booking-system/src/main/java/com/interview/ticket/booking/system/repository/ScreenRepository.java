package com.interview.ticket.booking.system.repository;

import com.interview.ticket.booking.system.entity.Screen;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ScreenRepository {
    
    private static final Map<String, Screen> SCREEN_REPOSITORY = new HashMap<>();
    
    public void addScreen(Screen screen) {SCREEN_REPOSITORY.put(screen.getScreenId(), screen);
    }
    
    public Map<String, Screen> getAllScreens() {
        return SCREEN_REPOSITORY;
    }
    
    
}
