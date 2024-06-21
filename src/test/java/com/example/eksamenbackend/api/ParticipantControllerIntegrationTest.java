package com.example.eksamenbackend.api;

import com.example.eksamenbackend.dto.ParticipantDto;
import com.example.eksamenbackend.service.ParticipantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ParticipantControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ParticipantService participantService;

    @BeforeEach
    public void setup() {
        // Ensure test data setup here
        Set<UUID> disciplineIds = new HashSet<>();
        disciplineIds.add(UUID.randomUUID());

        participantService.createParticipant(new ParticipantDto(
                UUID.randomUUID(), "John Doe", "Male", 30, "Club A", disciplineIds, new HashSet<>()
        ));
        participantService.createParticipant(new ParticipantDto(
                UUID.randomUUID(), "Jane Smith", "Female", 25, "Club B", disciplineIds, new HashSet<>()
        ));
    }

    @Test
    public void testRemoveDiscipline() throws Exception {
        UUID participantId = participantService.getAllParticipants().get(0).getId();
        UUID disciplineIdToRemove = participantService.getAllParticipants().get(0).getDisciplineIds().iterator().next();

        // Perform PUT request to remove discipline
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.put("/api/participants/{id}/removeDiscipline/{disciplineId}", participantId, disciplineIdToRemove)
                .contentType(MediaType.APPLICATION_JSON));

        // Verify the response
        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.disciplineIds").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.disciplineIds", hasSize(lessThan(1))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.disciplineIds", not(contains(disciplineIdToRemove.toString()))));
    }

    // Utility method to convert object to JSON string
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
