package com.example.retro_care.patient.service;

import com.example.retro_care.patient.model.Patient;
import com.example.retro_care.patient.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService{
    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.getAllPatient();
    }
}
