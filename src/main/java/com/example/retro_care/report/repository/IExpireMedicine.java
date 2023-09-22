package com.example.retro_care.report.repository;

import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.report.dto.ExpireMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExpireMedicine extends JpaRepository<Medicine, Long> {

    /**
     * Author: DuyTV
     * Goal: Get list of medicine that will expire after 10 days
     * Date created: 15/09/2023
     * @return List of Medicine
     */
    @Query(value = "select m.name, m.quantity,i.expiry " +
            "from medicine m " +
            "join invoice_detail i on m.id = i.medicine_id " +
            "where i.expiry <= DATE_SUB(CURDATE(), INTERVAL 10 DAY) ", nativeQuery = true)
    List<ExpireMedicine> findExpireMedicine();
}
