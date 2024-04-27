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

    @GetMapping("/todayAppointments")
    @RequestMapping (path="/api/appointment/todayAppointments", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> getTodayAppointments(){
        List<Appointment> appointments =  appointmentService.getTodayAppointments();
        return ResponseEntity.ok(appointments);
    }


    @RequestMapping (path="/api/appointment/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") Long appointmentId, @RequestBody Appointment updatedAppointment){
        Appointment Appointment= appointmentService.updateAppointment(appointmentId,updatedAppointment);
        return ResponseEntity.ok(Appointment);
    }

    @RequestMapping (path="/api/appointment/changestatus/{id}/{status}", method = RequestMethod.PUT)
    public ResponseEntity<Appointment> changeStatusAppointment(@PathVariable("id") Long appointmentId, @PathVariable("status") Integer newStatus){
        Appointment Appointment= appointmentService.changeStatusAppointment(appointmentId,newStatus);
        return ResponseEntity.ok(Appointment);
    }

    @RequestMapping (path="/api/appointment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAppointment (@PathVariable("id") Long appointmentId){
        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.ok("cita eliminada exitosamente!");

    }

}
