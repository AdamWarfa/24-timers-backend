package com.example.eksamenbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private double phoneNumber;
    private LocalDateTime created;
    private LocalDateTime updated;

    @OneToMany(mappedBy = "guest")
    private List<Reservation> reservations;

    public Guest(String username, String firstName, String lastName, String email, double phoneNumber) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }
}
