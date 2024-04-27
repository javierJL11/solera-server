package com.proyectoCitas.proyectoCitas.service.impl;

import com.proyectoCitas.proyectoCitas.entity.Appointment;
import com.proyectoCitas.proyectoCitas.exception.ResourceNotFoundException;
import com.proyectoCitas.proyectoCitas.repository.AppointmentRepository;
import com.proyectoCitas.proyectoCitas.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;
    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        appointment.setCreatedDate(new Timestamp(new Date().getTime()));
       Appointment saveAppointment =appointmentRepository.save(appointment);
        return saveAppointment;
    }

    @Override
    public Appointment getAppointmentById(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(("La cita no exixte para el id : " + appointmentId)));
        return appointment;
    }

    @Override
    public Appointment updateAppointment(Long appointmentId, Appointment updatedAppointment)  {

            Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() ->
                    new ResourceNotFoundException(("La cita no exixte para el id : " + appointmentId)));
            appointment.setDoctor(updatedAppointment.getDoctor());
            appointment.setNote(updatedAppointment.getNote());
            appointment.setRoom(updatedAppointment.getRoom());
            appointment.setPatient(updatedAppointment.getPatient());
            appointment.setStatus(updatedAppointment.getStatus());
            appointment.setObservation(updatedAppointment.getObservation());
            appointment.setModifiedDate(new Timestamp(new Date().getTime()));
            return appointmentRepository.save(appointment);

    }

    @Override
    public void deleteAppointment(Long appointmentId) {
    appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public boolean getActiveAppointmentByRoomName(String roomName) {
        boolean isactive = true;
        Appointment appointment = appointmentRepository.getActiveAppointmentByRoomName(roomName);
        if(appointment == null)
            isactive = false;

        return isactive;

    }

    @Override
    public List<Appointment> getTodayAppointments() {
        List<Appointment> appointments;
        try{
            appointments =  appointmentRepository.getTodayAppointments();
        }catch (Exception ResourceNotFoundException){
            throw new ResourceNotFoundException("Error al obtener las citas del dia ");
        }
        return appointments;
    }

    @Override
    public Appointment changeStatusAppointment(Long appointmentId, Integer newStatus) {
        boolean isActiveAppo = false;

        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() ->
                new ResourceNotFoundException(("La cita no exixte para el id : " + appointmentId)));

        if(newStatus ==1) {
            isActiveAppo = getActiveAppointmentByRoomName(appointment.getRoom());
            if (!isActiveAppo) {
                appointment.setStatus(newStatus);
                appointment.setModifiedDate(new Timestamp(new Date().getTime()));
                return appointmentRepository.save(appointment);
            } else {
                throw new ResourceNotFoundException("Actualmente existe una cita activa asociada a: " + appointment.getRoom());
            }
        }else{
            appointment.setStatus(newStatus);
            appointment.setModifiedDate(new Timestamp(new Date().getTime()));
            return appointmentRepository.save(appointment);
        }

    }


}
