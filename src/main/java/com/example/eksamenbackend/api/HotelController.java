package com.example.eksamenbackend.api;

import com.example.eksamenbackend.dto.HotelDto;
import com.example.eksamenbackend.service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/api/hotels")
    public List<HotelDto> getHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/api/hotels/{id}")
    public String getHotel() {
        return "Hello, hotel!";
    }

    @GetMapping("/api/hotels/{id}/rooms")
    public String getRooms() {
        return "Hello, rooms!";
    }


    @PostMapping("/api/hotels")
    public String createHotel(@RequestBody HotelDto hotelDto) {
        hotelService.createHotel(hotelDto);
        return "Hotel created!";
    }


}
