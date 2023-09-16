package com.example.retro_care.home.repository;

import com.example.retro_care.medicine.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface HomeRepository extends JpaRepository<Medicine,Long> {
    @Query(value = " SELECT " +
            "    m.* , " +
            "    ud.conversion_rate, " +
            "    ud.conversion_unit, " +
            "    u.name AS unit_name " +
            "FROM \n " +
            "    medicine m " +
            "LEFT JOIN " +
            "    unit_detail ud ON m.id = ud.medicine_id " +
            "LEFT JOIN " +
            "    unit u ON ud.unit_id = u.id; ", nativeQuery = true)
    List<Medicine> findAllMedicineForHomepage();

    @Query(value = " SELECT " +
            "    m.*, " +
            "    ud.conversion_rate, " +
            "    ud.conversion_unit, " +
            "    u.name AS unit_name " +
            "FROM " +
            "    medicine m " +
            "LEFT JOIN " +
            "    unit_detail ud ON m.id = ud.medicine_id " +
            "LEFT JOIN " +
            "    unit u ON ud.unit_id = u.id " +
            "WHERE " +
            "    m.name LIKE :#{#keyword} ; ", nativeQuery = true)
    List<Medicine> searchMedicineForHomepage(String keyword);
}
