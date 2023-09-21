package com.example.retro_care.report.repository;

import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.report.dto.MedicineNeedMore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMedicineNeedMoreRepository extends JpaRepository<Medicine, Long> {

    /**
     * Author: DuyTV
     * Goal: Get list of medicine that need buy more from suppliers ( shows medicines have quantity on stock less than 5)
     * Date created: 15/09/2023
     * @return List of Medicine
     */
    @Query(value = "select name, quantity " +
            "from medicine " +
            "where quantity < 5", nativeQuery = true)
    List<MedicineNeedMore> findMedicineNeedMore();
}
