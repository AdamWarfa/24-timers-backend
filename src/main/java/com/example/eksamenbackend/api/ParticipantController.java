package com.example.eksamenbackend.api;

import com.example.eksamenbackend.dto.ParticipantDto;
import com.example.eksamenbackend.entity.Participant;
import com.example.eksamenbackend.service.ParticipantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/api/participants")
    public List<ParticipantDto> getParticipants() {
        return participantService.getAllParticipants();
    }

    @GetMapping("/api/participants/{id}")
    public ParticipantDto getParticipant(@PathVariable UUID id) {
        return participantService.getParticipant(id);
    }



    @PostMapping("/api/participants")
    public String createHotel(@RequestBody ParticipantDto participantDto) {
        participantService.createParticipant(participantDto);
        return "Participant added!";
    }

    @PutMapping("/api/participants/{id}")
    public String updateHotel(@PathVariable UUID id, @RequestBody ParticipantDto participantDto) {
        participantService.updateParticipant(id, participantDto);
        return "Participant updated!";
    }

    @DeleteMapping("/api/participants/{id}")
    public String deleteHotel(@PathVariable UUID id) {
        participantService.deleteParticipant(id);
        return "Participant deleted!";
    }

}
