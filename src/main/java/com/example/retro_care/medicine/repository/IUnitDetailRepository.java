package com.example.retro_care.medicine.repository;

import com.example.retro_care.medicine.model.UnitDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUnitDetailRepository extends JpaRepository<UnitDetail, Long> {
    /**
     * Add a new UnitDetail for a Medicine-TinVV
     *
     * @param conversionUnit The conversion unit for the UnitDetail.
     * @param conversionRate The conversion rate for the UnitDetail.
     * @param medicineId     The ID of the associated Medicine.
     * @param unitId         The ID of the associated Unit.
     */
    @Modifying
    @Query(value = "INSERT INTO unit_detail (flag_deleted, conversion_unit, conversion_rate, medicine_id, unit_id) " +
            "VALUES (0, :conversionUnit, :conversionRate, :medicineId, :unitId)", nativeQuery = true)
    void addUnitDetail(@Param("conversionUnit") String conversionUnit, @Param("conversionRate") Long conversionRate,
                       @Param("medicineId") Long medicineId, @Param("unitId") Long unitId);

    /**
     * Update an existing UnitDetail for a Medicine-TinVV
     *
     * @param conversionUnit The updated conversion unit for the UnitDetail.
     * @param conversionRate The updated conversion rate for the UnitDetail.
     * @param medicineId     The ID of the associated Medicine.
     * @param unitId         The updated ID of the associated Unit.
     */
    @Modifying
    @Query(value = "UPDATE unit_detail SET conversion_unit = :conversionUnit, conversion_rate = :conversionRate, " +
            "unit_id = :unitId WHERE medicine_id = :medicineId ", nativeQuery = true)
    void updateUnitDetail(@Param("conversionUnit") String conversionUnit, @Param("conversionRate") Long conversionRate,
                          @Param("medicineId") Long medicineId, @Param("unitId") Long unitId);

    /**
     * Retrieve a list of UnitDetail objects associated with a specific Medicine ID-Tinvv
     *
     * @param medicineId The ID of the Medicine.
     * @return A list of UnitDetail objects associated with the given Medicine ID.
     */
    @Query(value = "SELECT u.conversion_unit, u.conversion_rate, u.unit_id FROM unit_detail as u WHERE " +
            "medicine_id = :medicineId", nativeQuery = true)
    List<UnitDetail> findUnitDetailByMedicineId(@Param("medicineId") Long medicineId);
}
