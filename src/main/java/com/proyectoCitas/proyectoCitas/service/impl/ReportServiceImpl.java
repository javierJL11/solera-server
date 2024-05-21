package com.proyectoCitas.proyectoCitas.service.impl;

import com.proyectoCitas.proyectoCitas.entity.Report;
import com.proyectoCitas.proyectoCitas.exception.ResourceNotFoundException;
import com.proyectoCitas.proyectoCitas.repository.ReportRepository;
import com.proyectoCitas.proyectoCitas.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;
    @Override
    public Report createReport(Report report) {
        Report saveReport;
        try {
            saveReport = reportRepository.save(report);
        }catch(Exception ResourceNotFoundException){
            throw new ResourceNotFoundException("error al agregar Reporte");
        }
        return saveReport;
    }

    @Override
    public List<Report> getAllReports() {
        List<Report> listReports;
        try {
            listReports = reportRepository.findAll();
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al obtener lista de Reportes");
        }
        return listReports;
    }

    @Override
    public List<Report> getReportByDate(String date) {
        List<Report> reports;
        try{
            reports =  reportRepository.getReportByDate(date);
        }catch (Exception ResourceNotFoundException){
            throw new ResourceNotFoundException("Error al obtener los Reportes del dia ");
        }
        return reports;
    }

    @Override
    public List<Report> getReportByDateAndPatient(String date, Long idPatient) {
        List<Report> reports;
        try{
            reports =  reportRepository.getReportByDateAndPatient(date, idPatient);
        }catch (Exception ResourceNotFoundException){
            throw new ResourceNotFoundException("Error al obtener los Reportes del dia por paciente");
        }
        return reports;
    }

    @Override
    public Report getReportById(Long reportId) {
        return reportRepository.findById(reportId) .orElseThrow(() ->
                new ResourceNotFoundException(("El consultorio no exixte para el id : " + reportId)));
    }

    @Override
    public Report updateReport(Long reportId, Report updatedReport) {
        Report getReport = getReportById(reportId);
        if(getReport !=null){
            getReport.setPatient(updatedReport.getPatient());
            getReport.setEmployee(updatedReport.getEmployee());
            getReport.setModifiedDate(updatedReport.getModifiedDate());
            getReport.setNoteReport(updatedReport.getNoteReport());
            getReport.setStatus(updatedReport.getStatus());
            getReport.setObservation(updatedReport.getObservation());
        }
        Report saveReport;
        try {
            saveReport = reportRepository.save(getReport);
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al modificar el reporte");
        }
        return saveReport;
    }

    @Override
    public void deleteReport(Long reportId) {
        try {
            reportRepository.deleteById(reportId);
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al eliminar Reporte");
        }
    }
}
