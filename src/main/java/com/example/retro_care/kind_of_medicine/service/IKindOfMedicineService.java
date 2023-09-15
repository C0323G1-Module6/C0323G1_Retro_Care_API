package com.example.retro_care.kind_of_medicine.service;

import com.example.retro_care.kind_of_medicine.model.KindOfMedicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IKindOfMedicineService {
    List<KindOfMedicine>getListKindOfMedicine();
    Page<KindOfMedicine>getPageKindOfMedicine(Pageable pageable,String searchCode,String searchName);
     KindOfMedicine getKindOfMedicineById(Long id);

    void deleteKindOfMedicineById(Long id);
    Boolean deleteKindOfMedicine(Long id);
    void addKindOfMedicine(KindOfMedicine kindOfMedicine);
    void editKindOfMedicine(KindOfMedicine kindOfMedicine);

}
