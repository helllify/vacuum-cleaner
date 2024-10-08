package com.example.vacuum_cleaner.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.vacuum_cleaner.dto.*;

import org.springframework.stereotype.Service;

@Service
public class HooverService {

    public HooverResponse execute(HooverRequest request) {
        int x = request.getCoords().get(0);
        int y = request.getCoords().get(1);
        int width = request.getRoomSize().get(0);
        int height = request.getRoomSize().get(1);
        String instructions = request.getInstructions();

        // Convert list of patches to Set for easy lookup
        Set<List<Integer>> patches = new HashSet<>(request.getPatches());
        int cleanedCount = 0;

        // Simulate movements
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'N':
                    if (y < height - 1) y++;
                    break;
                case 'S':
                    if (y > 0) y--;
                    break;
                case 'E':
                    if (x < width - 1) x++;
                    break;
                case 'W':
                    if (x > 0) x--;
                    break;
            }

            // Check if there's a patch of dirt at the new position
            if (patches.contains(List.of(x, y))) {
                cleanedCount++;
                patches.remove(List.of(x, y)); // Clean the patch
            }
        }

        // Return final position and number of patches cleaned
        return new HooverResponse(List.of(x, y), cleanedCount);
    }
}
