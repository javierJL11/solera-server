package com.proyectoCitas.proyectoCitas.controller;

import com.proyectoCitas.proyectoCitas.entity.EmployeeCategory;
import com.proyectoCitas.proyectoCitas.service.EmployeeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
//@RequestMapping("/api/employeeCategory")
//@RequestMapping (path="/api/employeeCategory", method = RequestMethod)
public class EmployeeCategoryController {

    @Autowired
    private EmployeeCategoryService employeeCategoryService;

    @RequestMapping (path="/api/employeeCategory", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeCategory>> getAllEmployeeCategory(){
        List<EmployeeCategory> employeeCategory =  employeeCategoryService.getAllEmployeeCategory();
        return ResponseEntity.ok(employeeCategory);
    }

    @RequestMapping (path="/api/employeeCategory/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeCategory> getEmployeeCategoryById(@PathVariable("id") Long employeeCategoryId){
        EmployeeCategory employeeCategory =  employeeCategoryService.getEmployeeCategoryById(employeeCategoryId);
        return ResponseEntity.ok(employeeCategory);
    }

    @RequestMapping (path="/api/employeeCategory", method = RequestMethod.POST)
    public ResponseEntity<EmployeeCategory> createEmployeeCategory(@RequestBody EmployeeCategory employeeCategory){
       EmployeeCategory saveEmployeeCategory = employeeCategoryService.createEmployeeCategory(employeeCategory);
        return new ResponseEntity<>(saveEmployeeCategory, HttpStatus.CREATED);
    }

    @RequestMapping (path="/api/employeeCategory/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEmployeeCategory (@PathVariable("id") Long employeeCategoryId){
        employeeCategoryService.deleteEmployeeCategory(employeeCategoryId);
        return ResponseEntity.ok("Categoria de Empleado eliminado exitosamente!");

    }

}
