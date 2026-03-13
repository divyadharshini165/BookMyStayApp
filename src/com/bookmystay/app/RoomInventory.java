package com.bookmystay.app;

import java.util.HashMap;
import java.util.Map;

/**
 * Centralized Room Inventory Manager
 *
 * Manages availability of rooms using HashMap.
 *
 * @author Divya
 * @version 3.0
 */
public class RoomInventory {

    private Map<String, Integer> inventory;

    // constructor initializes inventory
    public RoomInventory() {

        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // update availability
    public void updateAvailability(String roomType, int newCount) {
        inventory.put(roomType, newCount);
    }

    // display full inventory
    public void displayInventory() {

        System.out.println("\n--- Current Room Inventory ---");

        for (String type : inventory.keySet()) {
            System.out.println(type + " : " + inventory.get(type));
        }
    }
}