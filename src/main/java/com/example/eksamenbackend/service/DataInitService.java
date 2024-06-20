package com.example.eksamenbackend.service;

import com.example.eksamenbackend.entity.Discipline;
import com.example.eksamenbackend.entity.Participant;
import com.example.eksamenbackend.entity.Result;
import com.example.eksamenbackend.repository.DisciplineRepository;
import com.example.eksamenbackend.repository.ParticipantRepository;
import com.example.eksamenbackend.repository.ResultRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataInitService {

    private final ParticipantRepository pRepository;
    private final ResultRepository rRepository;
    private final DisciplineRepository disciplineRepository;
    public DataInitService(ParticipantRepository pRepository, ResultRepository rRepository, DisciplineRepository disciplineRepository) {
        this.pRepository = pRepository;
        this.rRepository = rRepository;
        this.disciplineRepository = disciplineRepository;
    }

    @PostConstruct
    public void initParticipants() {
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


    @PostConstruct
    public void initDisciplines() {
        Map<String, String> disciplineResultTypes = new HashMap<>();
        disciplineResultTypes.put("1-milløb (atletik)", "Tid");
        disciplineResultTypes.put("10.000-meterløb (atletik)", "Tid");
        disciplineResultTypes.put("100-meterløb (atletik)", "Tid");
        disciplineResultTypes.put("110 meter hækkeløb", "Tid");
        disciplineResultTypes.put("1500-meterløb (atletik)", "Tid");
        disciplineResultTypes.put("200 meter hækkeløb", "Tid");
        disciplineResultTypes.put("200-meterløb (atletik)", "Tid");
        disciplineResultTypes.put("3000-meterløb (atletik)", "Tid");
        disciplineResultTypes.put("4 × 100-meterløb (atletik)", "Tid");
        disciplineResultTypes.put("4 × 400-meterløb (atletik)", "Tid");
        disciplineResultTypes.put("400 meter hækkeløb", "Tid");
        disciplineResultTypes.put("400-meterløb (atletik)", "Tid");
        disciplineResultTypes.put("4x400-meterløb blandet hold (atletik)", "Tid");
        disciplineResultTypes.put("5000-meter-løb (atletik)", "Tid");
        disciplineResultTypes.put("60 meter hækkeløb", "Tid");
        disciplineResultTypes.put("60-meterløb (atletik)", "Tid");
        disciplineResultTypes.put("800-meterløb (atletik)", "Tid");
        disciplineResultTypes.put("Cross (løbesport)", "Tid");
        disciplineResultTypes.put("Diskoskast (atletik)", "Meter");
        disciplineResultTypes.put("Femkamp (atletik)", "Point");
        disciplineResultTypes.put("Forhindringsløb (atletik)", "Tid");
        disciplineResultTypes.put("Halvmaratonløb (løbesport)", "Tid");
        disciplineResultTypes.put("Hammerkast (atletik)", "Meter");
        disciplineResultTypes.put("Højdespring (atletik)", "Meter");
        disciplineResultTypes.put("Højdespring uden tilløb (atletik)", "Meter");
        disciplineResultTypes.put("Kastefemkamp (atletik)", "Point");
        disciplineResultTypes.put("Kastetrekamp", "Point");
        disciplineResultTypes.put("Kuglestød (atletik)", "Meter");
        disciplineResultTypes.put("Kørestolsrace", "Tid");
        disciplineResultTypes.put("Længdespring (atletik)", "Meter");
        disciplineResultTypes.put("Længdespring uden tilløb (atletik)", "Meter");
        disciplineResultTypes.put("Maratonløb (løbesport)", "Tid");
        disciplineResultTypes.put("Slyngboldkast (atletik)", "Meter");
        disciplineResultTypes.put("Spydkast (atletik)", "Meter");
        disciplineResultTypes.put("Stangspring (atletik)", "Meter");
        disciplineResultTypes.put("Syvkamp (atletik)", "Point");
        disciplineResultTypes.put("Tikamp (atletik)", "Point");
        disciplineResultTypes.put("Tovtrækning", "Tid");
        disciplineResultTypes.put("Trail (løbesport)", "Tid");
        disciplineResultTypes.put("Trespring (atletik)", "Meter");
        disciplineResultTypes.put("Trespring uden tilløb (atletik)", "Meter");
        disciplineResultTypes.put("Vægtkast (atletik)", "Meter");

        Set<Discipline> disciplines = new HashSet<>();
        for (Map.Entry<String, String> entry : disciplineResultTypes.entrySet()) {
            Discipline discipline = new Discipline(entry.getKey(), entry.getValue());
            disciplines.add(discipline);
        }

        disciplineRepository.saveAll(disciplines);
    }
}
