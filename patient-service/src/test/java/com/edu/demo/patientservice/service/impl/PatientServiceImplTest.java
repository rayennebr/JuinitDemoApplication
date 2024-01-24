package com.edu.demo.patientservice.service.impl;

import com.edu.demo.patientservice.entity.Patient;
import com.edu.demo.patientservice.repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PatientServiceImplTest {

    //service to test
    @InjectMocks //inject mock dependencies
    private PatientServiceImpl patientService;

    //dependencies
    @Mock
    private PatientRepository patientRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_save_patient()
    {
        //given
        Patient patient=new Patient(
                1L,
                "rayenne",
                "brik",
                "1258",
                "Abbd-f");
        //when
        //mock calls
        when(patientRepository.save(patient)).thenReturn(patient);
        String msg=patientService.addPatient(patient);
        //then
        assertEquals(msg,"success");
        verify(patientRepository, times(1)).save(patient);
    }

    @Test
    public void shoud_get_all_patient()
    {
        //given
        List<Patient> patientList=new ArrayList<>();
        patientList.add(new Patient(
                1L,
                "rayenne",
                "brik",
                "1258",
                "Abbd-f"));
        //when
        //mock calls
        when(patientRepository.findAll())
                .thenReturn(patientList);
        List<Patient>patients=patientService.getAllPatient();
        //then
        assertEquals(patients.size(),patientList.size());
        verify(patientRepository,times(1)).findAll();
    }

    @Test
    public void should_handle_invalid_patient()
    {
        //given
        Patient patient = new Patient(
                1L,
                null, // setting a required field to null to make it invalid
                "brik",
                "1258",
                "Abbd-f");

        //when
        String msg = patientService.addPatient(patient);

        //assert
        assertEquals("invalid", msg); // or another appropriate invalid message
        verify(patientRepository, never()).save(any(Patient.class)); // Ensure save was not called
    }
}