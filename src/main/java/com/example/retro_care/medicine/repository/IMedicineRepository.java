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
             " ud.conversion_unit AS conversionUnit," +
            "    ROUND(sum(m.price + (m.price * m.retail_profits / 100) )) as retailPrice " +
            " FROM " +
            " medicine m" +
            " JOIN" +
            " kind_of_medicine km ON m.kind_of_medicine_id = km.id" +
            "        JOIN" +
            "    unit_detail ud ON m.id = ud.medicine_id" +
            "        JOIN" +
            "    unit u ON ud.unit_id = u.id ";

    /**
     * Find a Medicine by its ID-TinVV
     *
     * @param id The ID of the Medicine to find.
     * @return The Medicine object with the specified ID.
     */
    @Query(value = "SELECT m.id, m.code, m.name, m.price, m.quantity, m.vat, m.note, m.maker, m.active_element, m.origin, m.retail_profits, k.name\n" +
            "FROM retro_care.medicine AS m\n" +
            "JOIN kind_of_medicine AS k ON m.kind_of_medicine_id = k.id\n" +
            "where m.id=:id and m.flag_deleted = false", nativeQuery = true)
    Medicine findMedicineById(@Param("id") Long id);

    /**
     * Find a Medicine by its Code-TinVV
     *
     * @param code The Code of the Medicine to find.
     * @return The Medicine object with the specified Code.
     */
    @Query(value = "SELECT m.id, m.code, m.name, m.price, m.quantity, m.vat, m.note, m.maker, m.active_element, m.origin, m.retail_profits, k.name\n" +
            "FROM retro_care.medicine AS m\n" +
            "JOIN kind_of_medicine AS k ON m.kind_of_medicine_id = k.id\n" +
            "where m.code=:code and m.flag_deleted = false", nativeQuery = true)
    Medicine findMedicineByCode(@Param("code") String code);

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
            "GROUP BY" +
            "    m.id, m.code, m.name, m.active_element, m.quantity, m.vat, m.price, m.retail_profits," +
            "    km.name, u.name, ud.conversion_unit ", nativeQuery = true)
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
    @Query(value = "update medicine m set m.flag_deleted = true where m.id = :id", nativeQuery = true)
    int deleteMedicineById(@Param("id") Long id);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by code medicine
     *
     * @param searchByCode
     * @param pageable     pagination after search
     * @return returns approximate drug code with filter.
     */

    @Query(value = PREFIX_SEARCH_NOT_PRICE + " where m.flag_deleted = false " +
            "AND m.code like CONCAT('%', :searchByCode ,'%')" +
            "GROUP BY" +
            "  m.id, m.code, m.name, m.active_element, m.quantity, m.vat, m.price, m.retail_profits," +
            " km.name, u.name, ud.conversion_unit", nativeQuery = true)
    Page<IMedicineListDto> searchCode(@Param("searchByCode") String searchByCode, Pageable pageable);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by name medicine
     *
     * @param searchByName
     * @param pageable     pagination after search
     * @return Returns the drug name that approximates the filter
     */

    @Query(value = PREFIX_SEARCH_NOT_PRICE + " where m.flag_deleted = false " +
            "AND m.name like CONCAT('%', :searchByName ,'%') " +
            "GROUP BY" +
            "  m.id, m.code, m.name, m.active_element, m.quantity, m.vat, m.price, m.retail_profits," +
            " km.name, u.name, ud.conversion_unit", nativeQuery = true)
    Page<IMedicineListDto> searchName(@Param("searchByName") String searchByName, Pageable pageable);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by active element of medicine
     *
     * @param searchByActiveElement
     * @param pageable              pagination after search
     * @return returns the drug's active ingredient approximated by the filter
     */
    @Query(value = PREFIX_SEARCH_NOT_PRICE + " where m.flag_deleted = false " +
            "AND m.active_element like CONCAT('%', :searchByActiveElement ,'%') " +
            "GROUP BY" +
            "  m.id, m.code, m.name, m.active_element, m.quantity, m.vat, m.price, m.retail_profits," +
            " km.name, u.name, ud.conversion_unit", nativeQuery = true)
    Page<IMedicineListDto> searchActiveElement(@Param("searchByActiveElement") String searchByActiveElement, Pageable pageable);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by kind of medicine
     *
     * @param searchByKindOfMedicine Method to search for drug group names
     * @param pageable               pagination after search
     * @return returns the drug group of the drug approximated by the filter
     */

    @Query(value = PREFIX_SEARCH_NOT_PRICE +
            "where m.flag_deleted = false " +
            "AND km.name like CONCAT('%', :searchByKindOfMedicine ,'%') " +
            "GROUP BY" +
            "  m.id, m.code, m.name, m.active_element, m.quantity, m.vat, m.price, m.retail_profits," +
            " km.name, u.name, ud.conversion_unit", nativeQuery = true)
    Page<IMedicineListDto> searchByKindOfName(@Param("searchByKindOfMedicine") String searchByKindOfMedicine, Pageable pageable);

    /**
     * author: DaoPTA
     * workday: 23/09/2023
     * search by retail price with conditional greater than or equal
     *
     * @param price
     * @param pageable
     * @return Price value is greater than or equal to the input price.
     */
    @Query(value = PREFIX_SEARCH_NOT_PRICE +
            " where m.flag_deleted = false " +
            "GROUP BY" +
            "  m.id, m.code, m.name, m.active_element, m.quantity, m.vat, m.price, m.retail_profits," +
            " km.name, u.name, ud.conversion_unit " +
            "HAVING :price <= ROUND(sum(m.price - (m.price/ (100+ (m.vat + m.retail_profits)) * 100)))", nativeQuery = true)
    Page<IMedicineListDto> searchWithGreaterThanOrEqualPrice(@Param("price") Float price, Pageable pageable);

    /**
     * author: DaoPTA
     * workday: 23/09/2023
     * search by retail price with conditional smaller than or equal
     *
     * @param price
     * @param pageable
     * @return Price value is less than or equal to the input price.
     */
    @Query(value = PREFIX_SEARCH_NOT_PRICE +
            " where m.flag_deleted = false " +
            "GROUP BY" +
            "  m.id, m.code, m.name, m.active_element, m.quantity, m.vat, m.price, m.retail_profits," +
            " km.name, u.name, ud.conversion_unit " +
            "HAVING :price >= ROUND(sum(m.price - (m.price/ (100+ (m.vat + m.retail_profits)) * 100)))", nativeQuery = true)
    Page<IMedicineListDto> searchWithSmallerThanOrEqualPrice(@Param("price") Float price, Pageable pageable);

    /**
     * author: DaoPTA
     * workday: 23/09/2023
     *
     * @return get list medicine
     */
    @Query(value = " SELECT m.*, ud.conversion_rate, ud.conversion_unit, u.name AS unit_name FROM medicine m" +
            " LEFT JOIN " +
            "    unit_detail ud ON m.id = ud.medicine_id " +
            " LEFT JOIN " +
            "    unit u ON ud.unit_id = u.id where m.flag_deleted = false", nativeQuery = true)
    List<Medicine> findAll();

    /**
     * author: ThanhKN
     * workday: 23/09/2023
     *
     * @return
     */
    @Query(value = "select * from medicine m " +
            "join unit_detail u on m.id = u.medicine_id " +
            "where u.conversion_unit like 'Viên' " +
            "and m.flag_deleted = false", nativeQuery = true)
    List<Medicine> getMedicineList();

    /**
     * author: ThanhKN
     * workday: 24/09/2023
     *
     * @param nameMedicine search by name
     * @return medicine list with name
     */
    Medicine getMedicinesByName(String nameMedicine);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE medicine SET medicine.quantity= :updateQuantity WHERE medicine.id = :medicineId AND flag_deleted = 0")
    void updateQuantity(@Param("medicineId") Long medicineId, @Param("updateQuantity") Long quantity);


    @Query(nativeQuery = true, value = "SELECT quantity FROM medicine WHERE medicine.id = :id AND flag_deleted = 0")
    Long getMedicineQuantity(@Param("id") Long medicineId);

    /**
     * Get a list for invoice
     * Code by CuongHLT
     *
     * @return List Medicine
     */
    @Query(value = "select * from medicine where flag_deleted =0", nativeQuery = true)
    List<Medicine> getAllForInvoice();
}

