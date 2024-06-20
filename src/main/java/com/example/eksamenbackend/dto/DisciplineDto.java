package com.example.eksamenbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
public class DisciplineDto {
    private UUID id;
    private String name;
    private String resultType;

    private Set<ParticipantDto> participants;



    public DisciplineDto(UUID id, String name, String resultType, Set<ParticipantDto> participants) {
        this.id = id;
        this.name = name;
        this.resultType = resultType;
        this.participants = participants;

    }


}
