package com.example.eksamenbackend.repository;

import com.example.eksamenbackend.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResultRepository extends JpaRepository<Result, UUID>{
}
