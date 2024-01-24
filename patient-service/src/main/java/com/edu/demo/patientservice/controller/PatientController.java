package com.edu.demo.patientservice.controller;

import com.edu.demo.patientservice.entity.Patient;
import com.edu.demo.patientservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.invoker.HttpExchangeAdapter;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@CrossOrigin("*")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Patient>getAllPatient()
    {
        return patientService.getAllPatient();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    String savePatient(@RequestBody Patient patient)
    {
        return patientService.addPatient(patient);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    String updatePatient(@PathVariable Long id,@RequestBody Patient patient)
    {
        return patientService.updatePatient(id, patient);
    }
}
