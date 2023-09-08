package com.interview.ticket.booking.system.service;

import com.interview.ticket.booking.system.dto.LoginRequestDto;
import com.interview.ticket.booking.system.dto.LoginResponseDto;
import com.interview.ticket.booking.system.dto.RegisterRequestDto;
import com.interview.ticket.booking.system.entity.Session;
import com.interview.ticket.booking.system.entity.User;
import com.interview.ticket.booking.system.exception.CustomException;
import com.interview.ticket.booking.system.repository.SessionRepository;
import com.interview.ticket.booking.system.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class LoginService {

    @Autowired UserRepository userRepository;

    @Autowired SessionRepository sessionRepository;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) throws CustomException {
        Map<String, User> allUsers = userRepository.getAllUsers();
        User storedUser = null;
        for (User user : allUsers.values()) {
            if (user.getEmailId().equals(loginRequestDto.getEmailId())) {
                storedUser = user;
            }
        }
        if (Objects.isNull(storedUser)) throw new CustomException("User Not Found");
        if (!storedUser.getPassword().equals(loginRequestDto.getPassword()))
            throw new CustomException("Wrong Password");

        Session session = Session.builder().userId(storedUser.getUserId()).build();

                sessionRepository.addSession(session);
        return LoginResponseDto.builder()
                .sessionId(session.getSessionId())
                .userId(session.getUserId())
                .build();
    }

    public void register(RegisterRequestDto registerRequestDto) throws CustomException {
        Map<String, User> allUsers = userRepository.getAllUsers();
        User storedUser = null;
        for (User user : allUsers.values()) {
            if (user.getEmailId().equals(registerRequestDto.getEmailId())) {
                storedUser = user;
            }
        }
        if (Objects.nonNull(storedUser)) throw new CustomException("User Already Exists");
        User user =
                User.builder()
                        .userName(registerRequestDto.getName())
                        .emailId(registerRequestDto.getEmailId())
                        .password(registerRequestDto.getPassword())
                        .phoneNumber(registerRequestDto.getPhone())
                        .build();
        userRepository.addUser(user);
    }

    public void authenticate(String authorization, String userId) throws CustomException {
        User user = userRepository.getAllUsers().getOrDefault(userId, null);
        if (Objects.isNull(user)) throw new CustomException("User not Found");
        Session storedSession = null;
        for (Session session : sessionRepository.getAllSessions().values()) {
            if (authorization.equals(session.getSessionId())
                    && userId.equals(session.getUserId())
                    && session.getIsSessionActive()) {
                storedSession = session;
            }
        }
        if(Objects.isNull(storedSession))
            throw new CustomException("Unauthorized");
    }
}
