package com.example.vacuum_cleaner.dto;

public class Room {
    private int width;
    private int height;

    // Constructors, Getters, and Setters
    public Room(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
