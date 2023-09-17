package com.example.retro_care.medicine.service;

import com.example.retro_care.medicine.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMedicineService {
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
     * Display list Medicine
     * author: medicine_DaoPTA
     * workday: 15/09/2023
     *
     * @param pageable pagination of medication list
     * @return : Medicine list with pagination
     */
    Page<Medicine> findAll(Pageable pageable);

    /**
     * author: DaoPTA
     * workday: 16/09/2023
     * Delete medicine
     *
     * @param id Search medicine by id to delete
     * @return Boolean
     */
    Boolean removeMedicine(Long id);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search for drugs by medicine code
     *
     * @param pageable Pagination after search
     * @param searchByCode Parameters used to search
     * @return approximate drug code with filter.
     */
    Page<Medicine> searchByCodeMedicine(Pageable pageable,String searchByCode);

    /**
     * author: DaoPTA
     * workday: 17/06/2023
     * Search by medicine name
     *
     * @param pageable Pagination after search
     * @param searchByName Parameters used to search
     * @return the drug name that approximates the filter
     */
    Page<Medicine> searchByNameMedicine(Pageable pageable,String searchByName);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by active element of medicine
     *
     * @param pageable Pagination after search
     * @param searchByActiveElement Parameters used to search
     * @return the drug's active ingredient approximated by the filter
     */
    Page<Medicine> searchActiveElement(Pageable pageable,String searchByActiveElement);

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by kind of medicine
     *
     * @param pageable Pagination after search
     * @param searchByNameKindOf Parameters used to search
     * @return the drug group of the drug approximated by the filter
     */
    Page<Medicine> searchByKind(Pageable pageable,String searchByNameKindOf);
}
