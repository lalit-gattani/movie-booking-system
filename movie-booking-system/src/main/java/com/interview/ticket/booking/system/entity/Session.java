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
public class Session {
    @Builder.Default
    private String sessionId = "SESSION" + UUID.randomUUID();
    private String userId;
    @Builder.Default
    private Boolean isSessionActive = Boolean.TRUE;
}
