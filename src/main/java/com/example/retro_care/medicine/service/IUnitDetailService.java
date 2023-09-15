package com.example.retro_care.medicine.service;

import com.example.retro_care.medicine.model.ImageMedicine;
import com.example.retro_care.medicine.model.UnitDetail;

import java.util.List;

public interface IUnitDetailService {
    List<UnitDetail> findUnitDetailByMedicineId(Long medicineId);
    void addUnitDetail(UnitDetail unitDetail);
    void updateUnitDetailByMedicineId(UnitDetail unitDetail);
}
