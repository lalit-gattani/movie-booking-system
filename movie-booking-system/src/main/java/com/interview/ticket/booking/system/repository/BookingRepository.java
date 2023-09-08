package com.interview.ticket.booking.system.repository;

import com.interview.ticket.booking.system.entity.Booking;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookingRepository {

    private static final Map<String, Booking> BOOKING_REPOSITORY = new HashMap<>();

    public void addBooking(Booking booking) {
        BOOKING_REPOSITORY.put(booking.getBookingId(), booking);
    }

    public Map<String, Booking> getAllBookings() {
        return BOOKING_REPOSITORY;
    }


}
