package com.example.eksamenbackend.mapper;

import com.example.eksamenbackend.dto.HotelDto;
import com.example.eksamenbackend.dto.RoomDto;
import com.example.eksamenbackend.entity.Hotel;

import java.util.Set;
import java.util.stream.Collectors;

public class HotelMapper{

    public static HotelDto mapToDto(Hotel hotel) {

        Set<RoomDto> rooms = hotel.getRooms().stream().map(RoomMapper::mapToDto).collect(Collectors.toSet());

        return new HotelDto(hotel.getId(), hotel.getName(), hotel.getStreet(), hotel.getCity(), hotel.getZip(), hotel.getCountry(), rooms);
    }

    public static Hotel mapToEntity(HotelDto hotelDto) {
        return new Hotel(hotelDto.getName(), hotelDto.getStreet(), hotelDto.getCity(), hotelDto.getZip(), hotelDto.getCountry());
    }
}
