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

    /**
     * Display list Medicine
     * author: medicine_DaoPTA
     * workday: 15/09/2023
     *
     * @param pageable pagination of medication list
     * @return : Medicine list with pagination
     */
    Page<Medicine> findAll(Pageable pageable);

    /**
     * author: DaoPTA
     * workday: 16/09/2023
     * Delete medicine
     *
     * @param id Search medicine by id to delete
     * @return Boolean
     */
    Boolean removeMedicine(Long id);
}
