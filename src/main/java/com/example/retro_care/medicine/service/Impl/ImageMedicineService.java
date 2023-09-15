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

    /**
     * Add an ImageMedicine to the system-TinVV
     *
     * @param imageMedicine The ImageMedicine object to be added.
     */
    @Override
    public void addImageMedicine(ImageMedicine imageMedicine) {
        iImageMedicineRepository.addImageMedicine(imageMedicine.getImagePath(), imageMedicine.getMedicine().getId());
    }

    /**
     * Find ImageMedicine objects by the ID of the associated Medicine-TinVV
     *
     * @param medicineId The ID of the Medicine.
     * @return A list of ImageMedicine objects associated with the given Medicine ID.
     */
    @Override
    public List<ImageMedicine> findImageMedicineByMedicineId(Long medicineId) {
        return iImageMedicineRepository.findImageMedicineByMedicineId(medicineId);
    }

    /**
     * Update an ImageMedicine in the system-TinVv
     *
     * @param imageMedicine The updated ImageMedicine object.
     */
    @Override
    public void updateImageMedicine(ImageMedicine imageMedicine) {
        iImageMedicineRepository.updateImageMedicine(imageMedicine.getImagePath(), imageMedicine.getMedicine().getId());
    }
}
