package com.example.eksamenbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private int roomNumber;
    private int numberOfBeds;
    private int price;
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;

    public Room(int roomNumber, int numberOfBeds, int price) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.price = price;
    }
}
