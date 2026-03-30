package com.bookmystay.app;

/**
 * Use Case 7 – Add-On Service Selection
 *
 * Demonstrates attaching optional services to a reservation.
 *
 * @author Divya
 * @version 7.1
 */
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v7.1 =====");

        // sample reservation ID (from UC-6)
        String reservationId = "S101";

        AddOnServiceManager manager = new AddOnServiceManager();

        // guest selects services
        manager.addService(reservationId,
                new AddOnService("Breakfast", 500));

        manager.addService(reservationId,
                new AddOnService("Airport Pickup", 1200));

        manager.addService(reservationId,
                new AddOnService("Extra Bed", 800));

        System.out.println("\n--- Add-On Services Selected ---");

        manager.displayServices(reservationId);

        System.out.println("\nCore booking and inventory unchanged.");
        System.out.println("Application terminated.");
    }
}