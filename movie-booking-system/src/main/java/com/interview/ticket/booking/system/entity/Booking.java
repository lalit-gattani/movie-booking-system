package com.interview.ticket.booking.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.interview.ticket.booking.system.enums.BookingStatus;

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
public class Booking {
    @Builder.Default
    private String bookingId = "BO" + UUID.randomUUID();
    private String userId;
    private String showId;
    private LocalDateTime bookingTime;
    private Integer numberOfSeats;
    private List<Integer> seatNumbers;
    private BookingStatus bookingStatus;
    private String failureReason;
    private String paymentMethod;
}
