package com.proyectoCitas.proyectoCitas.controller;

import com.proyectoCitas.proyectoCitas.entity.Appointment;
import com.proyectoCitas.proyectoCitas.entity.Report;
import com.proyectoCitas.proyectoCitas.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ReportController {
    
    @Autowired
    private ReportService reportService;

    @RequestMapping(path="/api/report", method = RequestMethod.POST)
    public ResponseEntity<Report> createReport (@RequestBody Report report){
        Report saveReport =  reportService.createReport(report);
        return new ResponseEntity<>(saveReport, HttpStatus.CREATED);
    }

    @RequestMapping (path="/api/report/{id}", method = RequestMethod.GET)
    public ResponseEntity<Report> getReportById(@PathVariable("id") Long reportId){
        Report report =  reportService.getReportById(reportId);
        return ResponseEntity.ok(report);
    }

    @RequestMapping (path="/api/report", method = RequestMethod.GET)
    public ResponseEntity<List<Report>> getAllReports(){
        List<Report> reports =  reportService.getAllReports();
        return ResponseEntity.ok(reports);
    }

    @RequestMapping (path="/api/report/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Report> updateReport( @PathVariable("id") Long reportId,@RequestBody Report updatedReport){
        Report report= reportService.updateReport(reportId,updatedReport);
        return ResponseEntity.ok(report);
    }

    @RequestMapping (path="/api/report/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteReport (@PathVariable("id") Long reportId){
        reportService.deleteReport(reportId);
        return ResponseEntity.ok("Consultorio eliminado exitosamente!");
    }

    @RequestMapping (path="/api/report/bydate/{date}", method = RequestMethod.GET)
    public ResponseEntity<List<Report>> getReportByDate(@PathVariable("date") String date){
        List<Report> report =  reportService.getReportByDate(date);
        return ResponseEntity.ok(report);
    }

    @RequestMapping (path="/api/report/bydateandpatient/{date}/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Report>> getReportByDateAndPatient(@PathVariable("date") String date, @PathVariable("id") Long patientId){
        List<Report> report =  reportService.getReportByDateAndPatient(date, patientId);
        return ResponseEntity.ok(report);
    }
}
