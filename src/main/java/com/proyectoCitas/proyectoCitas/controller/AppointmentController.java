package com.proyectoCitas.proyectoCitas.controller;

import com.proyectoCitas.proyectoCitas.entity.Appointment;
import com.proyectoCitas.proyectoCitas.service.AppointmentService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
//@RequestMapping("/api/appointment")
//@RequestMapping (path="/api/appointment", method = RequestMethod)
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping (path="/api/appointment", method = RequestMethod.POST)
    public ResponseEntity<Appointment> createAppointment (@RequestBody Appointment appointment){
        Appointment saveAppointment =  appointmentService.createAppointment(appointment);
        return new ResponseEntity<>(saveAppointment, HttpStatus.CREATED);
    }

    @RequestMapping (path="/api/appointment/{id}", method = RequestMethod.GET)
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") Long appointmentId){
        Appointment Appointment =  appointmentService.getAppointmentById (appointmentId);
        return ResponseEntity.ok(Appointment);
    }

    @RequestMapping (path="/api/appointment", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        List<Appointment> appointments =  appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    @RequestMapping (path="/api/appointment/todayAppointments/{date}", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> getTodayAppointments(@PathVariable("date") String date){
        List<Appointment> appointments =  appointmentService.getTodayAppointments(date);
        return ResponseEntity.ok(appointments);
    }


    @RequestMapping (path="/api/appointment/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") Long appointmentId, @RequestBody Appointment updatedAppointment){
        Appointment Appointment= appointmentService.updateAppointment(appointmentId,updatedAppointment);
        return ResponseEntity.ok(Appointment);
    }

    @RequestMapping (path="/api/appointment/changestatus/{id}/{status}/{date}", method = RequestMethod.PUT)
    public ResponseEntity<Appointment> changeStatusAppointment(@PathVariable("id") Long appointmentId, @PathVariable("status") Integer newStatus, @PathVariable("date") String date){
        Appointment Appointment= appointmentService.changeStatusAppointment(appointmentId,newStatus,date);
        return ResponseEntity.ok(Appointment);
    }

    @RequestMapping (path="/api/appointment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAppointment (@PathVariable("id") Long appointmentId){
        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.ok("cita eliminada exitosamente!");

    }

    @RequestMapping (path="/api/appointment/makesound", method = RequestMethod.GET)
    public ResponseEntity<Appointment> getMakeSound(){
        Appointment Appointment =  appointmentService.makeSound();
        return ResponseEntity.ok(Appointment);
    }

    @RequestMapping (path="/api/appointment/activesound/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getActiveSound(@PathVariable("id") Long appointmentId){
        appointmentService.setSound(true,appointmentId);
        return ResponseEntity.ok("sonido activado");
    }

}
