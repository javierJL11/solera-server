package com.proyectoCitas.proyectoCitas.controller;

import com.proyectoCitas.proyectoCitas.entity.Employee;
import com.proyectoCitas.proyectoCitas.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin
@RestController
//@RequestMapping("/api/employees")
//@RequestMapping (path="/api/employees", method = RequestMethod)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping (path="/api/employees", method = RequestMethod.POST)
    public ResponseEntity<Employee> createEmployee (@RequestBody Employee employee){
       Employee saveEmployee =  employeeService.createEmployee(employee);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    @RequestMapping (path="/api/employees/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId){
        Employee employee =  employeeService.getEmployeeById (employeeId);
        return ResponseEntity.ok(employee);
    }

    @RequestMapping (path="/api/employees", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees =  employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @RequestMapping (path="/api/employees/doctores", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getDoctors(){
        List<Employee> doctors =  employeeService.getDoctors();
        return ResponseEntity.ok(doctors);
    }

    @RequestMapping (path="/api/employees/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee( @PathVariable("id") Long employeeId,@RequestBody Employee updatedEmployee){
       Employee employee= employeeService.updateEmployee(employeeId,updatedEmployee);
       return ResponseEntity.ok(employee);
    }

    @RequestMapping (path="/api/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEmployee (@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Empleado eliminado exitosamente!");

    }

}
