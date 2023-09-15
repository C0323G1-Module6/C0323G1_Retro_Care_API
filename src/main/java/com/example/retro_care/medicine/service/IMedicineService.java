package com.example.retro_care.medicine.service;

import com.example.retro_care.medicine.model.Medicine;

public interface IMedicineService {
    Medicine findMedicineById(Long id);
    void editMedicine(Medicine medicine);
    void addMedicine(Medicine medicine);
}
