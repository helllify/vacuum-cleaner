package com.example.vacuum_cleaner.dto;


import java.util.List;

public class HooverRequest {
    private List<Integer> roomSize; // [width, height]
    private List<Integer> coords; // Hoover starting coordinates [x, y]
    private List<List<Integer>> patches; // List of dirt patches coordinates [[x1, y1], [x2, y2], ...]
    private String instructions; // Driving instructions, e.g. "NNESEESWNWW"

    // Getters and Setters
    public List<Integer> getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(List<Integer> roomSize) {
        this.roomSize = roomSize;
    }

    public List<Integer> getCoords() {
        return coords;
    }

    public void setCoords(List<Integer> coords) {
        this.coords = coords;
    }

    public List<List<Integer>> getPatches() {
        return patches;
    }

    public void setPatches(List<List<Integer>> patches) {
        this.patches = patches;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
