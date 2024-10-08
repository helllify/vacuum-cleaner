package com.example.vacuum_cleaner.controler;;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.vacuum_cleaner.dto.*;
import com.example.vacuum_cleaner.service.HooverService;
import com.example.vacuum_cleaner.VacuumCleanerApplication;


import java.util.Arrays;

@WebMvcTest(HooverController.class)
@ContextConfiguration(classes = VacuumCleanerApplication.class)
public class HooverControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HooverService hooverService; // Mock HooverService

    @InjectMocks
    private HooverController hooverController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testCleanRoomEndpoint() throws Exception {
        // Given
        HooverRequest request = new HooverRequest();
        request.setRoomSize(Arrays.asList(5, 5));
        request.setCoords(Arrays.asList(1, 2));
        request.setPatches(Arrays.asList(Arrays.asList(1, 0), Arrays.asList(2, 2), Arrays.asList(2, 3)));
        request.setInstructions("NNESEESWNWW");

        HooverResponse response = new HooverResponse(Arrays.asList(1, 3), 1);

        // Mock the service behavior
        when(hooverService.execute(request)).thenReturn(response);

        // When & Then: Use MockMvc to simulate the POST request and check the response
        mockMvc.perform(post("/hoover/clean")
                .contentType("application/json")
                .accept("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andDo(print()) 
                .andExpect(status().isOk()); // Expecting 200 OK
                // .andExpect(jsonPath("$.coords[0]").value(1)) // Check first coord
                // .andExpect(jsonPath("$.coords[1]").value(3)) // Check second coord
                // .andExpect(jsonPath("$.patches").value(1)); // Check patches cleaned
    }
}