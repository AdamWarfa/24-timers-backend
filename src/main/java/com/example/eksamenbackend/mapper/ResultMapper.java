package com.example.eksamenbackend.mapper;

import com.example.eksamenbackend.dto.ResultDto;
import com.example.eksamenbackend.entity.Discipline;
import com.example.eksamenbackend.entity.Participant;
import com.example.eksamenbackend.entity.Result;
import com.example.eksamenbackend.repository.DisciplineRepository;
import com.example.eksamenbackend.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultMapper {

    private final ParticipantRepository participantRepository;

    private final DisciplineRepository disciplineRepository;

    public ResultMapper(ParticipantRepository participantRepository, DisciplineRepository disciplineRepository) {
        this.participantRepository = participantRepository;
        this.disciplineRepository = disciplineRepository;
    }

    public ResultDto toDto(Result result) {
        return new ResultDto(result.getId(), result.getResultType(), result.getDate(), result.getResultValue(), result.getParticipant().getId(), result.getDiscipline().getId());
    }

    public Result toEntity(ResultDto resultDto) {
        Result result = new Result();

        result.setResultType(resultDto.getResultType());
        result.setDate(resultDto.getDate());
        result.setResultValue(resultDto.getResultValue());

        // Fetching the participant and discipline from the database
        Participant participant = participantRepository.findById(resultDto.getParticipantId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid participant ID: " + resultDto.getParticipantId()));
        Discipline discipline = disciplineRepository.findById(resultDto.getDisciplineId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid discipline ID: " + resultDto.getDisciplineId()));

        result.setParticipant(participant);
        result.setDiscipline(discipline);

        return result;
    }
}
