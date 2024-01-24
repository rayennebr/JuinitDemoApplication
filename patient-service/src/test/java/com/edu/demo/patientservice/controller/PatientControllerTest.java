package com.edu.demo.patientservice.controller;

import com.edu.demo.patientservice.entity.Patient;
import com.edu.demo.patientservice.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class PatientControllerTest {

    @InjectMocks
    private PatientController patientController;

    @Mock
    private PatientService patientService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations
                .openMocks(this);
        this.mockMvc= MockMvcBuilders
                .standaloneSetup(patientController)
                .build();
    }

    @Test
    public void should_get_all_patient() throws Exception {
        //given
        List<Patient> patientList=new ArrayList<>();
        patientList.add(new Patient(
                1L,
                "rayenne",
                "brik",
                "1258",
                "Abbd-f"));
        patientList.add(new Patient(
                        2L,
                        "tuto",
                        "tata",
                        "1258",
                        "Abbd-f"));

        //when
        //mock all dependencies
        when(patientService.getAllPatient()).thenReturn(patientList);
        //then
        mockMvc.perform(get("/api/v1/patient/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].firstName").value("rayenne"))
                .andExpect(jsonPath("$[1].firstName").value("tuto"));
    }

    @Test
    public void should_save_patient() throws Exception {
        //given
        Patient patient=new Patient(
                1L,
                "rayenne",
                "brik",
                "1258",
                "Abbd-f");

        //when
        when(patientService.addPatient(patient)).thenReturn("success");
        //then
        mockMvc.perform(post("/api/v1/patient/")
                        .content(asJsonString(patient))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andExpect(content().string("success"));
        verify(patientService,times(1)).addPatient(patient);

    }


    // Helper method to convert objects to JSON string
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}