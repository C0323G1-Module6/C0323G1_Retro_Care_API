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

    /**
     * Author: ThanhKN
     * Goal:get all prescription
     * Return page prescription
     * Date:17/09/2023
     * @param pageable
     */
    @Override
    public Page<Prescription> findAllPrescription(Pageable pageable) {
        return prescriptionRepository.getAllPrescription(pageable);
    }

    /**
     * Author: ThanhKN
     * Goal:create prescription
     * Return void
     * Date:17/09/2023
     * @param prescription
     */
    @Override
    public void createPrescription(Prescription prescription) {
        prescription.setFlagDeleted(false);
        prescriptionRepository.createPrescription(prescription);
    }

    /**
     * Author: ThanhKN
     * Goal:get all prescription
     * Return List prescription
     * Date:17/09/2023
     */
    @Override
    public List<Prescription> getAll() {
        return prescriptionRepository.getAll();
    }

    /**
     * Author: ThanhKN
     * Goal:remove prescription by id
     * Return void
     * Date:17/09/2023
     * @param id
     */
    @Override
    public void removePrescription(Long id) {
        prescriptionRepository.removePrescription(id);
    }

    /**
     * Author: ThanhKN
     * Goal:get prescription by id
     * Return void
     * Date:17/09/2023
     * @param id
     */
    @Override
    public Prescription getPrescriptionById(Long id) {
        return prescriptionRepository.getPrescriptionById(id);
    }

    /**
     * Author: ThanhKN
     * Goal:edit prescription by id
     * Return void
     * Date:17/09/2023
     * @param prescription
     */
    @Override
    public void editPrescription(Prescription prescription) {
        System.out.println(">>>"+prescription.getId());
       Integer a = prescriptionRepository.editPrescription(prescription);
        System.out.println(a);
    }
}
