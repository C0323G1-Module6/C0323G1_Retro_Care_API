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
     * Searches for medicines based on a search string and kind of medicine.
     *
     * @param keyword The search string.
     * @param type    The kind of medicine.
     * @return A list of medicines related to the search string and kind of medicine that are not flagged as deleted.
     * @author HuyL
     */
    public List<MedicineForHomePageDTO> findMedicineForHomepage(String keyword, String type) {
        String keywordParam = '%' + keyword + '%';
        String typeParam = '%' + type + '%';
        System.out.println("Search:" + keywordParam);
        return homeRepository.findMedicineForHomepage(keywordParam, typeParam);
    }

    /**
     * Finds favorite medicines based on their sale quantities.
     *
     * @return The 30 medicines with the highest sale quantities.
     * @author HuyL
     */
    @Override
    public List<MedicineForHomePageDTO> findFavoriteMedicineForHomepage() {
        return homeRepository.findFavoriteMedicineForHomepage();
    }

    /**
     * Retrieves a paginated list of medicines for the home page.
     *
     * @param keyword  The search keyword.
     * @param type     The kind of medicine.
     * @param pageable Pagination information.
     * @return A paginated list of medicines based on the provided parameters.
     * @author HuyL
     */
    @Override
    public Page<MedicineForHomePageDTO> getListMedicineWithPagination(String keyword, String type, Pageable pageable) {
        String keywordParam = '%' + keyword + '%';
        String typeParam = '%' + type + '%';
        return homeRepository.getListMedicineWithPagination(keywordParam, typeParam, pageable);
    }
}
