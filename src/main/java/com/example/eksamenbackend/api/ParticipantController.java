package com.example.eksamenbackend.api;

import com.example.eksamenbackend.dto.ParticipantDto;
import com.example.eksamenbackend.entity.Participant;
import com.example.eksamenbackend.service.ParticipantService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ParticipantDto>> getParticipants() {

        return ResponseEntity.status(200).body(participantService.getAllParticipants());
    }

    @GetMapping("/api/participants/{id}")
    public ResponseEntity<ParticipantDto> getParticipant(@PathVariable UUID id) {

        if (id == null) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.status(200).body(participantService.getParticipant(id));

    }



    @PostMapping("/api/participants")
    public ResponseEntity<ParticipantDto> createHotel(@RequestBody ParticipantDto participantDto) {
        participantService.createParticipant(participantDto);
        return ResponseEntity.status(201).body(participantDto);
    }

    @PutMapping("/api/participants/{id}")
    public ResponseEntity<ParticipantDto> updateHotel(@PathVariable UUID id, @RequestBody ParticipantDto participantDto) {
        participantService.updateParticipant(id, participantDto);
        return ResponseEntity.status(200).body(participantDto);
    }

    @PutMapping("/api/participants/{id}/removeDiscipline/{disciplineId}")
    public ResponseEntity<ParticipantDto> removeDiscipline(@PathVariable UUID id, @PathVariable UUID disciplineId) {
        participantService.removeDiscipline(id, disciplineId);
        return ResponseEntity.status(200).body(participantService.getParticipant(id));
    }

    @DeleteMapping("/api/participants/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable UUID id) {
        participantService.deleteParticipant(id);
        return ResponseEntity.status(204).body(null);
    }

}
