package com.example.eksamenbackend.mapper;


import com.example.eksamenbackend.dto.ParticipantDto;
import com.example.eksamenbackend.dto.ResultDto;
import com.example.eksamenbackend.entity.Participant;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class ParticipantMapper {

    public static ParticipantDto mapToDto(Participant participant) {

        Set<UUID> disciplinesIds = new HashSet<UUID>();
        Set<UUID> resultIds = new HashSet<UUID>();

        if (participant.getDisciplines() != null) {
            disciplinesIds = participant.getDisciplines().stream()
                    .map(discipline -> discipline.getId())
                    .collect(Collectors.toSet());
        }

        if (participant.getResults() != null) {
            resultIds = participant.getResults().stream()
                    .map(result -> result.getId())
                    .collect(Collectors.toSet());
        }

        return new ParticipantDto(participant.getId(), participant.getFullName(), participant.getGender(), participant.getAge(), participant.getClub(), disciplinesIds, resultIds);

    }

    public static Participant mapToEntity(ParticipantDto participantDto) {
        Participant participant = new Participant();
        participant.setFullName(participantDto.getFullName());
        participant.setGender(participantDto.getGender());
        participant.setAge(participantDto.getAge());
        participant.setClub(participantDto.getClub());
        participant.setDisciplines(new HashSet<>());
        participant.setResults(new HashSet<>());
        return participant;

    }
}