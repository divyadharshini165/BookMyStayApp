package com.bookmystay.app;

import java.io.*;

/**
 * Handles saving and loading system state.
 */
public class PersistenceService {

    private static final String FILE_NAME = "hotel_data.ser";

    // SAVE
    public static void save(RoomInventory inventory,
                            BookingHistory history) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            oos.writeObject(inventory);
            oos.writeObject(history);

            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // LOAD
    public static Object[] load() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream(FILE_NAME))) {

            RoomInventory inventory =
                    (RoomInventory) ois.readObject();

            BookingHistory history =
                    (BookingHistory) ois.readObject();

            System.out.println("Data loaded successfully.");

            return new Object[]{inventory, history};

        } catch (Exception e) {
            System.out.println("No previous data found. Starting fresh.");
            return null;
        }
    }
}