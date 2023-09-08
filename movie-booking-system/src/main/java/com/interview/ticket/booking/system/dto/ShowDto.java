package com.interview.ticket.booking.system.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.interview.ticket.booking.system.enums.Language;
import com.interview.ticket.booking.system.enums.ShowType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShowDto {
    private String showId;
    private String theaterId;
    private String theaterName;
    private String movieId;
    private String screenId;
    private Integer screenNumber;
    private LocalDateTime showStartTime;
    private LocalDateTime showEndTime;
    private Language language;
    private ShowType showType;
    private Boolean isActive;
    private Integer availableSeats;
    private Double cost;
    private List<Integer> seatNumbers;
}
