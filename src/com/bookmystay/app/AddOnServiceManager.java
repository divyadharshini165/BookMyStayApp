package com.bookmystay.app;

import java.util.*;

/**
 * Manages add-on services for reservations.
 *
 * @author Divya
 * @version 7.0
 */
public class AddOnServiceManager {

    private Map<String, List<AddOnService>> serviceMap;

    public AddOnServiceManager() {
        serviceMap = new HashMap<>();
    }

    // attach service to reservation
    public void addService(String reservationId, AddOnService service) {

        serviceMap
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    // display services for a reservation
    public void displayServices(String reservationId) {

        List<AddOnService> services = serviceMap.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No add-on services selected.");
            return;
        }

        double total = 0;

        System.out.println("Services for Reservation " + reservationId);

        for (AddOnService s : services) {
            System.out.println("- " + s.getServiceName()
                    + " : " + s.getCost());
            total += s.getCost();
        }

        System.out.println("Total Add-On Cost : " + total);
    }
}