package com.example.retro_care.medicine.service;

import com.example.retro_care.medicine.dto.IMedicineListDto;
import com.example.retro_care.medicine.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMedicineService {

    /**
     * Retrieves a Medicine object based on the provided code-TinVV
     *
     * @param code The code of the Medicine to retrieve.
     * @return The Medicine object associated with the given code, or null if not found.
     */
    Medicine findMedicineByCode(String code);
    /**
     * Retrieve a Medicine object by its ID-TinVV
     *
     * @param id The ID of the Medicine.
     * @return The Medicine object associated with the given ID, or null if not found.
     */
    Medicine findMedicineById(Long id);

    /**
     * Edit an existing Medicine-TinVV
     *
     * @param medicine The updated Medicine object.
     */
    void editMedicine(Medicine medicine);

    /**
     * Add a new Medicine-TinVV
     *
     * @param medicine The Medicine object to be added.
     */
    void addMedicine(Medicine medicine);

    /**
     * Retrieves the ID of the last inserted record in the database-TinVV
     *
     * @return The ID of the last inserted record as a {@code Long} value.
     */
    Long getLastInsertedId();

    boolean existsByIdAndFlagDeletedIsFalse(Long id);

    /**
     * Display list Medicine
     * author: medicine_DaoPTA
     * workday: 15/09/2023
     *
     * @param pageable pagination of medication list
     * @return : Medicine list with pagination
     */
    Page<IMedicineListDto> findAll(Pageable pageable, String search);

    /**
     * author: DaoPTA
     * workday: 16/09/2023
     * Delete medicine
     *
     * @param id Search medicine by id to delete
     * @return Boolean
     */
    int removeMedicine(Long id);

    List<Medicine> getAll();

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search for drugs by medicine code
     *
     * @param pageable Pagination after search
     * @param searchByCode Parameters used to search
     * @return approximate drug code with filter.
     */
    Page<IMedicineListDto> searchByCodeMedicine(Pageable pageable,String searchByCode);

    /**
     * author: DaoPTA
     * workday: 17/06/2023
     * Search by medicine name
     *
     * @param pageable Pagination after search
     * @param searchByName Parameters used to search
     * @return the drug name that approximates the filter
     */
    Page<IMedicineListDto> searchByNameMedicine(Pageable pageable,String searchByName);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by active element of medicine
     *
     * @param pageable Pagination after search
     * @param searchByActiveElement Parameters used to search
     * @return the drug's active ingredient approximated by the filter
     */
    Page<IMedicineListDto> searchActiveElement(Pageable pageable,String searchByActiveElement);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by kind of medicine
     *
     * @param pageable Pagination after search
     * @param searchByKindOfMedicine Parameters used to search
     * @return the drug group of the drug approximated by the filter
     */
    Page<IMedicineListDto> searchByNameKindOfMedicine(Pageable pageable,String searchByKindOfMedicine);

    /**
     * author: DaoPTA
     * workday: 22/09/2023
     * @param price value of search
     * @param pageable pagination with medicine list
     * @return value to compare with conditional
     */
    Page<IMedicineListDto> searchWithGreaterThanOrEqualPrice(Pageable pageable, Float price);

    /**
     * author: DaoPTA
     * workday: 22/09/2023
     * @param price value of search
     * @param pageable pagination with medicine list
     * @return value to compare with conditional
     */
    Page<IMedicineListDto> searchWithSmallerThanOrEqualPrice(Pageable pageable, Float price);


    Medicine getMedicineById(Long id);
    Medicine getMedicineByName(String nameMedicine);

    List<Medicine> listMedicine();

    Page<IMedicineListDto> searchByPrice(Pageable pageable, String search, String conditional);

    /**
     * Get a list for invoice
     * Code by CuongHLT
     * @return List Medicine
     */
    List<Medicine> getAllForInvoice();
}
