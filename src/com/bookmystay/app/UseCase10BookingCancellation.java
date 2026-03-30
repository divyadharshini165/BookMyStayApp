package com.bookmystay.app;

/**
 * Use Case 10 – Booking Cancellation & Inventory Rollback
 *
 * Demonstrates safe cancellation using Stack (LIFO).
 *
 * @author Divya
 * @version 10.0
 */
public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v10.0 =====");

        RoomInventory inventory = new RoomInventory();
        CancellationService service = new CancellationService();

        try {
            // simulate confirmed bookings
            service.registerReservation("R1", "Single Room", "S101");
            service.registerReservation("R2", "Single Room", "S102");

            // reduce inventory manually (simulate UC6)
            inventory.updateAvailability("Single Room",
                    inventory.getAvailability("Single Room") - 2);

            System.out.println("Before cancellation:");
            System.out.println("Single Room Available: "
                    + inventory.getAvailability("Single Room"));

            // cancel latest booking (LIFO)
            service.cancelReservation("R2", inventory);

            System.out.println("\nAfter cancellation:");
            System.out.println("Single Room Available: "
                    + inventory.getAvailability("Single Room"));

            // invalid cancellation
            service.cancelReservation("R5", inventory);

        } catch (InvalidBookingException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nApplication terminated.");
    }
}