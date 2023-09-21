package com.example.retro_care.prescription.service;

import com.example.retro_care.prescription.model.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPrescriptionService {
    Page<Prescription> findAllPrescription(Pageable pageable);
    void createPrescription(Prescription prescription);
    List<Prescription> getAll();
    void removePrescription(Long id);
    Prescription getPrescriptionById(Long id);
    void editPrescription(Prescription prescription);
    Page<Prescription> searchByNamePrescription(String name,Pageable pageable);
    Page<Prescription> searchByCodePrescription(String code,Pageable pageable);
    Page<Prescription> searchBySymptomsPrescription(String symptoms, Pageable pageable);

}
