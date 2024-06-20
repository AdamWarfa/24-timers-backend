package com.example.eksamenbackend.service;

import com.example.eksamenbackend.dto.DisciplineDto;
import com.example.eksamenbackend.entity.Discipline;
import com.example.eksamenbackend.mapper.DisciplineMapper;
import com.example.eksamenbackend.repository.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DisciplineService {
    private final DisciplineRepository disciplineRepository;

    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public DisciplineDto getDisciplineById(UUID id) {
        Discipline discipline = disciplineRepository.findById(id).get();

        return DisciplineMapper.toDto(discipline);

    }

    public List<DisciplineDto> getAllDisciplines() {
        List<Discipline> disciplines = disciplineRepository.findAll();

        List<DisciplineDto> disciplineDtos = new ArrayList<DisciplineDto>();

        for (Discipline discipline : disciplines) {
            DisciplineDto disciplineDto = DisciplineMapper.toDto(discipline);
            disciplineDtos.add(disciplineDto);
        }

        return disciplineDtos;
    }


}
