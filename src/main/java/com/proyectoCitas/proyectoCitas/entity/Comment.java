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
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "comment")
    private String comment;

    @Column(name= "parent_id")
    private Long parentId;

    @Column(name= "modified_date")
    private Timestamp modifiedDate;

    @Column(name= "created_date")
    private Timestamp createdDate;
}
