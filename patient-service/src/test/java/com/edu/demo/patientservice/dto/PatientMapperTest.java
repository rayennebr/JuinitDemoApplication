package com.edu.demo.patientservice.dto;

import com.edu.demo.patientservice.entity.Patient;
import com.edu.demo.patientservice.entity.PatientDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class PatientMapperTest {

    private PatientMapper patientMapper;

    @BeforeEach
    void setUp() {
        patientMapper=new PatientMapper();
    }

    @Test
    public void shouldMapPatientToPatientDto()
    {
        Patient patient=new Patient(
                1L,
                "rayenne",
                "brik",
                "1258",
                "Abbd-f");
        PatientDto patientDto=patientMapper.mapPatientToPatientDto(patient);
        assertEquals(patientDto.getFirstName(),patient.getFirstName());
        assertNotNull(patientDto.getPatientCode());
    }

    @Test
    public void should_thrw_null_pointer_exception()
    {
        var expMsg=assertThrows(NullPointerException.class,()->patientMapper.mapPatientToPatientDto(null));
        assertEquals("patient is nul",expMsg.getMessage());
    }
}