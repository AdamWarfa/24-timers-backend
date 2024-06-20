package com.example.eksamenbackend.service;

import com.example.eksamenbackend.dto.ResultDto;
import com.example.eksamenbackend.entity.Result;
import com.example.eksamenbackend.mapper.ResultMapper;
import com.example.eksamenbackend.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ResultService {

    private final ResultRepository resultRepository;
    private final ResultMapper resultMapper;

    public ResultService(ResultRepository resultRepository, ResultMapper resultMapper) {
        this.resultRepository = resultRepository;
        this.resultMapper = resultMapper;
    }




    public void deleteResultById(UUID id) {
        resultRepository.deleteById(id);
    }

    public List<ResultDto> getAllResults() {
        List<Result> resultList = resultRepository.findAll();

        List<ResultDto> resultDtos = new ArrayList<ResultDto>();

        for (Result result : resultList) {
            ResultDto resultDto = resultMapper.toDto(result);
            resultDtos.add(resultDto);

        }

        return resultDtos;

    }

    public ResultDto getResult(UUID id) {
        Result result = resultRepository.findById(id).orElse(null);
        if (result == null) {
            return null;
        }
        return resultMapper.toDto(result);
    }

    public void createResult(ResultDto resultDto) {
        Result result = resultMapper.toEntity(resultDto);
        resultRepository.save(result);
    }
}
