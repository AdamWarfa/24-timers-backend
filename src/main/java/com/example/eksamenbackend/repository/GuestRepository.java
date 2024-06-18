package com.example.eksamenbackend.repository;

import com.example.eksamenbackend.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GuestRepository extends JpaRepository<Guest, UUID> {
}
