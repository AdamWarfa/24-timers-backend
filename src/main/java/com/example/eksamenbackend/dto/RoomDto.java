package com.example.eksamenbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class RoomDto {
    private UUID id;
    private int roomNumber;
    private int numberOfBeds;
    private int price;
    private UUID hotelId;


    public RoomDto(UUID id, int roomNumber, int numberOfBeds, int price, UUID hotelId) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.hotelId = hotelId;

    }
}
