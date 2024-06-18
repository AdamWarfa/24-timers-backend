package com.example.eksamenbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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
    private Guest guest;

    @ManyToOne
    private Room room;

    private int price;

    public Reservation(LocalDate reservationDate, int price) {
        this.reservationDate = reservationDate;
        this.price = price;
    }
}
