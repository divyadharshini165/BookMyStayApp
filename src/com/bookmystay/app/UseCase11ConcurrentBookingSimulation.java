package com.bookmystay.app;

/**
 * Use Case 11 – Concurrent Booking Simulation
 *
 * Demonstrates thread-safe booking using synchronization.
 *
 * @author Divya
 * @version 11.0
 */
public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v11.0 =====");

        RoomInventory inventory = new RoomInventory();

        // Set limited rooms to show concurrency issue clearly
        inventory.updateAvailability("Single Room", 2);

        ConcurrentBookingService service =
                new ConcurrentBookingService(inventory);

        // simulate multiple users (threads)
        Thread t1 = new Thread(
                new BookingTask("Divya", "Single Room", service));

        Thread t2 = new Thread(
                new BookingTask("Arun", "Single Room", service));

        Thread t3 = new Thread(
                new BookingTask("Meena", "Single Room", service));

        Thread t4 = new Thread(
                new BookingTask("Kiran", "Single Room", service));

        // start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("\nFinal Availability: "
                + inventory.getAvailability("Single Room"));

        System.out.println("Application terminated.");
    }
}