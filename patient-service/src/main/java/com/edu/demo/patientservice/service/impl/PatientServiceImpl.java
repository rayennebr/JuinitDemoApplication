package com.edu.demo.patientservice.service.impl;

import com.edu.demo.patientservice.entity.Patient;
import com.edu.demo.patientservice.repository.PatientRepository;
import com.edu.demo.patientservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public String addPatient(Patient patient) {
        try{
            patientRepository.save(patient);
            return "success";
        }catch (Exception e)
        {
            return e.getMessage();
        }
    }

    @Override
    public String updatePatient(Long id, Patient patient) {
        Optional<Patient> patientToUpdate=patientRepository.findById(id);
        if(patientToUpdate.isPresent())
        {
            patientToUpdate.get().setPatientCode(patient.getPatientCode());
            patientToUpdate.get().setFirstName(patient.getFirstName());
            patientToUpdate.get().setLastName(patient.getLastName());
            patientToUpdate.get().setInsuranceCode(patient.getInsuranceCode());
            patientToUpdate.get().setPatientCode(patient.getPatientCode());

                patientRepository.saveAndFlush(patientToUpdate.get());
                return "updated !!";
            }
        return "error";
    }


}
