package com.example.eksamenbackend.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    @GetMapping("/api/reservations")
    public String getReservations() {
        return "Hello, reservations!";
    }
    @GetMapping("/api/reservations/{id}")
    public String getReservation() {
        return "Hello, reservation!";
    }
}