package com.interview.ticket.booking.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String emailId;
    private String password;
    @Builder.Default
    private String userId = "ACC" + UUID.randomUUID();
    private String userName;
    private String phoneNumber;
}
