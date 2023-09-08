package com.interview.ticket.booking.system.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookTicketRequestDto {
    private String userId;
    private String showId;
    private Integer seats;
    private String paymentMethod;
    private List<Integer> seatNumbers;
}
