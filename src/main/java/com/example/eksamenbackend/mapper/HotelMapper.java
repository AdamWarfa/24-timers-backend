package com.example.eksamenbackend.mapper;

import com.example.eksamenbackend.dto.HotelDto;
import com.example.eksamenbackend.entity.Hotel;

public class HotelMapper{

    public static HotelDto mapToDto(Hotel hotel) {
        return new HotelDto(hotel.getName(), hotel.getStreet(), hotel.getCity(), hotel.getZip(), hotel.getCountry(), hotel.getRooms());
    }

    public static Hotel mapToEntity(HotelDto hotelDto) {
        return new Hotel(hotelDto.getName(), hotelDto.getStreet(), hotelDto.getCity(), hotelDto.getZip(), hotelDto.getCountry());
    }
}
