package com.example.vacuum_cleaner.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.example.vacuum_cleaner.dto.*;

import java.util.Arrays;
import java.util.List;

public class HooverServiceTest {

    @InjectMocks
    private HooverService hooverService;

    public HooverServiceTest() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    public void testHooverMovementAndCleaning() {
        // Given
        HooverRequest request = new HooverRequest();
        request.setRoomSize(Arrays.asList(5, 5)); // Room is 5x5
        request.setCoords(Arrays.asList(1, 2)); // Initial position of the Hoover
        request.setPatches(Arrays.asList(Arrays.asList(1, 0), Arrays.asList(2, 2), Arrays.asList(2, 3))); // Dirt patches
        request.setInstructions("NNESEESWNWW"); // Movement instructions

        // When
        HooverResponse response = hooverService.execute(request);

        // Then
        assertEquals(Arrays.asList(1, 3), response.getCoords()); // Final position should be [1, 3]
        assertEquals(1, response.getPatches()); // Hoover cleaned 1 dirt patch
    }

    @Test
    public void testHooverBoundaryCondition() {
        // Given
        HooverRequest request = new HooverRequest();
        request.setRoomSize(Arrays.asList(5, 5)); // Room is 5x5
        request.setCoords(Arrays.asList(4, 4)); // Initial position at the top right corner
        request.setPatches(Arrays.asList()); // No patches
        request.setInstructions("NEE"); // Move North and East (should not move out of bounds)

        // When
        HooverResponse response = hooverService.execute(request);

        // Then
        assertEquals(Arrays.asList(4, 4), response.getCoords()); // Hoover should stay at [4, 4], no movement out of bounds
        assertEquals(0, response.getPatches()); // No patches cleaned
    }

    @Test
    public void testEmptyInstructions() {
        // Given
        HooverRequest request = new HooverRequest();
        request.setRoomSize(Arrays.asList(5, 5));
        request.setCoords(Arrays.asList(1, 1)); // Initial position of the Hoover
        request.setPatches(Arrays.asList()); // No dirt patches
        request.setInstructions(""); // No instructions

        // When
        HooverResponse response = hooverService.execute(request);

        // Then
        assertEquals(Arrays.asList(1, 1), response.getCoords()); // Hoover remains in its initial position
        assertEquals(0, response.getPatches()); // No patches cleaned
    }
}
