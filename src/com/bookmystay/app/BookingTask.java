package com.bookmystay.app;

/**
 * Represents a booking task executed by a thread.
 */
public class BookingTask implements Runnable {

    private String guestName;
    private String roomType;
    private ConcurrentBookingService service;

    public BookingTask(String guestName, String roomType,
                       ConcurrentBookingService service) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.service = service;
    }

    @Override
    public void run() {
        service.bookRoom(guestName, roomType);
    }
}