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

    /**
     * Author: ThanhKN
     * Goal:get all patient
     * Return patient
     * Date:17/09/2023
     */
    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.getAllPatient();
    }

    @Override
    public Patient patientById(Long id) {
        return patientRepository.findById(id).get();
    }
}
