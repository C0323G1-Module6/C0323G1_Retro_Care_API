package com.example.retro_care.home.service;

import com.example.retro_care.medicine.model.Medicine;

import java.util.List;

public interface IHomeService {
    List<Medicine> findAllMedicineForHomepage();

    List<Medicine> searchMedicineForHomepage(String keyword);

    List<Medicine> findFavoriteMedicineForHomepage();
}
