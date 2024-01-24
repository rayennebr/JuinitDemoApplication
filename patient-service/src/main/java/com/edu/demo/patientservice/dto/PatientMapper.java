package com.edu.demo.patientservice.dto;

import com.edu.demo.patientservice.entity.Patient;
import com.edu.demo.patientservice.entity.PatientDto;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    public PatientDto mapPatientToPatientDto(Patient patient)
    {   if(patient==null)
    {
        throw new NullPointerException("patient is null");
    }
        return PatientDto.builder()
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .patientCode(patient.getPatientCode())
                .build();
    }
}
