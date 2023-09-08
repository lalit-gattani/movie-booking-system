package com.interview.ticket.booking.system.config;

import com.interview.ticket.booking.system.exception.CustomException;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {CustomException.class})
    protected ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        log.error("Exception ", ex);
        val httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        log.error("Error {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), httpStatus);
    }
}
