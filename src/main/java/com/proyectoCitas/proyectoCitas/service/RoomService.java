package com.proyectoCitas.proyectoCitas.service;

import com.proyectoCitas.proyectoCitas.entity.Room;

import java.util.List;

public interface RoomService {
    Room createRoom(Room room);
    List<Room> getAllRooms ();
    Room getRoomById (Long roomId);
    Room updateRoom (Long roomId, Room updatedRoom);
    void deleteRoom (Long roomId);

}
