package com.bookmystay.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookingHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    public void addBooking(Reservation r) {
        history.add(r);
    }

    public List<Reservation> getAllBookings() {
        return history;
    }
}