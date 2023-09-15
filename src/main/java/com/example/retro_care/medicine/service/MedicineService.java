package com.example.retro_care.medicine.service;

import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.medicine.repository.IMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService implements IMedicineService{
    @Autowired
    private IMedicineRepository iMedicineRepository;
    @Override
    public Medicine findMedicineById(Long id) {
        return iMedicineRepository.findMedicineById(id);
    }

    @Override
    public void editMedicine(Medicine medicine) {

    }

    @Override
    public void addMedicine(Medicine medicine) {

    }
}
