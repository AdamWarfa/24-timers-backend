package com.example.eksamenbackend.service;

import com.example.eksamenbackend.entity.Hotel;
import com.example.eksamenbackend.entity.Room;
import com.example.eksamenbackend.repository.HotelRepository;
import com.example.eksamenbackend.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DataInitService {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    public DataInitService(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    public void init() {
        Random random = new Random();
        List<Hotel> hotels = new ArrayList<Hotel>();
        for (int i = 0; i < 250; i++) {

            Hotel hotel = new Hotel("Hotel " + i, "Street " + i, "City " + i, 1000 + i, "Country " + i);
            hotels.add(hotel);
            hotelRepository.save(hotel);

            List<Room> rooms = new ArrayList<Room>();

            for (int j = 0; j < 20; j++) {
                Room room = new Room(j, random.nextInt(3) + 1, random.nextInt(1000) + 500);
                room.setHotel(hotel);
                rooms.add(room);
            }
        }




    }
}
