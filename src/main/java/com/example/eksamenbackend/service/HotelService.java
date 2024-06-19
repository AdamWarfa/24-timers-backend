package com.example.eksamenbackend.service;

import com.example.eksamenbackend.dto.HotelDto;
import com.example.eksamenbackend.entity.Hotel;
import com.example.eksamenbackend.mapper.HotelMapper;
import com.example.eksamenbackend.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public void createHotel(HotelDto hotelDto) {
        Hotel hotel = HotelMapper.mapToEntity(hotelDto);
        hotelRepository.save(hotel);
    }

    public List<HotelDto> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();

        List<HotelDto> hotelDtos = new ArrayList<HotelDto>();

        for (Hotel hotel : hotels) {
           HotelDto hotelDto = HotelMapper.mapToDto(hotel);
              hotelDtos.add(hotelDto);
        }

        return hotelDtos;


    }
}
