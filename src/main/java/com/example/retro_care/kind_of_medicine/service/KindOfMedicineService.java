package com.example.retro_care.kind_of_medicine.service;

import com.example.retro_care.kind_of_medicine.dto.IKindOfMedicineDto;
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
        return kindOfMedicineRepository.findAll();
    }

    @Override
    public Page<IKindOfMedicineDto> getPageKindOfMedicine(Pageable pageable, String searchCode, String searchName) {
        return kindOfMedicineRepository.findAllKindOfMedicine(pageable,searchCode,searchName);
    }

    @Override
    public KindOfMedicine getKindOfMedicineById(Long id) {
        return null;
    }

    @Override
    public void deleteKindOfMedicineById(Long id) {
        kindOfMedicineRepository.deleteKindOfMedicineById(id);
    }

    @Override
    public Boolean deleteKindOfMedicine(Long id) {
        kindOfMedicineRepository.deleteById(id);
        return true;
    }

    @Override
    public void addKindOfMedicine(KindOfMedicine kindOfMedicine) {
        kindOfMedicineRepository.save(kindOfMedicine);
    }

    @Override
    public void editKindOfMedicine(KindOfMedicine kindOfMedicine) {

    }
}
