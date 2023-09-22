package com.example.retro_care.medicine.repository;

import com.example.retro_care.medicine.dto.IMedicineListDto;
import com.example.retro_care.medicine.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IMedicineRepository extends JpaRepository<Medicine, Long> {
     String PREFIX_SEARCH_NOT_PRICE = " SELECT " +
            "    m.id AS id," +
            "    m.code AS code," +
            "    m.name AS name," +
            "    m.active_element AS activeElement," +
            "    m.quantity AS quantity," +
            "    m.vat AS vat," +
            "    m.price AS price," +
            "    m.retail_profits AS retailProfits," +
            "    km.name AS kindOfMedicineName," +
            "    u.name AS unitName," +
            "    id.discount AS discount, " +
            "    ud.conversion_unit AS conversionUnit," +
            "    ROUND(sum(m.price - (m.price/ (100+ (m.vat + m.retail_profits)) * 100))) as retailPrice " +
            " FROM " +
            " medicine m" +
            " JOIN" +
            " kind_of_medicine km ON m.kind_of_medicine_id = km.id" +
            "        JOIN" +
            "    unit_detail ud ON m.id = ud.medicine_id" +
            "        JOIN" +
            "    unit u ON ud.unit_id = u.id" +
            "        LEFT JOIN" +
            "    invoice_detail id ON m.id = id.medicine_id ";

    /**
     * Find a Medicine by its ID-TinVV
     *
     * @param id The ID of the Medicine to find.
     * @return The Medicine object with the specified ID.
     */
    @Query(value = "SELECT m.id, m.code, m.name, m.price, m.quantity, m.vat, m.note, m.maker, m.active_element, m.origin, m.retail_profits, k.name\n" +
            "FROM retro_care.medicine AS m\n" +
            "JOIN kind_of_medicine AS k ON m.kind_of_medicine_id = k.id\n" +
            "where m.id=:id ", nativeQuery = true)
    Medicine findMedicineById(@Param("id") Long id);

    /**
     * Adds a new Medicine to the database-TinVV
     *
     * @param medicine The Medicine object to be added.
     */

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO medicine (code, name, price, quantity, vat, note, maker, active_element, origin, " +
            "retail_profits, kind_of_medicine_id, flag_deleted) VALUES (:#{#medicine.code}, :#{#medicine.name}, " +
            ":#{#medicine.price}, :#{#medicine.quantity}, :#{#medicine.vat}, :#{#medicine.note}, :#{#medicine.maker}, " +
            ":#{#medicine.activeElement}, :#{#medicine.origin}, :#{#medicine.retailProfits}, " +
            ":#{#medicine.kindOfMedicine.id}, false)", nativeQuery = true)
    void addMedicine(@Param("medicine") Medicine medicine);

    /**
     * Retrieves the last inserted ID from the database-TinVV
     *
     * @return The last inserted ID as a {@code Long} value.
     */
    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    Long getLastInsertedId();


    /**
     * Updates the information of a Medicine in the database-TinVV
     *
     * @param medicine The updated Medicine object containing the new information.
     */

    @Transactional
    @Modifying
    @Query(value = "UPDATE medicine SET name = :#{#medicine.name}, price = :#{#medicine.price}, " +
            "quantity = :#{#medicine.quantity}, vat = :#{#medicine.vat}, note = :#{#medicine.note}, " +
            "maker = :#{#medicine.maker}, active_element = :#{#medicine.activeElement}, " +
            "origin = :#{#medicine.origin}, retail_profits = :#{#medicine.retailProfits}, " +
            "kind_of_medicine_id = :#{#medicine.kindOfMedicine.id} " +
            "WHERE id = :#{#medicine.id}", nativeQuery = true)
    void updateMedicine(@Param("medicine") Medicine medicine);

    /**
     * author: HanhNLM
     * date create: 21/09/2023
     * function: check medicine existence
     *
     * @param id
     * @return boolean
     */
    boolean existsByIdAndFlagDeletedIsFalse(Long id);

    /**
     * Author: medicine_DaoPTA
     * workday: 15/09/2023
     * function: Display Medicine list
     *
     * @param pageable the pageable to request a paged result, can be {@link Pageable#unpaged()}, must not be
     *                 {@literal null}.
     * @return : Medicine list with pagination
     */

    @Query(value = PREFIX_SEARCH_NOT_PRICE +
            " where " +
            " m.flag_deleted = false " +
            "group by m.id", nativeQuery = true)
    Page<IMedicineListDto> findAll(Pageable pageable,
                                          @Param("search") String search);

    /**
     * author: DaoPTA
     * workday: 16/09/2023
     * Delete medicine
     *
     * @param id Search medicine by id to delete
     */
    @Transactional
    @Modifying
    @Query(value = "update medicine set medicine.flag_deleted = 1 where medicine.id = :id", nativeQuery = true)
    int deleteMedicineById(@Param("id") Long id);

        /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by code medicine
     *
     * @param searchByCode
     * @param pageable pagination after search
     * @return returns approximate drug code with filter.
     */
//    @Query(value = "select * from medicine where medicine.code like CONCAT('%', :searchByCode ,'%')",nativeQuery = true)

        @Query(value = PREFIX_SEARCH_NOT_PRICE +" where m.flag_deleted = false " +
                "AND m.code like CONCAT('%', :searchByCode ,'%')" +
                " group by m.id", nativeQuery = true)
    Page<IMedicineListDto> searchCode(@Param("searchByCode") String searchByCode, Pageable pageable);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by name medicine
     *
     * @param searchByName
     * @param pageable pagination after search
     * @return Returns the drug name that approximates the filter
     */

    @Query(value = PREFIX_SEARCH_NOT_PRICE + " where m.flag_deleted = false " +
            "AND m.name like CONCAT('%', :searchByName ,'%') " +
            "group by m.id", nativeQuery = true)
    Page<IMedicineListDto> searchName(@Param("searchByName") String searchByName ,Pageable pageable);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by active element of medicine
     *
     * @param searchByActiveElement
     * @param pageable pagination after search
     * @return returns the drug's active ingredient approximated by the filter
     */
    @Query(value = PREFIX_SEARCH_NOT_PRICE +" where m.flag_deleted = false " +
            "AND m.active_element like CONCAT('%', :searchByActiveElement ,'%') " +
            "group by m.id", nativeQuery = true)
    Page<IMedicineListDto> searchActiveElement(@Param("searchByActiveElement") String searchByActiveElement ,Pageable pageable);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by kind of medicine
     *
     * @param searchByNameKindOfMedicine Method to search for drug group names
     * @param pageable pagination after search
     * @return returns the drug group of the drug approximated by the filter
     */

    @Query(value = PREFIX_SEARCH_NOT_PRICE +
            "where m.flag_deleted = false " +
            "AND km.name like CONCAT('%', :searchByNameKindOfMedicine ,'%') " +
            "group by m.id", nativeQuery = true)
    Page<IMedicineListDto> searchByKindOfName(@Param("searchByNameKindOfMedicine") String searchByNameKindOfMedicine ,Pageable pageable);

    @Query(value = PREFIX_SEARCH_NOT_PRICE +
            "where m.flag_deleted = false " +
            "group by m.id " +
            "HAVING :price = ROUND(sum(m.price - (m.price/ (100+ (m.vat + m.retail_profits)) * 100)))",nativeQuery = true)
    Page<IMedicineListDto> searchWithEqualPrice(@Param("price") Float price, Pageable pageable);

    @Query(value = PREFIX_SEARCH_NOT_PRICE +
            " where m.flag_deleted = false " +
            "group by m.id " +
            "HAVING :price < ROUND(sum(m.price - (m.price/ (100+ (m.vat + m.retail_profits)) * 100)))",nativeQuery = true)
    Page<IMedicineListDto> searchWithBiggerPrice(@Param("price") Float price, Pageable pageable);

    @Query(value = PREFIX_SEARCH_NOT_PRICE +
            "where m.flag_deleted = false " +
            "group by m.id " +
            "HAVING :price > ROUND(sum(m.price - (m.price/ (100+ (m.vat + m.retail_profits)) * 100)))",nativeQuery = true)
    Page<IMedicineListDto> searchWithLittlePrice(@Param("price") Float price, Pageable pageable);

    @Query(value = PREFIX_SEARCH_NOT_PRICE +
            " where m.flag_deleted = false " +
            "group by m.id " +
            "HAVING :price <= ROUND(sum(m.price - (m.price/ (100+ (m.vat + m.retail_profits)) * 100)))",nativeQuery = true)
    Page<IMedicineListDto> searchWithGreaterThanOrEqualPrice(@Param("price") Float price, Pageable pageable);

    @Query(value = PREFIX_SEARCH_NOT_PRICE +
            " where m.flag_deleted = false " +
            "group by m.id " +
            "HAVING :price >= ROUND(sum(m.price - (m.price/ (100+ (m.vat + m.retail_profits)) * 100)))",nativeQuery = true)
    Page<IMedicineListDto> searchWithSmallerThanOrEqualPrice(@Param("price") Float price, Pageable pageable);

    @Query(value =  PREFIX_SEARCH_NOT_PRICE +"where m.flag_deleted = false " +
            "group by m.id " +
            "HAVING :price != ROUND(sum(m.price - (m.price/ (100+ (m.vat + m.retail_profits)) * 100)))",nativeQuery = true)
    Page<IMedicineListDto> searchWithPriceNotEqual(@Param("price") Float price, Pageable pageable);

    @Query(value = " SELECT m.*, ud.conversion_rate, ud.conversion_unit, u.name AS unit_name FROM medicine m" +
            " LEFT JOIN " +
            "    unit_detail ud ON m.id = ud.medicine_id " +
            " LEFT JOIN " +
            "    unit u ON ud.unit_id = u.id where m.flag_deleted = false", nativeQuery = true)
    List<Medicine> findAll();

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

    Medicine getMedicinesByName(String nameMedicine);
}

