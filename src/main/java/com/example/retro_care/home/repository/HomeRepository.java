package com.example.retro_care.home.repository;

import com.example.retro_care.home.dto.MedicineForHomePageDTO;
import com.example.retro_care.medicine.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface HomeRepository extends JpaRepository<Medicine,Long> {

    /**
     * Search medicines with name or type input string
     * @author HuyL
     * @param keyword is the search string
     * @param type is the kind of medicine
     * @return list all medicine related to keyword and type and do not have flag_deleted
     */
    @Query(value = "SELECT " +
            "m.id AS medicineId, " +
            "m.name AS medicineName, " +
            "m.price AS medicinePrice, " +
            "kom.name AS medicineType, " +
            "im.image_path AS medicineImage, " +
            "u.name AS medicineUnit " +
            "FROM medicine m " +
            "JOIN kind_of_medicine kom ON m.kind_of_medicine_id = kom.id " +
            "JOIN image_medicine im ON m.id = im.medicine_id " +
            "LEFT JOIN unit_detail ud ON m.id = ud.medicine_id " +
            "LEFT JOIN unit u ON ud.unit_id = u.id " +
            "WHERE " +
            "    m.flag_deleted = 0 " +
            "    AND m.name LIKE :keyword " +
            "    AND kom.name LIKE :type ", nativeQuery = true)
    List<MedicineForHomePageDTO> findMedicineForHomepage(@Param("keyword") String keyword, @Param("type") String type);

    /**
     * Find favorite medicine base on their sale quantities
     * @return 30 medicines that have the most sale quantity
     * @author HuyL
     */
    @Query(value = "SELECT " +
            "m.id AS medicineId, " +
            "m.name AS medicineName, " +
            "m.price AS medicinePrice, " +
            "kom.name AS medicineType, " +
            "u.name AS medicineUnit, " +
            "im.image_path AS medicineImage, " +
            "SUM(od.quantity) AS medicineSaleQuantity " +
            "FROM " +
            "medicine m " +
            "JOIN order_details od ON m.id = od.medicine_id " +
            "LEFT JOIN image_medicine im ON m.id = im.medicine_id " +
            "LEFT JOIN unit_detail ud ON m.id = ud.medicine_id " +
            "LEFT JOIN unit u ON ud.unit_id = u.id " +
            "JOIN kind_of_medicine kom ON m.kind_of_medicine_id = kom.id " +
            "GROUP BY " +
            "m.id, m.name, m.price, kom.name, u.name, im.image_path " +
            "ORDER BY " +
            "SUM(od.quantity) DESC " +
            "LIMIT 30;", nativeQuery = true)
    List<MedicineForHomePageDTO> findFavoriteMedicineForHomepage();

    @Query(value = "SELECT " +
            " m.id AS medicineId, " +
            " m.name AS medicineName, " +
            " m.price AS medicinePrice, " +
            " kom.name AS medicineType, " +
            " im.image_path AS medicineImage, " +
            " u.name AS medicineUnit " +
            " FROM medicine m " +
            "JOIN kind_of_medicine kom ON m.kind_of_medicine_id = kom.id " +
            "JOIN image_medicine im ON m.id = im.medicine_id " +
            "LEFT JOIN unit_detail ud ON m.id = ud.medicine_id " +
            "LEFT JOIN unit u ON ud.unit_id = u.id " +
            "WHERE " +
            "    m.flag_deleted = 0 " +
            "    AND m.name LIKE :keyword " +
            "    AND kom.name LIKE :type ", nativeQuery = true)
    Page<MedicineForHomePageDTO> getListMedicineWithPagination(@Param("keyword") String keyword,
                                                               @Param("type") String type,
                                                               Pageable pageable);
}
