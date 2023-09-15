package com.example.retro_care.medicine.service.Impl;

import com.example.retro_care.medicine.model.ImageMedicine;
import com.example.retro_care.medicine.model.UnitDetail;
import com.example.retro_care.medicine.repository.IUnitDetailRepository;
import com.example.retro_care.medicine.service.IUnitDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitDetailService implements IUnitDetailService {
    @Autowired
    private IUnitDetailRepository iUnitDetailRepository;

    @Override
    public List<UnitDetail> findUnitDetailByMedicineId(Long medicineId) {
        return iUnitDetailRepository.findUnitDetailByMedicineId(medicineId);
    }

    @Override
    public void addUnitDetail(UnitDetail unitDetail) {
        iUnitDetailRepository.addUnitDetail(unitDetail.getConversionUnit(), unitDetail.getConversionRate(),
                unitDetail.getMedicine().getId(), unitDetail.getUnit().getId());
    }

    @Override
    public void updateUnitDetailByMedicineId(UnitDetail unitDetail) {
        iUnitDetailRepository.updateUnitDetail(unitDetail.getConversionUnit(), unitDetail.getConversionRate(),
                unitDetail.getMedicine().getId(), unitDetail.getUnit().getId());
    }
}
