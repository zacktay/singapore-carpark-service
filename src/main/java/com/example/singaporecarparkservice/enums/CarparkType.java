package com.example.singaporecarparkservice.enums;

import java.util.stream.Stream;

public enum CarparkType {
    BASEMENT("BASEMENT CAR PARK"),
    MULTI_STOREY("MULTI-STOREY CAR PARK"),
    SURFACE("SURFACE CAR PARK"),
    COVERED("COVERED CAR PARK"),
    MECHANISED("MECHANISED CAR PARK"),
    SURFACE_AND_MECAHNISED("MECHANISED AND SURFACE CAR PARK"),
    SURFACE_AND_MULTI_STOREY("SURFACE/MULTI-STOREY CAR PARK");

    private String description;

    CarparkType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static CarparkType getType(String description) {
        return Stream.of(values())
                     .filter(each -> each.getDescription().equalsIgnoreCase(description))
                     .findFirst()
                     .orElseThrow(() -> new RuntimeException("No Carpark Type that matches decriptiont " + description));
    }

}
