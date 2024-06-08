package com.proyectoCitas.proyectoCitas.service.impl;

import com.proyectoCitas.proyectoCitas.entity.Employee;
import com.proyectoCitas.proyectoCitas.exception.ResourceNotFoundException;
import com.proyectoCitas.proyectoCitas.repository.EmployeeRepository;
import com.proyectoCitas.proyectoCitas.service.EmployeeCategoryService;
import com.proyectoCitas.proyectoCitas.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCategoryService employeeCategoryService;

    @Override
    public Employee createEmployee(Employee employee) {
        Employee saveEmployee = null;
        try {
            saveEmployee  = employeeRepository.save(employee);
        }catch (Exception ResourceNotFoundException){
            throw new ResourceNotFoundException("Error al agregar empleado ");
        }
        return saveEmployee;
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
     Employee employee = employeeRepository.findById(employeeId)
             .orElseThrow(() ->
                     new ResourceNotFoundException(("El empleado no exixte para el id : " + employeeId)));
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(("El empleado no exixte para el id : " + employeeId)));
        Employee newEmployee = null;

            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setState(updatedEmployee.getState());
            employee.setEmployeeCategoryId(updatedEmployee.getEmployeeCategoryId());
            try {
                newEmployee = employeeRepository.save(employee);
            }catch (Exception ResourceNotFoundException){
                throw new ResourceNotFoundException("Error al modificar empleado ");
            }
        return newEmployee;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        try {
            employeeRepository.deleteById(employeeId);
        }catch (Exception ResourceNotFoundException){
            throw new ResourceNotFoundException("Error al eliminar empleado ");
        }
    }

    @Override
    public List<Employee> getDoctors() {
        List<Employee> doctors;
        try{
            doctors = employeeRepository.getDoctors();

        }catch (Exception ResourceNotFoundException){
            throw new ResourceNotFoundException("Error al obtener lista de doctores");
        }
        return doctors;
    }

    @Override
    public List<Employee> getActiveEmployee() {
        List<Employee> employees;
        try{
            employees = employeeRepository.getActiveEmployee();

        }catch (Exception ResourceNotFoundException){
            throw new ResourceNotFoundException("Error al obtener lista de empleados");
        }
        return employees;
    }
}
