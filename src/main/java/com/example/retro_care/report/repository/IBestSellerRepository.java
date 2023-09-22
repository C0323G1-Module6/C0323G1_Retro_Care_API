package com.example.retro_care.report.repository;

import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.report.dto.BestSellerMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBestSellerRepository extends JpaRepository<Medicine,Long> {

    /**
     * Author: DuyTV
     * Goal: Get list of 100 bestseller medicines
     * Date created: 15/09/2023
     * @return List of BestSellerMedicine
     */
    @Query(value = "select od.medicine_id as id, m.name, sum(od.quantity) as amount " +
            "from order_details od join medicine m on od.medicine_id = m.id " +
            "group by od.medicine_id " +
            " ORDER BY od.medicine_id ASC " +
            "limit 100 ", nativeQuery = true)
    List<BestSellerMedicine> findBestSellerMedicine();
}
