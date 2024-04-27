package com.proyectoCitas.proyectoCitas.service.impl;

import com.proyectoCitas.proyectoCitas.entity.Room;
import com.proyectoCitas.proyectoCitas.repository.RoomRepository;
import com.proyectoCitas.proyectoCitas.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import com.proyectoCitas.proyectoCitas.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
//    try {
//    }catch(Exception ResourceNotFoundException){
    //throw new ResourceNotFoundException(" ");
    //    }

    @Autowired
    private RoomRepository roomRepository;
    @Override
    public Room createRoom(Room room) {
        Room saveRoom;
        try {
            saveRoom = roomRepository.save(room);
        }catch(Exception ResourceNotFoundException){
            throw new ResourceNotFoundException("error al agregar consultorio");
        }
        return saveRoom;
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> listRooms;
        try {
            listRooms = roomRepository.findAll();
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al obtener lista de consultorios");
        }
        return listRooms;
    }

    @Override
    public Room getRoomById(Long roomId) {
            return roomRepository.findById(roomId) .orElseThrow(() ->
                    new ResourceNotFoundException(("El consultorio no exixte para el id : " + roomId)));
    }

    @Override
    public Room updateRoom(Long roomId, Room updatedRoom) {
        Room getRoom = getRoomById(roomId);
        if(getRoom !=null){
            getRoom.setId(updatedRoom.getId());
            getRoom.setRoomName(updatedRoom.getRoomName());
        }
        Room saveRoom;
        try {
           saveRoom = roomRepository.save(getRoom);
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al modificar el consultorio");
        }
        return saveRoom;
    }

    @Override
    public void deleteRoom(Long roomId) {
        try {
             roomRepository.deleteById(roomId);
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al eliminar consultorio");
        }
    }
}
