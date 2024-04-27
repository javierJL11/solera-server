package com.proyectoCitas.proyectoCitas.repository;

import com.proyectoCitas.proyectoCitas.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query(
            nativeQuery = true,
            value = "select * from appointment where status = 1 and DATE(created_date) = CURRENT_DATE and room = :roomName")
    Appointment getActiveAppointmentByRoomName(@Param("roomName") String roomName);

    @Query(
            nativeQuery = true,
            value = "select * from appointment where DATE(created_date) = CURRENT_DATE order by created_date")
    List<Appointment> getTodayAppointments();
}
