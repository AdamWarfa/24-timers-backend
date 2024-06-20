package com.example.eksamenbackend.mapper;

import com.example.eksamenbackend.dto.DisciplineDto;
import com.example.eksamenbackend.entity.Discipline;

import java.util.stream.Collectors;

public class DisciplineMapper {


    public static DisciplineDto toDto(Discipline discipline) {
        return new DisciplineDto(discipline.getId(), discipline.getName(), discipline.getResultType(), discipline.getParticipants().stream().map(ParticipantMapper::mapToDto).collect(Collectors.toSet()));
    }

    public static Discipline toEntity(DisciplineDto disciplineDto) {
        Discipline discipline = new Discipline();
        discipline.setName(disciplineDto.getName());
        discipline.setResultType(disciplineDto.getResultType());
        return discipline;
    }
}
