package com.example.eksamenbackend.repository;

import com.example.eksamenbackend.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {
}
