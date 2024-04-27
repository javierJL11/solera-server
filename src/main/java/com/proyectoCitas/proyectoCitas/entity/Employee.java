package com.proyectoCitas.proyectoCitas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "first_name")
    private String firstName;

    @Column(name= "last_name")
    private String lastName;

    @Column(name= "state")
    private Integer state;

    @Column(name= "email")
    private String email;

    private Timestamp createOn;

    @Column(name= "modified_date")
    private Timestamp ModifiedDate;

    @Column(name= "created_date")
    private Timestamp createdDate;

    @ManyToOne
    @JoinColumn(name = "employee_category_id")
    private EmployeeCategory employeeCategoryId;

}
