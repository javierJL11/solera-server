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
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "patient_name")
    private String patientName;

    @Column(name= "owner")
    private String owner;

    @Column(name= "email")
    private String email;

    @Column(name= "modified_date")
    private Timestamp ModifiedDate;

    @Column(name= "created_date")
    private Timestamp createdDate;
}
