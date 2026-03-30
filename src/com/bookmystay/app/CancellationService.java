package com.bookmystay.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Handles booking cancellation and inventory rollback.
 */
public class CancellationService {

    // reservationId -> roomType
    private Map<String, String> activeReservations = new HashMap<>();

    // roomType -> stack of released roomIds (LIFO rollback)
    private Map<String, Stack<String>> rollbackStack = new HashMap<>();

    public void registerReservation(String reservationId,
                                    String roomType,
                                    String roomId) {

        activeReservations.put(reservationId, roomType);

        rollbackStack.putIfAbsent(roomType, new Stack<>());
        rollbackStack.get(roomType).push(roomId);
    }

    public void cancelReservation(String reservationId,
                                  RoomInventory inventory)
            throws InvalidBookingException {

        if (!activeReservations.containsKey(reservationId)) {
            throw new InvalidBookingException("Reservation not found.");
        }

        String roomType = activeReservations.get(reservationId);

        Stack<String> stack = rollbackStack.get(roomType);

        if (stack == null || stack.isEmpty()) {
            throw new InvalidBookingException("No allocated rooms to rollback.");
        }

        // LIFO rollback
        String releasedRoomId = stack.pop();

        // restore inventory
        int current = inventory.getAvailability(roomType);
        inventory.updateAvailability(roomType, current + 1);

        // remove reservation
        activeReservations.remove(reservationId);

        System.out.println("Cancelled Reservation: " + reservationId);
        System.out.println("Released Room ID: " + releasedRoomId);
    }
}