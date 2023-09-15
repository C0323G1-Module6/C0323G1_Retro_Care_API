package com.example.retro_care.prescription.service;

import com.example.retro_care.prescription.model.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPrescriptionService {
    Page<Prescription> findAllPrescription(Pageable pageable);
    void createPrescription(Prescription prescription);
}
