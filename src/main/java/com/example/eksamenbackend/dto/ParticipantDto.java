package com.example.eksamenbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
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

    private Set<UUID> disciplineIds = new HashSet<>();
    private Set<UUID> resultIds = new HashSet<>();

    public ParticipantDto(UUID id, String fullName, String gender, int age, String club, Set<UUID> disciplineIds, Set<UUID> resultIds) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.club = club;
        this.disciplineIds = disciplineIds;
        this.resultIds = resultIds;
    }

}
