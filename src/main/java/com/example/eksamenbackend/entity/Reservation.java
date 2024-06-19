package com.example.eksamenbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private LocalDate reservationDate;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    private LocalDateTime created;
    private LocalDateTime updated;

    private int price;

    public Reservation(LocalDate reservationDate, int price) {
        this.reservationDate = reservationDate;
        this.price = price;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }
}
