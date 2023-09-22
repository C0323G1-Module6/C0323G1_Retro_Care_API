package com.example.retro_care.home.service;

import com.example.retro_care.home.dto.MedicineForHomePageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IHomeService {

    List<MedicineForHomePageDTO> findMedicineForHomepage(String keyword, String type);

    List<MedicineForHomePageDTO> findFavoriteMedicineForHomepage();

    Page<MedicineForHomePageDTO> getListMedicineWithPagination(String keyword, String type, Pageable pageable);
}
