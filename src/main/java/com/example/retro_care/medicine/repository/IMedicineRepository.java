package com.example.retro_care.medicine.repository;

import com.example.retro_care.medicine.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMedicineRepository extends JpaRepository<Medicine, Long> {
    @Query(value = "SELECT m.id, m.code, m.name, m.price, m.quantity, m.vat, m.note, m.maker, m.active_element, m.origin, m.retail_profits, k.name\n" +
            "FROM retro_care.medicine AS m\n" +
            "JOIN kind_of_medicine AS k ON m.kind_of_medicine_id = k.id\n" +
            "where m.kind_of_medicine_id=3; ", nativeQuery = true)
    Medicine findMedicineById(@Param("id") Long id);

    @Modifying
    @Query(value = "INSERT INTO medicine (code, name, price, quantity, vat, note, maker, active_element, origin, " +
            "retail_profits, kind_of_medicine_id, flag_deleted) VALUES (:code, :name, :price, :quantity, :vat, :note, " +
            ":maker, :activeElement, :origin, :retailProfits, :kindOfMedicineId, 0)", nativeQuery = true)
    void addMedicine(@Param("code") String code, @Param("name") String name, @Param("price") Double price,
                     @Param("quantity") Long quantity, @Param("vat") Float vat, @Param("note") String note,
                     @Param("maker") String maker, @Param("activeElement") String activeElement, @Param("origin")
                     String origin, @Param("retailProfits") Float retailProfits, @Param("kindOfMedicineId")
                     Long kindOfMedicineId);

    @Modifying
    @Query(value = "UPDATE medicine SET name = :name, price = :price, quantity = :quantity, vat = :vat, " +
            "note = :note, maker = :maker, active_element = :activeElement, origin = :origin, " +
            "retail_profits = :retailProfits, kind_of_medicine_id = :kindOfMedicineId " +
            "WHERE id = :id", nativeQuery = true)
    void updateMedicine(@Param("id") Long id, @Param("name") String name, @Param("price") Double price,
                        @Param("quantity") Long quantity, @Param("vat") Float vat, @Param("note") String note,
                        @Param("maker") String maker, @Param("activeElement") String activeElement,
                        @Param("origin") String origin, @Param("retailProfits") Float retailProfits,
                        @Param("kindOfMedicineId") Long kindOfMedicineId);
}
