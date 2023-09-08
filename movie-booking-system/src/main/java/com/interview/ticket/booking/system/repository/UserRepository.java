package com.interview.ticket.booking.system.repository;

import com.interview.ticket.booking.system.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserRepository {
    
    private static final Map<String, User> USER_REPOSITORY = new HashMap<>();
    
    public void addUser(User user) { USER_REPOSITORY.put(user.getUserId(), user);
    }
    
    public Map<String, User> getAllUsers() {
        return USER_REPOSITORY;
    }
    
    
}
