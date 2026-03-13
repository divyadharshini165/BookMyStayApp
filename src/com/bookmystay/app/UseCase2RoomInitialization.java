package com.bookmystay.app;

/**
 * Use Case 2 – Room Initialization
 *
 * Demonstrates abstraction, inheritance and
 * static availability handling.
 *
 * @author Divya
 * @version 2.0
 */
public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v2.0 =====");

        // Polymorphic room references
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability variables
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("\n--- Room Details ---");

        single.displayRoomDetails();
        System.out.println("Available : " + singleAvailable);

        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available : " + doubleAvailable);

        System.out.println();

        suite.displayRoomDetails();
        System.out.println("Available : " + suiteAvailable);

        System.out.println("\nApplication terminated.");
    }
}