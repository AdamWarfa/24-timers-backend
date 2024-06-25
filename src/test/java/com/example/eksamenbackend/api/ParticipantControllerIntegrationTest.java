package com.example.eksamenbackend.api;

import com.example.eksamenbackend.dto.DisciplineDto;
import com.example.eksamenbackend.dto.ParticipantDto;
import com.example.eksamenbackend.service.ParticipantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
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
@ActiveProfiles("test")
public class ParticipantControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ParticipantService participantService;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @BeforeEach
    public void setup() {



        // Ensure test data setup here
        Set<UUID> disciplineIds = new HashSet<>();
        disciplineIds.add(UUID.fromString("00f9bb73-ee06-41d6-98b8-020d9f97bc60"));

        System.out.println("DataSource URL: " + dataSourceUrl);
        System.out.println("DataSource Username: " + dataSourceUsername);
        System.out.println("DataSource Password: " + dataSourcePassword);

        participantService.createParticipant(new ParticipantDto(
                UUID.randomUUID(), "John Doe", "Male", 30, "Club A", null, new HashSet<>()
        ));
        participantService.createParticipant(new ParticipantDto(
                UUID.randomUUID(), "Jane Smith", "Female", 25, "Club B", null, new HashSet<>()
        ));
    }

    @Test
    public void createDiscipline() throws Exception {
        // Perform POST request
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/api/disciplines")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new DisciplineDto(UUID.fromString("00f9bb73-ee06-41d6-98b8-020d9f97bc60"), "Running", "Track and field", null))));

        // Validate response code and content type
        resultActions.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is("Running")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description", is("Track and field")));
    }


    @Test
    public void testCreateParticipant() throws Exception {

        // Create a participant with a known ID for easier assertion
        UUID participantId = UUID.randomUUID();
        ParticipantDto participantDto = new ParticipantDto(participantId, "John Doe", "Male", 30, "Club A", new HashSet<>(), new HashSet<>());

        // Perform POST request
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/api/participants")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(participantDto)));

        // Validate response code and content type
        resultActions.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(participantId.toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fullName", is("John Doe")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.disciplineIds", hasSize(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.resultIds", hasSize(0)));
    }

    // Utility method to convert object to JSON string
    private static String asJsonString( final Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
