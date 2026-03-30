package com.bookmystay.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores confirmed booking history.
 *
 * @author Divya
 * @version 8.0
 */
public class BookingHistory {

    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    // add confirmed booking
    public void addBooking(Reservation reservation) {
        history.add(reservation);
    }

    // get all bookings
    public List<Reservation> getAllBookings() {
        return history;
    }
}