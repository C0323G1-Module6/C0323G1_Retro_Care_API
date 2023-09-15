package com.example.retro_care.medicine.service.Impl;

import com.example.retro_care.medicine.model.ImageMedicine;
import com.example.retro_care.medicine.repository.IImageMedicineRepository;
import com.example.retro_care.medicine.service.IImageMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageMedicineService implements IImageMedicineService {
    @Autowired
    private IImageMedicineRepository iImageMedicineRepository;
    @Override
    public void addImageMedicine(ImageMedicine imageMedicine) {
    iImageMedicineRepository.addImageMedicine(imageMedicine.getImagePath(),imageMedicine.getMedicine().getId());
    }

    @Override
    public List<ImageMedicine> findImageMedicineByMedicineId(Long medicineId) {
        return iImageMedicineRepository.findImageMedicineByMedicineId(medicineId);
    }

    @Override
    public void updateImageMedicine(ImageMedicine imageMedicine) {
        iImageMedicineRepository.updateImageMedicine(imageMedicine.getImagePath(), imageMedicine.getMedicine().getId());
    }
}
