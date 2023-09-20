package com.example.retro_care.home.repository;

import com.example.retro_care.home.dto.MedicineForHomePageDTO;
import com.example.retro_care.medicine.model.Medicine;
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
    @Query(value = " SELECT m.id AS medicineId, m.name AS medicineName, m.price AS medicinePrice, im.image_path AS medicineImage " +
            "FROM medicine m JOIN kind_of_medicine kom ON m.kind_of_medicine_id = kom.id " +
            "JOIN image_medicine im ON m.id = im.medicine_id " +
            "WHERE " +
            "    m.flag_deleted = 0 " +
            "    AND m.name LIKE :keyword " +
            "    AND kom.name LIKE :type LIMIT 30", nativeQuery = true)
    List<MedicineForHomePageDTO> findMedicineForHomepage(@Param("keyword") String keyword, @Param("type") String type);

    /**
     * Find favorite medicine base on their sale quantities
     * @return 30 medicines that have the most sale quantity
     * @author HuyL
     */
    @Query(value = " SELECT\n" +
            "    m.id AS medicineId,\n" +
            "    m.name AS medicineName,\n" +
            "    m.price AS medicinePrice,\n" +
            "    im.image_path AS medicineImage,\n" +
            "    SUM(od.quantity) AS medicineSaleQuantity " +
            "FROM " +
            "    medicine m " +
            "JOIN\n" +
            "    order_details od ON m.id = od.medicine_id " +
            "LEFT JOIN\n" +
            "    image_medicine im ON m.id = im.medicine_id " +
            "GROUP BY " +
            "    m.id, m.name, m.price, im.image_path " +
            "ORDER BY\n" +
            "    SUM(od.quantity) DESC " +
            "LIMIT 30;", nativeQuery = true)
    List<MedicineForHomePageDTO> findFavoriteMedicineForHomepage();
}
