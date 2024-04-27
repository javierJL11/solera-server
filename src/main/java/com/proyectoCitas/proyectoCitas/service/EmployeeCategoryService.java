package com.proyectoCitas.proyectoCitas.service;

import com.proyectoCitas.proyectoCitas.entity.EmployeeCategory;

import java.util.List;

public interface EmployeeCategoryService {
    List<EmployeeCategory> getAllEmployeeCategory();
    EmployeeCategory getEmployeeCategoryById(Long employeeCategoryId);
    EmployeeCategory createEmployeeCategory(EmployeeCategory employeeCategory);
    void deleteEmployeeCategory(Long employeeCategoryId);
    EmployeeCategory updateEmployeeCategory(Long employeeCategoryId, EmployeeCategory updatedEmployeeCategory);



}
