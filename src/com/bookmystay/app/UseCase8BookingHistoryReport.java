package com.bookmystay.app;

/**
 * Use Case 8 – Booking History & Reporting
 *
 * Demonstrates storing and reporting booking history.
 *
 * @author Divya
 * @version 8.1
 */
public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v8.1 =====");

        BookingHistory history = new BookingHistory();

        // simulate confirmed bookings (from UC-6)
        history.addBooking(new Reservation("Divya", "Single Room"));
        history.addBooking(new Reservation("Arun", "Double Room"));
        history.addBooking(new Reservation("Meena", "Suite Room"));

        BookingReportService reportService = new BookingReportService();

        reportService.generateReport(history.getAllBookings());

        System.out.println("\nReporting completed.");
        System.out.println("Application terminated.");
    }
}