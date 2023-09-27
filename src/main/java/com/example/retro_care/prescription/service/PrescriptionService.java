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
        prescription.setCode(findMaxCode());
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
     * Goal:find prescription by code
     * Return prescription
     * Date:17/09/2023
     *
     * @param code
     */

    @Override
    public Prescription getPrescriptionByCode(String code) {
        return prescriptionRepository.getPrescriptionByCode(code);
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
        prescriptionRepository.editPrescription(prescription);
    }

    /**
     * Author: ThanhKN
     * Goal:search prescription by name
     * Return page prescription
     * Date:17/09/2023
     *
     * @param name
     */
    @Override
    public Page<Prescription> searchByNamePrescription(String name, Pageable pageable) {
        return prescriptionRepository.searchByNamePrescription(name,pageable);
    }
    /**
     * Author: ThanhKN
     * Goal:search prescription by code
     * Return page prescription
     * Date:17/09/2023
     *
     * @param code
     */

    @Override
    public Page<Prescription> searchByCodePrescription(String code, Pageable pageable) {
        return prescriptionRepository.searchByCodePrescription(code,pageable);
    }
    /**
     * Author: ThanhKN
     * Goal:search prescription by symptoms
     * Return page prescription
     * Date:17/09/2023
     *
     * @param symptoms
     */
    @Override
    public Page<Prescription> searchBySymptomsPrescription(String symptoms, Pageable pageable) {
        return prescriptionRepository.searchBySymptomsPrescription(symptoms,pageable);
    }

    @Override
    public String findMaxCode() {
        String maxCode = prescriptionRepository.findMaxCode();
        if (maxCode.equals(""))
            return "TH001"; // Hoặc giá trị mặc định khác cho code đầu tiên
        // Tách phần số từ code lớn nhất hiện tại
        String numericPart = maxCode.substring(2);
        int numericValue = Integer.parseInt(numericPart);
        // Tăng giá trị số lên 1
        numericValue++;
        // Định dạng lại giá trị số thành chuỗi có độ dài 4 và thêm vào tiền tố "HDN"
        String newNumericPart = String.format("%03d", numericValue);
        String newCode = "TH" + newNumericPart;
        return newCode;
    }
}
