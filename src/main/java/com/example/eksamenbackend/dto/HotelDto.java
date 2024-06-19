package com.example.eksamenbackend.dto;

import com.example.eksamenbackend.entity.Room;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
public class HotelDto {
    private UUID id;
    private String name;
    private String street;
    private String city;
    private int zip;
    private String country;
    private Set<RoomDto> rooms;

    public HotelDto(UUID id, String name, String street, String city, int zip, String country, Set<RoomDto> rooms) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.rooms = rooms;
    }

}
