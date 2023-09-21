package com.example.retro_care.medicine.service;

import com.example.retro_care.medicine.model.ImageMedicine;

import java.util.Set;

public interface IImageMedicineService {
    /**
     * Add a new ImageMedicine-TinVV
     * @param medicineId The ID of the Medicine.
     * @param imageMedicine The ImageMedicine object to be added.
     */
    void addImageMedicine(ImageMedicine imageMedicine,Long medicineId);

    /**
     * Retrieve a list of ImageMedicine objects associated with a specific Medicine ID-TinVV
     *
     * @param medicineId The ID of the Medicine.
     * @return A list of ImageMedicine objects associated with the given Medicine ID.
     */
//    Set<ImageMedicine> findImageMedicineByMedicineId(Long medicineId);
    ImageMedicine findImageMedicineByMedicineId(Long medicineId);

    /**
     * Update an existing ImageMedicine-TinVV
     *
     * @param imageMedicine The updated ImageMedicine object.
     * @param medicineId The ID of the Medicine.
     */
    void updateImageMedicine(ImageMedicine imageMedicine,Long medicineId);
}
