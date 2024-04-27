package com.proyectoCitas.proyectoCitas.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee_category")
public class EmployeeCategory {
    @Id
    private Long id;

    @Column(name= "employee_category_name")
    private String employeeCategoryName;

}
