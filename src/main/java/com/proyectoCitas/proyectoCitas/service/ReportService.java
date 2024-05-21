package com.proyectoCitas.proyectoCitas.service;

import com.proyectoCitas.proyectoCitas.entity.Report;

import java.util.List;

public interface ReportService {
    Report createReport(Report report);
    List<Report> getAllReports ();
    List<Report> getReportByDate (String date);
    List<Report> getReportByDateAndPatient (String date, Long idPatient);
    Report getReportById (Long reportId);
    Report updateReport (Long reportId, Report updatedReport);
    void deleteReport (Long reportId);
}
