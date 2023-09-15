package com.example.retro_care.medicine.repository;

import com.example.retro_care.medicine.model.UnitDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUnitDetailRepository extends JpaRepository<UnitDetail, Long> {
    @Modifying
    @Query(value = "INSERT INTO unit_detail ( conversion_unit, conversion_rate, medicine_id, unit_id) " +
            "VALUES (0, :conversionUnit, :conversionRate, :medicineId, :unitId)", nativeQuery = true)
    void addUnitDetail( @Param("conversionUnit") String conversionUnit, @Param("conversionRate") int conversionRate,
                        @Param("medicineId") long medicineId, @Param("unitId") long unitId);
}
