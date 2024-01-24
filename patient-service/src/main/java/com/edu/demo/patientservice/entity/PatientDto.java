package com.edu.demo.patientservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * A DTO for the {@link Patient} entity
 */
@AllArgsConstructor
@Data
@Builder
public class PatientDto implements Serializable {
    private final String firstName;
    private final String lastName;
    private final String patientCode;
}