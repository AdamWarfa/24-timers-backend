package com.example.eksamenbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Result {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String resultType;
    private LocalDate date;
    private float resultValue;

    @ManyToOne
    @JoinColumn(name = "participant_id", nullable = false)
    @JsonBackReference
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "discipline_id", nullable = false)
    @JsonBackReference
    private Discipline discipline;

    public Result(String resultType, LocalDate date, float resultValue) {
        this.resultType = resultType;
        this.date = date;
        this.resultValue = resultValue;
    }



}
