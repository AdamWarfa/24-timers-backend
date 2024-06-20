package com.example.eksamenbackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String fullName;
    private String gender;
    private int age;
    private String club;

    private LocalDateTime created;
    private LocalDateTime updated;

    @ManyToMany(mappedBy = "participants")
    private Set<Discipline> disciplines;

    @OneToMany(mappedBy = "participant")
    @JsonManagedReference
    private Set<Result> results;


    public Participant(String fullName, String gender, int age, String club) {
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.club = club;
        this.disciplines = new HashSet<Discipline>();
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();

    }
}
