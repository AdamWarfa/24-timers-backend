package com.example.eksamenbackend.repository;

import com.example.eksamenbackend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID>{
}
