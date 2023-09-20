package com.example.retro_care.home.service;

import com.example.retro_care.home.dto.MedicineForHomePageDTO;
import com.example.retro_care.medicine.model.Medicine;

import java.util.List;

public interface IHomeService {

    List<MedicineForHomePageDTO> findMedicineForHomepage(String keyword, String type);

    List<MedicineForHomePageDTO> findFavoriteMedicineForHomepage();
}
