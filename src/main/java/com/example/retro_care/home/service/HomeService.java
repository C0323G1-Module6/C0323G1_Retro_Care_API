package com.example.retro_care.home.service;

import com.example.retro_care.home.dto.MedicineForHomePageDTO;
import com.example.retro_care.home.repository.HomeRepository;
import com.example.retro_care.medicine.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService implements IHomeService {
    @Autowired
    private HomeRepository homeRepository;

    /**
     * Search medicines with name or type input string
     * @param keyword is the search string
     * @param type    is the kind of medicine
     * @return list all medicine related to keyword and type and do not have flag_deleted
     * @author HuyL
     */
    public List<MedicineForHomePageDTO> findMedicineForHomepage(String keyword, String type) {
        String keywordParam = '%' + keyword + '%';
        String typeParam = '%' + type + '%';
        System.out.println("Search:" + keywordParam );
        return homeRepository.findMedicineForHomepage(keywordParam, typeParam);
    }

    /**
     * Find favorite medicine base on their sale quantities
     * @return 30 medicines that have the most sale quantity
     * @author HuyL
     */
    @Override
    public List<MedicineForHomePageDTO> findFavoriteMedicineForHomepage() {
        return homeRepository.findFavoriteMedicineForHomepage();
    }

    @Override
    public Page<MedicineForHomePageDTO> getListMedicineWithPagination(String keyword, String type, Pageable pageable) {
        String keywordParam = '%' + keyword + '%';
        String typeParam = '%' + type + '%';
        return homeRepository.getListMedicineWithPagination(keywordParam,typeParam,pageable);
    }
}
