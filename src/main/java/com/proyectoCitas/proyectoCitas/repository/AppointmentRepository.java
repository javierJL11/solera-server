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
            value = "select * from appointment where status = 1 and DATE(created_date) = to_date(:date,'YYYY-MM-DD') and room_id = :roomId")
    Appointment getActiveAppointmentByRoomId(@Param("roomId") Long id, @Param("date") String date);

    @Query(
            nativeQuery = true,
            value = "select * from appointment where DATE(created_date) = to_date(:date,'YYYY-MM-DD') order by created_date")
    List<Appointment> getTodayAppointments(@Param("date") String date);
}
