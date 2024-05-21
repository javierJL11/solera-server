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
@Table(name="report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "patient_id")
    private Client patient;

    @ManyToOne
    @JoinColumn(name= "employee_id")
    private Employee employee;

    @Column(name= "note_report" , length = 1000)
    private String noteReport;

    @Column(name= "status")
    private String status;

    @Column(name= "observation")
    private String observation;

    @Column(name= "modified_date")
    private Timestamp modifiedDate;

    @Column(name= "created_date")
    private Timestamp createdDate;
}
