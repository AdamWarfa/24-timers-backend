package com.example.eksamenbackend.api;

import com.example.eksamenbackend.dto.ResultDto;
import com.example.eksamenbackend.service.ResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }


    @GetMapping("/api/results")
    public ResponseEntity<List<ResultDto>> getResults() {
        return ResponseEntity.status(200).body(resultService.getAllResults());
    }

    @GetMapping("/api/results/{id}")
    public ResponseEntity<ResultDto> getResult(@PathVariable UUID id) {
        if (id == null) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.status(200).body(resultService.getResult(id));
    }

    @PostMapping("/api/results")
    public ResponseEntity<ResultDto> createResult(@RequestBody ResultDto resultDto) {
        resultService.createResult(resultDto);
        return ResponseEntity.status(201).body(resultDto);
    }

}
