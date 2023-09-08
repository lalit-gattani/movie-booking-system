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
public class Movie {
    @Builder.Default
    private String movieId = "MO" + UUID.randomUUID();
    private String name;
    private byte[] poster;
    private double rating;
    // private MovieMetadata movieMetadata;
    @Builder.Default
    private Boolean isPlaying = Boolean.TRUE;
}
