package com.edu.demo.patientservice.service;

import com.edu.demo.patientservice.entity.Patient;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface PatientService {

    List<Patient>getAllPatient();
    String addPatient(Patient patient);

    String updatePatient(Long id,Patient patient);
}
