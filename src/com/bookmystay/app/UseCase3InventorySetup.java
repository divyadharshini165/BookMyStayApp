package com.bookmystay.app;

/**
 * Use Case 3 – Centralized Inventory Setup
 *
 * Demonstrates HashMap based inventory management.
 *
 * @author Divya
 * @version 3.1
 */
public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v3.1 =====");

        RoomInventory inventory = new RoomInventory();

        inventory.displayInventory();

        System.out.println("\nChecking availability of Double Room:");
        System.out.println("Available : "
                + inventory.getAvailability("Double Room"));

        System.out.println("\nUpdating Suite Room availability to 4");

        inventory.updateAvailability("Suite Room", 4);

        inventory.displayInventory();

        System.out.println("\nApplication terminated.");
    }
}