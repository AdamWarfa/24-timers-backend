package com.example.eksamenbackend.mapper;

import com.example.eksamenbackend.dto.DisciplineDto;
import com.example.eksamenbackend.entity.Discipline;

public class DisciplineMapper {

    public static DisciplineDto toDto(Discipline discipline) {
        return new DisciplineDto(discipline.getId(), discipline.getName(), discipline.getResultType());
    }

    public static Discipline toEntity(DisciplineDto disciplineDto) {
        Discipline discipline = new Discipline();
        discipline.setName(disciplineDto.getName());
        discipline.setResultType(disciplineDto.getResultType());
        return discipline;
    }
}
