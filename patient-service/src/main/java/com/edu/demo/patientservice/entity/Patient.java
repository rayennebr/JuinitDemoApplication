package com.edu.demo.patientservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name="_patient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patientId", nullable = false)
    private Long patientId;
    private String firstName;
    private String lastName;
    private String patientCode;
    private String insuranceCode;

}
