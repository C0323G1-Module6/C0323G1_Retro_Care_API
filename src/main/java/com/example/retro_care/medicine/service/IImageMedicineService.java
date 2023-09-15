package com.example.retro_care.medicine.service;

import com.example.retro_care.medicine.model.ImageMedicine;
import com.example.retro_care.medicine.model.Medicine;

import java.util.List;

public interface IImageMedicineService {
    void addImageMedicine(ImageMedicine imageMedicine);
    List<ImageMedicine> findImageMedicineByMedicineId(Long medicineId);
    void updateImageMedicine(ImageMedicine imageMedicine);
}
