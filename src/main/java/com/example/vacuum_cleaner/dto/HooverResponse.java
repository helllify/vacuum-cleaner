package com.example.vacuum_cleaner.dto;

import java.util.List;

public class HooverResponse {
    private List<Integer> coords;
    private int patchesCleaned;

    // Constructor, Getters, and Setters
    public HooverResponse(List<Integer> coords, int patchesCleaned) {
        this.coords = coords;
        this.patchesCleaned = patchesCleaned;
    }

    public List<Integer> getCoords() {
        return coords;
    }

    public int getPatchesCleaned() {
        return patchesCleaned;
    }
}
