package com.example.retro_care.medicine.service.Impl;

import com.example.retro_care.medicine.model.ImageMedicine;
import com.example.retro_care.medicine.model.UnitDetail;
import com.example.retro_care.medicine.repository.IUnitDetailRepository;
import com.example.retro_care.medicine.service.IUnitDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UnitDetailService implements IUnitDetailService {
    @Autowired
    private IUnitDetailRepository iUnitDetailRepository;

    /**
     * Find UnitDetail objects by the ID of the associated Medicine-TinVV
     *
     * @param medicineId The ID of the Medicine.
     * @return A list of UnitDetail objects associated with the given Medicine ID.
     */
    @Override
    public Set<UnitDetail> findUnitDetailByMedicineId(Long medicineId) {
        return iUnitDetailRepository.findUnitDetailByMedicineId(medicineId);
    }

    /**
     * Add a new UnitDetail to the system-TinVV
     *
     * @param unitDetail The UnitDetail object to be added.
     */
    @Override
    public void addUnitDetail(UnitDetail unitDetail) {
        iUnitDetailRepository.addUnitDetail(unitDetail.getConversionUnit(), unitDetail.getConversionRate(),
                unitDetail.getMedicine().getId(), unitDetail.getUnit().getId());
    }

    /**
     * Update an existing UnitDetail in the system-TinVV
     *
     * @param unitDetail The updated UnitDetail object.
     */
    @Override
    public void updateUnitDetailByMedicineId(UnitDetail unitDetail) {
        iUnitDetailRepository.updateUnitDetail(unitDetail.getConversionUnit(), unitDetail.getConversionRate(),
                unitDetail.getMedicine().getId(), unitDetail.getUnit().getId());
    }
}
