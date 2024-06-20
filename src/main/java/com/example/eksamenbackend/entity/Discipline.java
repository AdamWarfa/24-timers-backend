package com.example.eksamenbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Discipline {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private String resultType;

    @ManyToMany
    @JoinTable(
            name = "participant_discipline",
            joinColumns = @JoinColumn(name = "discipline_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id"))
    private Set<Participant> participants;

    @OneToMany(mappedBy = "discipline")
    private Set<Result> results;

public Discipline(String name, String resultType) {
        this.name = name;
        this.resultType = resultType;
    }
}
