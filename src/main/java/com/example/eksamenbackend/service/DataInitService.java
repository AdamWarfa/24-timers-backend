package com.example.eksamenbackend.service;

import com.example.eksamenbackend.entity.Participant;
import com.example.eksamenbackend.entity.Result;
import com.example.eksamenbackend.repository.ParticipantRepository;
import com.example.eksamenbackend.repository.ResultRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataInitService {

    private final ParticipantRepository pRepository;
    private final ResultRepository rRepository;

    public DataInitService(ParticipantRepository pRepository, ResultRepository rRepository) {
        this.pRepository = pRepository;
        this.rRepository = rRepository;
    }

    @PostConstruct
    public void init() {
        Random random = new Random();
        List<Participant> participants = new ArrayList<Participant>();
        for (int i = 0; i < 10; i++) {

            Participant participant = new Participant("John" + i, "Male", random.nextInt(100) + 20, "Norway Club");

            /*
            Set<Result> rooms = new HashSet<Result>();

            for (int j = 0; j < 20; j++) {
                Result room = new Result(j, random.nextInt(4) + 1, random.nextInt(1000) + 500);
                room.setHotel(hotel);
                rooms.add(room);
            }

            */
            participants.add(participant);
        }


        pRepository.saveAll(participants);

    }
}
