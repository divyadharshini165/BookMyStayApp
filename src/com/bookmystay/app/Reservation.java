package com.bookmystay.app;

/**
 * Represents a guest booking request.
 *
 * @author Divya
 * @version 5.0
 */
public class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayRequest() {
        System.out.println("Guest : " + guestName +
                " | Requested Room : " + roomType);
    }
}