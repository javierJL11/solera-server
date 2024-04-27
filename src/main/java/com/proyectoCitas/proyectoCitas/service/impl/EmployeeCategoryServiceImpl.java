package com.proyectoCitas.proyectoCitas.service.impl;

import com.proyectoCitas.proyectoCitas.entity.Employee;
import com.proyectoCitas.proyectoCitas.entity.EmployeeCategory;
import com.proyectoCitas.proyectoCitas.exception.ResourceNotFoundException;
import com.proyectoCitas.proyectoCitas.repository.EmployeeCategoryRepository;
import com.proyectoCitas.proyectoCitas.service.EmployeeCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class EmployeeCategoryServiceImpl implements EmployeeCategoryService {

    @Autowired
    private EmployeeCategoryRepository employeeCategoryRepository;

    @Override
    public List<EmployeeCategory> getAllEmployeeCategory() {
        List<EmployeeCategory> employeeCategory = employeeCategoryRepository.findAll();
        return employeeCategory;
    }

    @Override
    public EmployeeCategory getEmployeeCategoryById(Long employeeCategoryId) {
        EmployeeCategory employeeCategory = employeeCategoryRepository.findById(employeeCategoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(("La categoria del empleado no exixte para el id : " + employeeCategoryId)));
        return employeeCategory;
    }

    @Override
    public EmployeeCategory createEmployeeCategory(EmployeeCategory employeeCategory) {
        EmployeeCategory saveEmployeeCategory = employeeCategoryRepository.save(employeeCategory);
        return saveEmployeeCategory;
    }

    @Override
    public void deleteEmployeeCategory(Long employeeCategoryId) {
        try {
            employeeCategoryRepository.deleteById(employeeCategoryId);
        }catch (Exception ResourceNotFoundException){
            throw new ResourceNotFoundException("Error al eliminar categoria de empleado ");
        }
    }

    @Override
    public EmployeeCategory updateEmployeeCategory(Long employeeCategoryId, EmployeeCategory updatedEmployeeCategory) {
        EmployeeCategory employeeCategory = employeeCategoryRepository.findById(employeeCategoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(("la categoria de empleado no exixte para el id : " + employeeCategoryId)));
        EmployeeCategory newEmployeeCategory = null;

        employeeCategory.setId(updatedEmployeeCategory.getId());
        employeeCategory.setEmployeeCategoryName(updatedEmployeeCategory.getEmployeeCategoryName());

        try {
            newEmployeeCategory = employeeCategoryRepository.save(employeeCategory);
        }catch (Exception ResourceNotFoundException){
            throw new ResourceNotFoundException("Error al modificar la categoria de empleado ");
        }
        return newEmployeeCategory;
    }


}
