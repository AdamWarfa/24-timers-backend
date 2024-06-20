package com.example.eksamenbackend.mapper;


import com.example.eksamenbackend.dto.ParticipantDto;
import com.example.eksamenbackend.dto.ResultDto;
import com.example.eksamenbackend.entity.Discipline;
import com.example.eksamenbackend.entity.Participant;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ParticipantMapper {

    public static ParticipantDto mapToDto(Participant participant) {

        /*
        Set<ResultDto> resultDtos = participant.getResults().stream()
                .map(ResultMapper::mapToDto)
                .collect(Collectors.toSet());

         */

        return new ParticipantDto(participant.getId(), participant.getFullName(), participant.getGender(), participant.getAge(), participant.getClub(), participant.getDisciplines().stream().map(Discipline::getId).collect(Collectors.toSet()));

    }

    public static Participant mapToEntity(ParticipantDto participantDto) {
        Participant participant = new Participant();
        participant.setFullName(participantDto.getFullName());
        participant.setGender(participantDto.getGender());
        participant.setAge(participantDto.getAge());
        participant.setClub(participantDto.getClub());
        participant.setDisciplines(new HashSet<>());
        return participant;

    }
}