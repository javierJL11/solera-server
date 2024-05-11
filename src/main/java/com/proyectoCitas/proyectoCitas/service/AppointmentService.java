package com.proyectoCitas.proyectoCitas.service;

import com.proyectoCitas.proyectoCitas.entity.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    List<Appointment> getAllAppointments();
    Appointment createAppointment(Appointment appointment);
    Appointment getAppointmentById(Long appointmentId);
    Appointment updateAppointment(Long appointmentId, Appointment updatedAppointment);
    void deleteAppointment (Long AppointmentId);
    boolean getActiveAppointmentByRoomId(Long id, String date);
    List<Appointment> getTodayAppointments(String date);
    Appointment changeStatusAppointment(Long appointmentId, Integer newStatus, String date);
    Appointment makeSound ();
    void setSound(boolean sound, Long appointmentId);

}
