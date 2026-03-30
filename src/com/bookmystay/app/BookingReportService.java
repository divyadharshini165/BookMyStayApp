package com.bookmystay.app;

import java.util.List;

/**
 * Generates reports from booking history.
 *
 * @author Divya
 * @version 8.0
 */
public class BookingReportService {

    public void generateReport(List<Reservation> bookings) {

        System.out.println("\n--- Booking History Report ---");

        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        int count = 0;

        for (Reservation r : bookings) {
            System.out.println("Guest : " + r.getGuestName()
                    + " | Room : " + r.getRoomType());
            count++;
        }

        System.out.println("\nTotal Bookings : " + count);
    }
}