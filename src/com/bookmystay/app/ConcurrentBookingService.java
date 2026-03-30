package com.bookmystay.app;

/**
 * Handles thread-safe booking operations.
 */
public class ConcurrentBookingService {

    private RoomInventory inventory;

    public ConcurrentBookingService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    // synchronized → critical section
    public synchronized void bookRoom(String guest, String roomType) {

        int available = inventory.getAvailability(roomType);

        if (available > 0) {
            inventory.updateAvailability(roomType, available - 1);

            System.out.println(Thread.currentThread().getName()
                    + " booked " + roomType
                    + " for " + guest
                    + " | Remaining: "
                    + inventory.getAvailability(roomType));
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " FAILED for " + guest
                    + " (No rooms available)");
        }
    }
}