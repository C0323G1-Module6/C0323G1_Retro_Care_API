package com.example.retro_care.kind_of_medicine.service;

import com.example.retro_care.kind_of_medicine.model.KindOfMedicine;
import com.example.retro_care.kind_of_medicine.repository.IKindOfMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindOfMedicineService implements IKindOfMedicineService {
    @Autowired
    private IKindOfMedicineRepository kindOfMedicineRepository;

    @Override
    public List<KindOfMedicine> getListKindOfMedicine() {
        return null;
    }

    @Override
    public Page<KindOfMedicine> getPageKindOfMedicine(Pageable pageable, String searchCode, String searchName) {
        return null;
    }

    @Override
    public KindOfMedicine getKindOfMedicineById(Integer id) {
        return null;
    }

    @Override
    public void deleteKindOfMedicineById(Integer id) {

    }

    @Override
    public Boolean deleteKindOfMedicine(int id) {
        return null;
    }

    @Override
    public void addKindOfMedicine(KindOfMedicine kindOfMedicine) {

    }

    @Override
    public void editKindOfMedicine(KindOfMedicine kindOfMedicine) {

    }
}
