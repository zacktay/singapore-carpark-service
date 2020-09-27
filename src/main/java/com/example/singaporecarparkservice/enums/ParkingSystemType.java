package com.example.singaporecarparkservice.enums;

import java.util.stream.Stream;

public enum ParkingSystemType {
    ELECTRONIC("ELECTRONIC PARKING"),
    COUPON("COUPON PARKING");

    private String description;

    ParkingSystemType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ParkingSystemType getType(String description) {
        return Stream.of(values())
                     .filter(each -> each.getDescription().equalsIgnoreCase(description))
                     .findFirst()
                     .orElseThrow(() -> new RuntimeException("No Parking System Type that matches decriptiont " + description));
    }

}
