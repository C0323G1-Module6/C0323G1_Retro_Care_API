package com.example.retro_care.medicine.service;

import com.example.retro_care.medicine.model.ImageMedicine;
import com.example.retro_care.medicine.model.UnitDetail;

import java.util.List;
import java.util.Set;

public interface IUnitDetailService {
    /**
     * Retrieve a list of UnitDetail objects associated with a specific Medicine ID-TinVV
     *
     * @param medicineId The ID of the Medicine.
     * @return A list of UnitDetail objects associated with the given Medicine ID.
     */
    UnitDetail findUnitDetailByMedicineId(Long medicineId);

    /**
     * Add a new UnitDetail-TinVV
     * @param medicineId The ID of the Medicine.
     * @param unitDetail The UnitDetail object to be added.
     */
    void addUnitDetail(UnitDetail unitDetail,Long medicineId,Long unitId);

    /**
     * Update an existing UnitDetail based on the Medicine ID-TinVV
     * @param medicineId The ID of the Medicine.
     * @param unitDetail The updated UnitDetail object.
     */
    void updateUnitDetailByMedicineId(UnitDetail unitDetail,Long medicineId,Long unitId);
}
