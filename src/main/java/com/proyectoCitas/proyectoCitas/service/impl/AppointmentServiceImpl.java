package com.proyectoCitas.proyectoCitas.service.impl;

import com.proyectoCitas.proyectoCitas.entity.Alert;
import com.proyectoCitas.proyectoCitas.entity.Appointment;
import com.proyectoCitas.proyectoCitas.exception.ResourceNotFoundException;
import com.proyectoCitas.proyectoCitas.repository.AlertRepository;
import com.proyectoCitas.proyectoCitas.repository.AppointmentRepository;
import com.proyectoCitas.proyectoCitas.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
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

    @Autowired
    AlertRepository alertRepository;
    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
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
            return appointmentRepository.save(appointment);

    }

    @Override
    public void deleteAppointment(Long appointmentId) {
    appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public boolean getActiveAppointmentByRoomId(Long id, String date) {
        boolean isactive = true;
        Appointment appointment = appointmentRepository.getActiveAppointmentByRoomId(id, date);
        if(appointment == null)
            isactive = false;

        return isactive;

    }

    @Override
    public List<Appointment> getTodayAppointments(String date) {
        List<Appointment> appointments;
        try{
            appointments =  appointmentRepository.getTodayAppointments(date);
        }catch (Exception ResourceNotFoundException){
            throw new ResourceNotFoundException("Error al obtener las citas del dia ");
        }
        return appointments;
    }

    @Override
    public Appointment changeStatusAppointment(Long appointmentId, Integer newStatus,String date) {
        boolean isActiveAppo = false;

        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() ->
                new ResourceNotFoundException(("La cita no exixte para el id : " + appointmentId)));

        if(newStatus ==1) {
            isActiveAppo = getActiveAppointmentByRoomId(appointment.getRoom().getId(), date);
            if (!isActiveAppo) {
                setSound(true, appointment.getId());
                appointment.setStatus(newStatus);
                return appointmentRepository.save(appointment);
            } else {
                throw new ResourceNotFoundException("Actualmente existe una cita activa asociada a: " + appointment.getRoom().getRoomName());
            }
        }else{
            appointment.setStatus(newStatus);
            return appointmentRepository.save(appointment);
        }

    }

    @Override
    public Appointment makeSound() {
        Alert alert = alertRepository.findById(Long.parseLong("1")).orElseThrow(() ->
                new ResourceNotFoundException(("La cita no exixte para el id :1 ")));
        Appointment appointment = null;
        if(alert.getMakeSound()){
            appointment = getAppointmentById(alert.getAppointmentId());
            setSound(false, appointment.getId());
        }
        return appointment;
    }
    @Override
    public void setSound (boolean sound, Long appointmentId) {
        Alert alert = alertRepository.findById(Long.parseLong("1")).orElseThrow(() ->
                new ResourceNotFoundException(("La cita no exixte para el id : 1")));
        alert.setAppointmentId(appointmentId);
        alert.setMakeSound(sound);
        alertRepository.save(alert);
    }

}
