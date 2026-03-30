package com.bookmystay.app;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RoomInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    // ✅ ADD METHOD INSIDE CLASS
    public void displayInventory() {
        System.out.println("\n--- Room Inventory ---");

        for (String type : inventory.keySet()) {
            System.out.println(type + " : " + inventory.get(type));
        }
    }
}