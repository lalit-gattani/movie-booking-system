package com.interview.ticket.booking.system.repository;

import com.interview.ticket.booking.system.entity.Session;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SessionRepository {
    
    private static final Map<String, Session> SESSION_REPOSITORY = new HashMap<>();
    
    public void addSession(Session session) {
        SESSION_REPOSITORY.put(session.getSessionId(), session);
    }
    
    public Map<String, Session> getAllSessions() {
        return SESSION_REPOSITORY;
    }
    
    
}
