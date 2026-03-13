package com.bookmystay.app;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case 5 – Booking Request Queue
 *
 * Demonstrates FIFO request handling using Queue.
 *
 * @author Divya
 * @version 5.1
 */
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v5.1 =====");

        Queue<Reservation> bookingQueue = new LinkedList<>();

        // booking requests added (arrival order)
        bookingQueue.add(new Reservation("Divya", "Single Room"));
        bookingQueue.add(new Reservation("Arun", "Double Room"));
        bookingQueue.add(new Reservation("Meena", "Suite Room"));
        bookingQueue.add(new Reservation("Rahul", "Single Room"));

        System.out.println("\n--- Booking Requests in Queue ---");

        for (Reservation r : bookingQueue) {
            r.displayRequest();
        }

        System.out.println("\nTotal Requests Waiting : "
                + bookingQueue.size());

        System.out.println("\nNo allocation done at this stage.");
        System.out.println("Requests preserved in FIFO order.");

        System.out.println("\nApplication terminated.");
    }
}