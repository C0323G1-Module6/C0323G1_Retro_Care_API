package com.example.retro_care.home.repository;

import com.example.retro_care.medicine.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface HomeRepository extends JpaRepository<Medicine,Long> {
    /**
     * @author HuyL
     * @return List all medicine that do not has flag_deleted
     */
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
            "    unit u ON ud.unit_id = u.id " +
            " WHERE m.flag_deleted = false ", nativeQuery = true)
    List<Medicine> findAllMedicineForHomepage();

    /**
     * @author HuyL
     * @param keyword is the search string
     * @return list all medicine related to keyword
     */
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
            "    m.name LIKE :#{#keyword} AND m.flag_deleted = false ; ", nativeQuery = true)
    List<Medicine> searchMedicineForHomepage(String keyword);

    /**
     * @author HuyL
     * @return 30 medicines that have the most sale quantity
     */
    @Query(value = " SELECT\n" +
            "    m.id AS medicine_id, " +
            "    m.name AS medicine_name, " +
            "    SUM(od.quantity) AS total_sale_quantity " +
            " FROM " +
            "    order_details od  " +
            " WHERE " +
            "    m.flag_deleted = false " +
            " JOIN " +
            "    medicine m ON od.medicine_id = m.id " +
            " GROUP BY " +
            "    m.id, m.name " +
            " ORDER BY " +
            "    total_sale_quantity DESC " +
            "LIMIT 30; ", nativeQuery = true)
    List<Medicine> findFavoriteMedicineForHomepage();
}
