package com.bookmystay.app;

/**
 * Use Case 9 – Error Handling & Validation
 *
 * Demonstrates validation and custom exception handling.
 *
 * @author Divya
 * @version 9.0
 */
public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v9.0 =====");

        RoomInventory inventory = new RoomInventory();

        try {
            processBooking("Single Room", inventory);
            processBooking("Suite Room", inventory);
            processBooking("", inventory);              // invalid input
            processBooking("Double Room", inventory);

        } catch (InvalidBookingException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nApplication continues safely...");
        System.out.println("Application terminated.");
    }

    private static void processBooking(String roomType,
                                       RoomInventory inventory)
            throws InvalidBookingException {

        int available = inventory.getAvailability(roomType);

        // validation (fail-fast)
        BookingValidator.validate(roomType, available);

        // if valid → proceed
        inventory.updateAvailability(roomType, available - 1);

        System.out.println("Booking successful for " + roomType);
    }
}