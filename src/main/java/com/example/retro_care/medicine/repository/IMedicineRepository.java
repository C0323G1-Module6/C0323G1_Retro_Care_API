package com.example.retro_care.medicine.repository;

import com.example.retro_care.medicine.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMedicineRepository extends JpaRepository<Medicine, Long> {
    /**
     * Find a Medicine by its ID-TinVV
     *
     * @param id The ID of the Medicine to find.
     * @return The Medicine object with the specified ID.
     */
    @Query(value = "SELECT m.id, m.code, m.name, m.price, m.quantity, m.vat, m.note, m.maker, m.active_element, m.origin, m.retail_profits, k.name\n" +
            "FROM retro_care.medicine AS m\n" +
            "JOIN kind_of_medicine AS k ON m.kind_of_medicine_id = k.id\n" +
            "where m.kind_of_medicine_id=3; ", nativeQuery = true)
    Medicine findMedicineById(@Param("id") Long id);

    /**
     * Add a new Medicine to the system-TinVV
     *
     * @param code             The code of the Medicine.
     * @param name             The name of the Medicine.
     * @param price            The price of the Medicine.
     * @param quantity         The quantity of the Medicine.
     * @param vat              The VAT (Value Added Tax) of the Medicine.
     * @param note             The note for the Medicine.
     * @param maker            The maker of the Medicine.
     * @param activeElement    The active element of the Medicine.
     * @param origin           The origin of the Medicine.
     * @param retailProfits    The retail profits of the Medicine.
     * @param kindOfMedicineId The ID of the associated KindOfMedicine.
     */

    @Modifying
    @Query(value = "INSERT INTO medicine (code, name, price, quantity, vat, note, maker, active_element, origin, " +
            "retail_profits, kind_of_medicine_id, flag_deleted) VALUES (:code, :name, :price, :quantity, :vat, :note, " +
            ":maker, :activeElement, :origin, :retailProfits, :kindOfMedicineId, 0)", nativeQuery = true)
    void addMedicine(@Param("code") String code, @Param("name") String name, @Param("price") Double price,
                     @Param("quantity") Long quantity, @Param("vat") Float vat, @Param("note") String note,
                     @Param("maker") String maker, @Param("activeElement") String activeElement, @Param("origin")
                     String origin, @Param("retailProfits") Float retailProfits, @Param("kindOfMedicineId")
                     Long kindOfMedicineId);

    /**
     * Update an existing Medicine in the system-TinVV
     *
     * @param id               The ID of the Medicine to update.
     * @param name             The updated name of the Medicine.
     * @param price            The updated price of the Medicine.
     * @param quantity         The updated quantity of the Medicine.
     * @param vat              The updated VAT (Value Added Tax) of the Medicine.
     * @param note             The updated note for the Medicine.
     * @param maker            The updated maker of the Medicine.
     * @param activeElement    The updated active element of the Medicine.
     * @param origin           The updated origin of the Medicine.
     * @param retailProfits    The updated retail profits of the Medicine.
     * @param kindOfMedicineId The updated ID of the associated KindOfMedicine.
     */
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

    /**
     * Author: medicine_DaoPTA
     * workday: 15/09/2023
     * function: Display Medicine list
     *
     * @param pageable the pageable to request a paged result, can be {@link Pageable#unpaged()}, must not be
     *                 {@literal null}.
     * @return : Medicine list with pagination
     */
//    @Modifying
    @Query(value = " SELECT m.*, ud.conversion_rate, ud.conversion_unit, u.name AS unit_name FROM medicine m" +
            " LEFT JOIN " +
            "    unit_detail ud ON m.id = ud.medicine_id " +
            " LEFT JOIN " +
            "    unit u ON ud.unit_id = u.id where m.flag_deleted = false", nativeQuery = true)
    Page<Medicine> findAll(Pageable pageable);

    /**
     * author: DaoPTA
     * workday: 16/09/2023
     * Delete medicine
     *
     * @param id Search medicine by id to delete
     */
    @Query(value = "update medicine set flag_deleted = true where medicine.id = :id", nativeQuery = true)
    void deleteMedicineById(@Param("id") Long id);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by code medicine
     *
     * @param searchByCode
     * @param pageable pagination after search
     * @return returns approximate drug code with filter.
     */
    @Query(value = "select * from medicine where medicine.code like CONCAT('%', :searchByCode ,'%')",nativeQuery = true)
    Page<Medicine> searchCode(@Param("searchByCode") String searchByCode, Pageable pageable);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by name medicine
     *
     * @param searchByName
     * @param pageable pagination after search
     * @return Returns the drug name that approximates the filter
     */
    @Query(value = "select * from medicine where medicine.name like CONCAT('%', :searchByName ,'%')",nativeQuery = true)
    Page<Medicine> searchName(@Param("searchByName") String searchByName ,Pageable pageable);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by active element of medicine
     *
     * @param searchByActiveElement
     * @param pageable pagination after search
     * @return returns the drug's active ingredient approximated by the filter
     */
    @Query(value = "select * from medicine where medicine.active_element like CONCAT('%', :searchByActiveElement ,'%')",nativeQuery = true)
    Page<Medicine> searchActiveElement(@Param("searchByActiveElement") String searchByActiveElement ,Pageable pageable);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by kind of medicine
     *
     * @param searchByNameKindOf Method to search for drug group names
     * @param pageable pagination after search
     * @return returns the drug group of the drug approximated by the filter
     */
    @Query(value = "select " +
            "* from (select medicine.*, kind_of_medicine.name from medicine join kind_of_medicine  " +
            "on kind_of_medicine.id = medicine.kind_of_medicine_id where name like CONCAT('%', :searchByNameKindOf ,'%') \"m . * n\") ", nativeQuery = true)
    Page<Medicine> searchByKindOfName(@Param("searchByNameKindOf") String searchByNameKindOf ,Pageable pageable);



    /**
     * author: VuNL
     * date create: 16/09/2023
     * function: find medicine when sell offline
     *
     * @param name
     * @return List medicine
     */
    @Query(nativeQuery = true, value = "select id, code, name, price, quantity from medicine " +
            "where name like :name% and flag_delete = false")
    List<Medicine> getMedicineByNameWhenSell(@Param("name") String name, Pageable pageable);


    /**
     * author: VuNL
     * date create: 16/09/2023
     * function: find medicine in a prescription
     *
     * @param id
     * @return List medicine
     */
    @Query(nativeQuery = true, value = "select m.id, m.code, m.name, m.price, m.quantity from medicine " +
            "as m join indication on i m.id = i.medicine_id where i.prescription_id = :id and flag_delete = false")
    List<Medicine> getMedicineByPrescriptionWhenSell(@Param("id") Long id);


}

