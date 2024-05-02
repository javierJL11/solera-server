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
@Table(name="alert")
public class Alert {
    @Id
    private Long id;

    @Column(name= "appointment_id")
    private Long appointmentId;

    @Column(name= "make_sound")
    private Boolean makeSound;
}
