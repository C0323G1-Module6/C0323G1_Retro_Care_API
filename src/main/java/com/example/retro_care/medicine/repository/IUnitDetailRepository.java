package com.example.retro_care.medicine.repository;

import com.example.retro_care.medicine.model.UnitDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface IUnitDetailRepository extends JpaRepository<UnitDetail, Long> {
    /**
     * This method is used to add a new unit detail record to the unit_detail table in the database-TinVV
     *
     * @param unitDetail The UnitDetail object containing the information for the new unit detail record.
     * @param medicineId The ID of the medicine associated with the unit detail record.
     */

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO unit_detail (flag_deleted, conversion_unit, conversion_rate, medicine_id, unit_id) " +
            "VALUES (false, :#{#unitDetail.conversionUnit}, " +
            ":#{#unitDetail.conversionRate}, :medicineId, :unitId)", nativeQuery = true)
    void addUnitDetail(@Param("unitDetail") UnitDetail unitDetail, Long medicineId,Long unitId);

    /**
     * This method is used to update an existing unit detail record in the unit_detail table in the database-TinVV
     *
     * @param unitDetail The UnitDetail object containing the updated information for the unit detail record.
     * @param medicineId The ID of the medicine associated with the unit detail record.
     */

    @Transactional
    @Modifying
    @Query(value = "UPDATE unit_detail SET conversion_unit = :#{#unitDetail.conversionUnit}, " +
            "conversion_rate = :#{#unitDetail.conversionRate}, unit_id = :unitId " +
            "WHERE medicine_id = :medicineId", nativeQuery = true)
    void updateUnitDetail(@Param("unitDetail") UnitDetail unitDetail, Long medicineId,Long unitId);

    /**
     * Retrieve a  UnitDetail objects associated with a specific Medicine ID-Tinvv
     *
     * @param medicineId The ID of the Medicine.
     * @return A list of UnitDetail objects associated with the given Medicine ID.
     */
    @Query(value = "SELECT u.id,u.conversion_unit, u.conversion_rate, u.unit_id , u.flag_deleted,u.medicine_id FROM unit_detail as u WHERE " +
            "u.medicine_id = :medicineId", nativeQuery = true)
      UnitDetail findUnitDetailByMedicineId(@Param("medicineId") Long medicineId);
}
