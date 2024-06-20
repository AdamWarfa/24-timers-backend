package com.example.eksamenbackend.service;

import com.example.eksamenbackend.dto.ParticipantDto;
import com.example.eksamenbackend.entity.Participant;
import com.example.eksamenbackend.mapper.ParticipantMapper;
import com.example.eksamenbackend.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    private final ParticipantRepository pRepository;

    public ParticipantService(ParticipantRepository pRepository) {
        this.pRepository = pRepository;
    }




    public List<ParticipantDto> getAllParticipants() {
        List<Participant> participants = pRepository.findAll();

        List<ParticipantDto> participantDtos = new ArrayList<ParticipantDto>();

        for (Participant participant : participants) {
            ParticipantDto participantDto = ParticipantMapper.mapToDto(participant);
            participantDtos.add(participantDto);
        }

        return participantDtos;

    }

    public ParticipantDto getParticipant(UUID id) {
        Participant participant = pRepository.findById(id).get();
        return ParticipantMapper.mapToDto(participant);
    }

    public void createParticipant(ParticipantDto participantDto) {
        Participant participant = ParticipantMapper.mapToEntity(participantDto);
        pRepository.save(participant);
    }

    public void updateParticipant(UUID id, ParticipantDto participantDto) {
        Participant participant = ParticipantMapper.mapToEntity(participantDto);
        participant.setId(id);
        pRepository.save(participant);
    }

    public void deleteParticipant(UUID id) {
        pRepository.deleteById(id);

    }


}
