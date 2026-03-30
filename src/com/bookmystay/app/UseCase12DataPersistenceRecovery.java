package com.bookmystay.app;

/**
 * Use Case 12 – Data Persistence & Recovery
 *
 * Demonstrates saving and restoring system state.
 *
 * @author Divya
 * @version 12.0
 */
public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v12.0 =====");

        RoomInventory inventory;
        BookingHistory history;

        // LOAD previous state
        Object[] data = PersistenceService.load();

        if (data != null) {
            inventory = (RoomInventory) data[0];
            history = (BookingHistory) data[1];
        } else {
            inventory = new RoomInventory();
            history = new BookingHistory();
        }

        // simulate booking
        history.addBooking(new Reservation("Divya", "Single Room"));
        inventory.updateAvailability("Single Room",
                inventory.getAvailability("Single Room") - 1);

        System.out.println("Current Availability: "
                + inventory.getAvailability("Single Room"));

        // SAVE state
        PersistenceService.save(inventory, history);

        System.out.println("Application terminated.");
    }
}