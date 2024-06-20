package com.example.eksamenbackend.service;

import com.example.eksamenbackend.dto.ParticipantDto;
import com.example.eksamenbackend.entity.Discipline;
import com.example.eksamenbackend.entity.Participant;
import com.example.eksamenbackend.mapper.ParticipantMapper;
import com.example.eksamenbackend.repository.DisciplineRepository;
import com.example.eksamenbackend.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    private final ParticipantRepository pRepository;
    private final DisciplineRepository disciplineRepository;

    public ParticipantService(ParticipantRepository pRepository, DisciplineRepository disciplineRepository) {
        this.pRepository = pRepository;
        this.disciplineRepository = disciplineRepository;
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

        if (participantDto.getDisciplineIds() != null) {
            for (UUID id : participantDto.getDisciplineIds()) {
                Discipline discipline = disciplineRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Discipline not found with id: " + id));
                participant.getDisciplines().add(discipline);
                discipline.getParticipants().add(participant);

            }
        }

        pRepository.save(participant);
    }

    public void updateParticipant(UUID id, ParticipantDto participantDto) {
        Participant participant = ParticipantMapper.mapToEntity(participantDto);

        if (participantDto.getDisciplineIds() != null) {
            for (UUID disciplineId : participantDto.getDisciplineIds()) {
                Discipline discipline = disciplineRepository.findById(disciplineId)
                        .orElseThrow(() -> new IllegalArgumentException("Discipline not found with id: " + disciplineId));
                participant.getDisciplines().add(discipline);
                discipline.getParticipants().add(participant);

            }
        }
        participant.setId(id);
        pRepository.save(participant);
    }

    public void removeDiscipline(UUID id, UUID disciplineId) {
        Participant participant = pRepository.findById(id).get();
        Discipline discipline = disciplineRepository.findById(disciplineId).get();

        participant.getDisciplines().remove(discipline);
        discipline.getParticipants().remove(participant);

        pRepository.save(participant);
    }

    public void deleteParticipant(UUID id) {
        pRepository.deleteById(id);

    }


}
