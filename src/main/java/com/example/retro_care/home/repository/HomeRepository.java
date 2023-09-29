package com.example.retro_care.home.repository;

import com.example.retro_care.home.dto.MedicineForHomePageDTO;
import com.example.retro_care.medicine.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface HomeRepository extends JpaRepository<Medicine, Long> {

    /**
     * Search for medicines based on a search string and kind of medicine.
     *
     * @param keyword The search string.
     * @param type    The kind of medicine.
     * @return A list of all medicines related to the provided keyword and type, excluding deleted ones.
     * @author HuyL
     */
    @Query(value = " SELECT " +
            "    m.id AS medicineId, " +
            "    m.name AS medicineName, " +
            "    m.price AS medicinePrice, " +
            "    kom.name AS medicineType, " +
            "    MIN(im.image_path) AS medicineImage, " +
            "    u.name AS medicineUnit " +
            "FROM " +
            "    medicine m " +
            "JOIN " +
            "    kind_of_medicine kom ON m.kind_of_medicine_id = kom.id " +
            "JOIN " +
            "    image_medicine im ON m.id = im.medicine_id " +
            "LEFT JOIN " +
            "    unit_detail ud ON m.id = ud.medicine_id " +
            "LEFT JOIN\n" +
            "    unit u ON ud.unit_id = u.id " +
            "WHERE " +
            "    m.flag_deleted = 0 " +
            "    AND m.name LIKE :keyword " +
            "    AND kom.name LIKE :type " +
            "GROUP BY\n" +
            "    m.id, m.name, m.price, kom.name, u.name ORDER BY m.id DESC ", nativeQuery = true)
    List<MedicineForHomePageDTO> findMedicineForHomepage(@Param("keyword") String keyword, @Param("type") String type);

    /**
     * Find favorite medicines based on their sale quantities.
     *
     * @return The top 30 medicines with the highest sale quantities.
     * @author HuyL
     */
    @Query(value = " SELECT " +
            "    m.id AS medicineId, " +
            "    m.name AS medicineName, " +
            "    m.price AS medicinePrice, " +
            "    kom.name AS medicineType, " +
            "    u.name AS medicineUnit, " +
            "    MIN(im.image_path) AS medicineImage, " +
            "    SUM(od.quantity) AS medicineSaleQuantity " +
            "FROM\n" +
            "    medicine m " +
            "JOIN\n" +
            "    order_details od ON m.id = od.medicine_id " +
            "LEFT JOIN " +
            "    image_medicine im ON m.id = im.medicine_id " +
            "LEFT JOIN " +
            "    unit_detail ud ON m.id = ud.medicine_id\n" +
            "LEFT JOIN " +
            "    unit u ON ud.unit_id = u.id " +
            "JOIN\n" +
            "    kind_of_medicine kom ON m.kind_of_medicine_id = kom.id " +
            "GROUP BY\n" +
            "    m.id, m.name, m.price, kom.name, u.name " +
            "ORDER BY\n" +
            "    SUM(od.quantity) DESC " +
            "LIMIT 30; ", nativeQuery = true)
    List<MedicineForHomePageDTO> findFavoriteMedicineForHomepage();

    /**
     * Retrieve a paginated list of medicines for the home page based on a search string and kind of medicine.
     *
     * @param keyword  The search string.
     * @param type     The kind of medicine.
     * @param pageable Pagination information.
     * @return A paginated list of medicines based on the provided keyword, type, and pagination settings.
     * @author HuyL
     */
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
