package com.example.retro_care.medicine.service.Impl;

import com.example.retro_care.medicine.dto.IMedicineListDto;
import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.medicine.repository.IMedicineRepository;
import com.example.retro_care.medicine.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicineService implements IMedicineService {
    @Autowired
    private IMedicineRepository iMedicineRepository;

    /**
     * Find a medicine by its ID-TinVV
     *
     * @param id The ID of the medicine to find.
     * @return The Medicine object with the specified ID.
     */
    @Override
    public Medicine findMedicineById(Long id) {
        return iMedicineRepository.findMedicineById(id);
    }

    /**
     * Edit an existing medicine-TinVV
     *
     * @param medicine The Medicine object containing the updated information.
     */
    @Override
    public void editMedicine(Medicine medicine) {
        iMedicineRepository.updateMedicine(medicine);
    }

    /**
     * Add a new medicine to the system-TinVV
     *
     * @param medicine The Medicine object to be added.
     */
    @Override
    public void addMedicine(Medicine medicine) {
        UUID uuid = UUID.randomUUID();
        String code = uuid.toString().replace("-", "").substring(0, 8);
        medicine.setCode(code);
        iMedicineRepository.addMedicine(medicine);
    }

    /**
     * Retrieves the ID of the last inserted record in the database-TinVV
     *
     * @return The ID of the last inserted record as a {@code Long} value.
     */
    @Override
    public Long getLastInsertedId() {
        return iMedicineRepository.getLastInsertedId();
    }

    @Override
    public boolean existsByIdAndFlagDeletedIsFalse(Long id) {
        return iMedicineRepository.existsByIdAndFlagDeletedIsFalse(id);
    }


    /**
     * author: DaoPTA
     * workday: 16/09/2023
     * Create a method display list
     *
     * @param pageable
     * @return Display medicine list
     */
    @Override
    public Page<IMedicineListDto> findAll(Pageable pageable, String search) {
        return iMedicineRepository.findAll(pageable, search);
    }

    /**
     * author: DaoPTA
     * workday: 16/09/2023
     * Create a method delete medicine
     *
     * @param id Pass the id to get the object to delete
     */
    @Override
    public int removeMedicine(Long id) {
        return iMedicineRepository.deleteMedicineById(id);
    }

    @Override
    public List<Medicine> getAll() {
        return iMedicineRepository.getMedicineList();
    }

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search for drugs by medicine code
     *
     * @param pageable Pagination after search
     * @param searchByCode Parameters used to search
     * @return approximate drug code with filter.
     */
    @Override
    public Page<IMedicineListDto> searchByCodeMedicine(Pageable pageable, String searchByCode) {
        return iMedicineRepository.searchCode(searchByCode, pageable);
    }

    /**
     * author: DaoPTA
     * workday: 17/06/2023
     * Search by medicine name
     *
     * @param pageable Pagination after search
     * @param searchByName Parameters used to search
     * @return the drug name that approximates the filter
     */
    @Override
    public Page<IMedicineListDto> searchByNameMedicine(Pageable pageable, String searchByName) {
        return iMedicineRepository.searchName(searchByName, pageable);
    }

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by active element of medicine
     *
     * @param pageable Pagination after search
     * @param searchByActiveElement Parameters used to search
     * @return the drug's active ingredient approximated by the filter
     */
    @Override
    public Page<IMedicineListDto> searchActiveElement(Pageable pageable, String searchByActiveElement) {
        return iMedicineRepository.searchActiveElement(searchByActiveElement, pageable);
    }

    /**
     * author: DaoPTA
     * workday: 17/09/2023
     * Search by kind of medicine
     *
     * @param pageable Pagination after search
     * @param searchByKindOfMedicine Parameters used to search
     * @return the drug group of the drug approximated by the filter
     */
    @Override
    public Page<IMedicineListDto> searchByNameKindOfMedicine(Pageable pageable, String searchByKindOfMedicine) {
        return iMedicineRepository.searchByKindOfName(searchByKindOfMedicine, pageable);
    }

    /**
     * author: DaoPTA
     * workday: 22/09/2023
     *
     * @param pageable pagination with medicine list
     * @param price Search value to compare with retail price
     * @return value to compare with retail price
     */
    @Override
    public Page<IMedicineListDto> searchWithGreaterThanOrEqualPrice(Pageable pageable, Float price) {
        return iMedicineRepository.searchWithGreaterThanOrEqualPrice(price, pageable);
    }

    /**
     * author: DaoPTA
     * workday: 22/09/2023
     *
     * @param pageable pagination with medicine list
     * @param price Search value to compare with retail price
     * @return value to compare with retail price
     */
    @Override
    public Page<IMedicineListDto> searchWithSmallerThanOrEqualPrice(Pageable pageable, Float price) {
        return iMedicineRepository.searchWithSmallerThanOrEqualPrice(price, pageable);
    }


    @Override
    public Medicine getMedicineById(Long id) {
        return iMedicineRepository.findById(id).get();
    }

    /**
     * author: ThanhKN
     * workday: 24/09/2023
     *
     * @param nameMedicine search by name
     * @return medicine list with name
     */
    @Override
    public Medicine getMedicineByName(String nameMedicine) {
        return iMedicineRepository.getMedicinesByName(nameMedicine);
    }

    /**
     * author: DaoPTA
     * workday: 23/09/2023
     *
     * @return get list medicine
     */
    @Override
    public List<Medicine> listMedicine() {
        return iMedicineRepository.findAll();
    }

    /**
     * author: DaoPTA
     * workday: 22/09/2023
     *
     * @param pageable pagination with medicine list
     * @param search Search value to compare with meidicne
     * @param conditional Search value to compare with conditional
     * @return value to compare with conditional
     */
    @Override
    public Page<IMedicineListDto> searchByPrice(Pageable pageable, String search, String conditional) {
        Float price = null;
        try{
           price  = Float.parseFloat(search);
            switch (conditional) {
                case "greater":
                    return searchWithGreaterThanOrEqualPrice(pageable, price);
                case "small":
                    return searchWithSmallerThanOrEqualPrice(pageable, price);
                default:
                    return findAll(pageable,search);
            }
        }catch (Exception e){
            return findAll(pageable,search);
        }

    }

    /**
     * Get a list for invoice
     * Code by CuongHLT
     * @return List Medicine
     */
    @Override
    public List<Medicine> getAllForInvoice() {
        return iMedicineRepository.getAllForInvoice();
    }

}
