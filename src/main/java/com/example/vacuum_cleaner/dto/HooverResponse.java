package com.example.vacuum_cleaner.dto;

import java.util.List;

public class HooverResponse {
    private List<Integer> coords;
    private int patches;

    // Constructor, Getters, and Setters
    public HooverResponse(List<Integer> coords, int patches) {
        this.coords = coords;
        this.patches = patches;
    }

    public List<Integer> getCoords() {
        return coords;
    }

    public int getPatches() {
        return patches;
    }
}
