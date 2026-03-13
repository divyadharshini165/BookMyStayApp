package com.bookmystay.app;

/**
 * Use Case 4 – Room Search & Availability Check
 *
 * Demonstrates safe read-only access to inventory.
 * Displays only available room types.
 *
 * @author Divya
 * @version 4.0
 */
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v4.0 =====");

        // inventory object (state holder)
        RoomInventory inventory = new RoomInventory();

        // domain room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("\n--- Available Rooms ---");

        searchAndDisplay(single, inventory);
        searchAndDisplay(doubleRoom, inventory);
        searchAndDisplay(suite, inventory);

        System.out.println("\nSearch completed.");
        System.out.println("Application terminated.");
    }

    // read-only search method
    private static void searchAndDisplay(Room room,
                                         RoomInventory inventory) {

        int available = inventory.getAvailability(room.roomType);

        if (available > 0) {

            room.displayRoomDetails();
            System.out.println("Available : " + available);
            System.out.println();
        }
    }
}