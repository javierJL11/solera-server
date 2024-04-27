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
@Table(name="appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "patient")
    private String patient;

//    @OneToOne
    @JoinColumn(name = "doctor_id")
    private String doctor;

    @Column(name= "observation")
    private String observation;

    @Column(name= "note")
    private String note;

    @Column(name= "status")
    private Integer status;

    @Column(name= "modified_date")
    private Timestamp modifiedDate;

    @Column(name= "created_date")
    private Timestamp createdDate;

//    @OneToOne
    @JoinColumn(name = "room_id")
    private String room;

}
