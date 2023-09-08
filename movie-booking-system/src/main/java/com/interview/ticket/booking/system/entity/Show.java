package com.interview.ticket.booking.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.interview.ticket.booking.system.enums.Language;
import com.interview.ticket.booking.system.enums.ShowType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Show {
  @Builder.Default
  private String showId = "SH" + UUID.randomUUID();
  private String theaterId;
  private String movieId;
  private String screenId;
  private LocalDateTime showStartTime;
  private LocalDateTime showEndTime;
  private Language language;
  private ShowType showType;
  @Builder.Default
  private Boolean isActive = Boolean.TRUE;
  private volatile Integer availableSeats;
  private Double cost;
  private volatile List<Integer> availableSeatNumbers;
}
