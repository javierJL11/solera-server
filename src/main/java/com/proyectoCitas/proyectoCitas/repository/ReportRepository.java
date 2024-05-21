package com.proyectoCitas.proyectoCitas.repository;

import com.proyectoCitas.proyectoCitas.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query(
            nativeQuery = true,
            value = "select * from report where DATE(created_date) = to_date(:date,'YYYY-MM-DD') order by created_date DESC")
    List<Report> getReportByDate(@Param("date") String date);

    @Query(
            nativeQuery = true,
            value = "select * from report where DATE(created_date) = to_date(:date,'YYYY-MM-DD') and patient_id =:idPatient order by created_date DESC")
    List<Report> getReportByDateAndPatient(@Param("date") String date, @Param("idPatient") Long idPatient);
}
