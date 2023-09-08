package com.interview.ticket.booking.system.controller;

import com.interview.ticket.booking.system.dto.LoginRequestDto;
import com.interview.ticket.booking.system.dto.LoginResponseDto;
import com.interview.ticket.booking.system.dto.RegisterRequestDto;
import com.interview.ticket.booking.system.exception.CustomException;
import com.interview.ticket.booking.system.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired LoginService loginService;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) throws Exception {
        try {
            return loginService.login(loginRequestDto);
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Something went Wrong");
        }
    }
    @PostMapping("/register")
    public String login(@RequestBody RegisterRequestDto registerRequestDto) throws Exception {
        try {
            loginService.register(registerRequestDto);
            return "User Registered Successfully";
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Something went Wrong");
        }
    }
}
