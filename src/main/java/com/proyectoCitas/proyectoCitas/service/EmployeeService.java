package com.proyectoCitas.proyectoCitas.service;

import com.proyectoCitas.proyectoCitas.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long employeeId);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Long employeeId, Employee updatedEmployee);

    void deleteEmployee (Long employeeId);

    List<Employee> getDoctors();

    List<Employee> getActiveEmployee();
}
