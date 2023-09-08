package com.interview.ticket.booking.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Screen {
  private String theaterId;
  @Builder.Default
  private String screenId = "SC" + UUID.randomUUID();
  private Integer capacity;
  private Integer screenNumber;
  private List<Integer> seatNumberList;
  //private ScreenMetadata screenMetadata;
}
