package com.example.eksamenbackend.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @GetMapping("/api/rooms")
    public String getRooms() {
        return "Hello, rooms!";
    }

    @GetMapping("/api/rooms/{id}")
    public String getRoom() {
        return "Hello, room!";
    }

}
