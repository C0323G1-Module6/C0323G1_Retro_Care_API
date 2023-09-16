package com.example.retro_care.report.repository;

import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.report.dto.BestSellerMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBestSellerRepository extends JpaRepository<Medicine,Long> {
    @Query(value = "select od.medicine_id as id, m.name, sum(od.quantity) as amount" +
            "from order_details od join medicine m on od.medicine_id = m.id" +
            "group by od.medicine_id" +
            "limit 100", nativeQuery = true)
    List<BestSellerMedicine> findBestSellerMedicine();
}