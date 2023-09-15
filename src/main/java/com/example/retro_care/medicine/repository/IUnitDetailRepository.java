package com.example.retro_care.medicine.repository;

import com.example.retro_care.medicine.model.UnitDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUnitDetailRepository extends JpaRepository<UnitDetail, Long> {
    @Modifying
    @Query(value = "INSERT INTO unit_detail (flag_deleted, conversion_unit, conversion_rate, medicine_id, unit_id) " +
            "VALUES (0, :conversionUnit, :conversionRate, :medicineId, :unitId)", nativeQuery = true)
    void addUnitDetail(@Param("conversionUnit") String conversionUnit, @Param("conversionRate") Long conversionRate,
                       @Param("medicineId") Long medicineId, @Param("unitId") Long unitId);

    @Modifying
    @Query(value = "UPDATE unit_detail SET conversion_unit = :conversionUnit, conversion_rate = :conversionRate, " +
            "unit_id = :unitId WHERE medicine_id = :medicineId ", nativeQuery = true)
    void updateUnitDetail(@Param("conversionUnit") String conversionUnit, @Param("conversionRate") Long conversionRate,
                          @Param("medicineId") Long medicineId, @Param("unitId") Long unitId);

    @Query(value = "SELECT u.conversion_unit, u.conversion_rate, u.unit_id FROM unit_detail as u WHERE " +
            "medicine_id = :medicineId", nativeQuery = true)
    List<UnitDetail> findUnitDetailByMedicineId(@Param("medicineId") Long medicineId);
}
