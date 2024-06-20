package com.example.eksamenbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ParticipantDto {
    private UUID id;
    private String fullName;
    private String gender;
    private int age;
    private String club;

    private Set<DisciplineDto> disciplines;
    private Set<ResultDto> results;

    public ParticipantDto(UUID id, String fullName, String gender, int age, String club) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.club = club;;

    }

}
