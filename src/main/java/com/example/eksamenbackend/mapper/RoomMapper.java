package com.example.eksamenbackend.mapper;

import com.example.eksamenbackend.dto.RoomDto;
import com.example.eksamenbackend.entity.Room;

public class RoomMapper {

    public static RoomDto mapToDto(Room room) {
        return new RoomDto(room.getId(),room.getRoomNumber(), room.getNumberOfBeds(), room.getPrice(), room.getHotel().getId());
    }

    public static Room mapToEntity(RoomDto roomDto) {
        return new Room(roomDto.getRoomNumber(), roomDto.getNumberOfBeds(), roomDto.getPrice());
    }
}
