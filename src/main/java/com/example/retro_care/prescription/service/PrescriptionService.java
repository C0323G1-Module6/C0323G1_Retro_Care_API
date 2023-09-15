package com.example.retro_care.prescription.service;

import com.example.retro_care.prescription.model.Prescription;
import com.example.retro_care.prescription.repository.IPrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService implements IPrescriptionService{
    @Autowired
    private IPrescriptionRepository prescriptionRepository;

    @Override
    public Page<Prescription> findAllPrescription(Pageable pageable) {
        return prescriptionRepository.getAllPrescription(pageable);
    }

    @Override
    public void createPrescription(Prescription prescription) {
        prescriptionRepository.createPrescription(prescription);
    }

    @Override
    public List<Prescription> getAll() {
        return prescriptionRepository.getAll();
    }
}
