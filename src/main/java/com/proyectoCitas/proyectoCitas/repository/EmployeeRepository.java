package com.proyectoCitas.proyectoCitas.repository;

import com.proyectoCitas.proyectoCitas.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(
            nativeQuery = true,
            value = "select * from employee where state = 1 and employee_category_id = 1")
    List<Employee> getDoctors();

    @Query(
            nativeQuery = true,
            value = "select * from employee where state = 1")
    List<Employee> getActiveEmployee();
}
