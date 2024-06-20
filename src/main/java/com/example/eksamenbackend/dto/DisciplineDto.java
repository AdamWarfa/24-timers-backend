package com.example.eksamenbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class DisciplineDto {
    private UUID id;
    private String name;
    private String resultType;

    public DisciplineDto(UUID id, String name, String resultType) {
        this.id = id;
        this.name = name;
        this.resultType = resultType;
    }
}
