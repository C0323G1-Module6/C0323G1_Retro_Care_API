package com.example.retro_care.medicine.repository;

import com.example.retro_care.medicine.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMedicineRepository extends JpaRepository<Medicine, Long> {
    @Query(value = "SELECT m.id, m.code, m.name, m.price, m.quantity, m.vat, m.note, m.maker, m.active_element, m.origin" +
            ", m.retail_profits, k.name FROM retro_care.medicine as m join kind_of_medicine as k where " +
            "m.kind_of_medicine_id=m.id; ", nativeQuery = true)
    Medicine findMedicineById(@Param("id") Long id);

}
