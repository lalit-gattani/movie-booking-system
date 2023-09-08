package com.interview.ticket.booking.system.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.interview.ticket.booking.system.enums.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookTicketResponseDto {
    private String bookingId;
    private BookingStatus bookingStatus;
    private String failureReason;
}
