package com.bookmystay.app;

import java.util.*;

/**
 * Use Case 6 – Reservation Confirmation & Room Allocation
 *
 * Processes booking requests and allocates rooms safely.
 *
 * @author Divya
 * @version 6.0
 */
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v6.0 =====");

        // Inventory (state holder)
        RoomInventory inventory = new RoomInventory();

        // Booking request queue (FIFO)
        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Divya", "Single Room"));
        bookingQueue.add(new Reservation("Arun", "Double Room"));
        bookingQueue.add(new Reservation("Meena", "Suite Room"));
        bookingQueue.add(new Reservation("Rahul", "Single Room"));

        // Allocation tracking structures
        Set<String> allocatedRoomIds = new HashSet<>();
        Map<String, Set<String>> roomTypeAllocations = new HashMap<>();

        System.out.println("\n--- Processing Booking Requests ---");

        while (!bookingQueue.isEmpty()) {

            Reservation request = bookingQueue.poll();

            String roomType = request.getRoomType();
            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                // generate unique room ID
                String roomId = generateRoomId(roomType, allocatedRoomIds);

                // record allocation
                allocatedRoomIds.add(roomId);

                roomTypeAllocations
                        .computeIfAbsent(roomType, k -> new HashSet<>())
                        .add(roomId);

                // update inventory immediately
                inventory.updateAvailability(roomType, available - 1);

                System.out.println("Reservation Confirmed for "
                        + request.getGuestName()
                        + " | Room ID : " + roomId);

            } else {
                System.out.println("Reservation Failed for "
                        + request.getGuestName()
                        + " | No rooms available.");
            }
        }

        System.out.println("\n--- Final Inventory State ---");
        inventory.displayInventory();

        System.out.println("\nApplication terminated.");
    }

    // unique room ID generator
    private static String generateRoomId(String roomType,
                                         Set<String> allocatedIds) {

        String prefix = roomType.substring(0, 1).toUpperCase();
        String roomId;

        do {
            int num = (int) (Math.random() * 100);
            roomId = prefix + num;
        } while (allocatedIds.contains(roomId));

        return roomId;
    }
}