package com.example.eksamenbackend.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @GetMapping("/api/hotels")
    public String getHotels() {
        return "Hello, hotels!";
    }

    @GetMapping("/api/hotels/{id}")
    public String getHotel() {
        return "Hello, hotel!";
    }

    @GetMapping("/api/hotels/{id}/rooms")
    public String getRooms() {
        return "Hello, rooms!";
    }



}
