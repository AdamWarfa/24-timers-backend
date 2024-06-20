package com.example.eksamenbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ResultDto {
    private UUID id;
    private String resultType;
    private LocalDate date;
    private float resultValue;

    private UUID participantId;

    private UUID disciplineId;


    public ResultDto(UUID id, String resultType, LocalDate date, float resultValue, UUID participantId, UUID disciplineId) {
        this.id = id;
        this.resultType = resultType;
        this.date = date;
        this.resultValue = resultValue;
        this.participantId = participantId;
        this.disciplineId = disciplineId;
    }
}
