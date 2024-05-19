package com.proyectoCitas.proyectoCitas.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "patient_id")
    private Client patient;

    @ManyToOne
    @JoinColumn(name= "employee_id")
    private Employee employee;

    @Column(name= "note_title")
    private String noteTitle;

    @Column(name= "note")
    private String note;

    @Column(name= "status")
    private Integer status;

    @Column(name= "priority")
    private Integer priority;

    @Column(name= "type")
    private Integer type;

    @Column(name= "modified_date")
    private Timestamp modifiedDate;

    @Column(name= "created_date")
    private Timestamp createdDate;
}
