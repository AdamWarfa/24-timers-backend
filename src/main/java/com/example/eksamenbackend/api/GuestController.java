package com.example.eksamenbackend.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController {
    @GetMapping("/api/guests")
    public String getGuests() {
        return "Hello, guests!";
    }

    @GetMapping("/api/guests/{id}")
    public String getGuest() {
        return "Hello, guest!";
    }

}
