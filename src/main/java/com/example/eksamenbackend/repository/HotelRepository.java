package com.example.eksamenbackend.repository;

import com.example.eksamenbackend.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelRepository extends JpaRepository<Hotel, UUID> {
}
