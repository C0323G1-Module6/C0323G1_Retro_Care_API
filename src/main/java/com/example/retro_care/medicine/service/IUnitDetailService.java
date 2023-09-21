package com.example.retro_care.medicine.service;

import com.example.retro_care.medicine.model.UnitDetail;

import java.util.List;

public interface IUnitDetailService {
    /**
     * Retrieve a list of UnitDetail objects associated with a specific Medicine ID-TinVV
     *
     * @param medicineId The ID of the Medicine.
     * @return A list of UnitDetail objects associated with the given Medicine ID.
     */
    List<UnitDetail> findUnitDetailByMedicineId(Long medicineId);

    /**
     * Add a new UnitDetail-TinVV
     *
     * @param unitDetail The UnitDetail object to be added.
     */
    void addUnitDetail(UnitDetail unitDetail);

    /**
     * Update an existing UnitDetail based on the Medicine ID-TinVV
     *
     * @param unitDetail The updated UnitDetail object.
     */
    void updateUnitDetailByMedicineId(UnitDetail unitDetail);
}
