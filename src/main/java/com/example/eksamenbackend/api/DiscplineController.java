package com.example.eksamenbackend.api;

import com.example.eksamenbackend.dto.DisciplineDto;
import com.example.eksamenbackend.service.DisciplineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class DiscplineController {

    private final DisciplineService disciplineService;

    public DiscplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping("/api/disciplines")
    public ResponseEntity<List<DisciplineDto>> getDisciplines() {
        return ResponseEntity.status(200).body(disciplineService.getAllDisciplines());
    }

    @GetMapping("/api/disciplines/{id}")
    public ResponseEntity<DisciplineDto> getDisciplineById(@PathVariable UUID id) {
        return ResponseEntity.status(200).body(disciplineService.getDisciplineById(id));
    }

}
