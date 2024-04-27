package com.proyectoCitas.proyectoCitas.controller;

import com.proyectoCitas.proyectoCitas.entity.Employee;
import com.proyectoCitas.proyectoCitas.entity.Room;
import com.proyectoCitas.proyectoCitas.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
//@RequestMapping("/api/room")
//@RequestMapping (path="/api/room", method = RequestMethod)
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping (path="/api/room", method = RequestMethod.POST)
    public ResponseEntity<Room> createRoom (@RequestBody Room room){
        Room saveRoom =  roomService.createRoom(room);
        return new ResponseEntity<>(saveRoom, HttpStatus.CREATED);
    }

    @RequestMapping (path="/api/room/{id}", method = RequestMethod.GET)
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Long roomId){
        Room room =  roomService.getRoomById(roomId);
        return ResponseEntity.ok(room);
    }

    @RequestMapping (path="/api/room", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> getAllRooms(){
        List<Room> rooms =  roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @RequestMapping (path="/api/room/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Room> updateRoom( @PathVariable("id") Long roomId,@RequestBody Room updatedRoom){
        Room room= roomService.updateRoom(roomId,updatedRoom);
        return ResponseEntity.ok(room);
    }

    @RequestMapping (path="/api/room/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteRoom (@PathVariable("id") Long roomId){
        roomService.deleteRoom(roomId);
        return ResponseEntity.ok("Consultorio eliminado exitosamente!");

    }
}
