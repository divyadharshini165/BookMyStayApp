package com.bookmystay.app;

/**
 * Validates booking input and system state.
 */
public class BookingValidator {

    public static void validate(String roomType, int available)
            throws InvalidBookingException {

        if (roomType == null || roomType.isEmpty()) {
            throw new InvalidBookingException("Room type cannot be empty.");
        }

        if (available < 0) {
            throw new InvalidBookingException("Invalid inventory state.");
        }

        if (available == 0) {
            throw new InvalidBookingException(
                    "No rooms available for " + roomType);
        }
    }
}