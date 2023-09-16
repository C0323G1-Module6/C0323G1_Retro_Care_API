package com.example.retro_care.medicine.service;

import com.example.retro_care.medicine.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMedicineService {
    /**
     * Retrieve a Medicine object by its ID-TinVV
     *
     * @param id The ID of the Medicine.
     * @return The Medicine object associated with the given ID, or null if not found.
     */
    Medicine findMedicineById(Long id);

    /**
     * Edit an existing Medicine-TinVV
     *
     * @param medicine The updated Medicine object.
     */
    void editMedicine(Medicine medicine);

    /**
     * Add a new Medicine-TinVV
     *
     * @param medicine The Medicine object to be added.
     */
    void addMedicine(Medicine medicine);
}
