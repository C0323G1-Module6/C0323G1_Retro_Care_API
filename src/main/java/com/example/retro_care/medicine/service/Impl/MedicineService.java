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
        return iMedicineRepository.findAll();
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
     * @param searchByNameKindOfMedicine Parameters used to search
     * @return the drug group of the drug approximated by the filter
     */
    @Override
    public Page<IMedicineListDto> searchByNameKindOfMedicine(Pageable pageable, String searchByNameKindOfMedicine) {
        return iMedicineRepository.searchByKindOfName(searchByNameKindOfMedicine, pageable);
    }

    @Override
    public Page<IMedicineListDto> searchWithEqualPrice(Pageable pageable, Float price) {
        return iMedicineRepository.searchWithEqualPrice(price, pageable);
    }

    @Override
    public Page<IMedicineListDto> searchWithBiggerPrice(Pageable pageable, Float price) {
        return iMedicineRepository.searchWithBiggerPrice(price, pageable);
    }

    @Override
    public Page<IMedicineListDto> searchWithLittlePrice(Pageable pageable, Float price) {
        return iMedicineRepository.searchWithLittlePrice(price, pageable);
    }

    @Override
    public Page<IMedicineListDto> searchWithGreaterThanOrEqualPrice(Pageable pageable, Float price) {
        return iMedicineRepository.searchWithGreaterThanOrEqualPrice(price, pageable);
    }

    @Override
    public Page<IMedicineListDto> searchWithSmallerThanOrEqualPrice(Pageable pageable, Float price) {
        return iMedicineRepository.searchWithSmallerThanOrEqualPrice(price, pageable);
    }

    @Override
    public Page<IMedicineListDto> searchWithPriceNotEqual(Pageable pageable, Float price) {
        return iMedicineRepository.searchWithPriceNotEqual(price, pageable);
    }

    @Override
    public Medicine getMedicineById(Long id) {
        return iMedicineRepository.findById(id).get();
    }

    @Override
    public Page<IMedicineListDto> searchByPrice(Pageable pageable, String search, String conditional) {
        Float price = Float.parseFloat(search);
        switch (conditional) {
            case "equal":
               return searchWithEqualPrice(pageable,price);
            case "bigger":
                return searchWithBiggerPrice(pageable,price);
            case "litter":
                return searchWithLittlePrice(pageable,price);
            case "greater":
                return searchWithGreaterThanOrEqualPrice(pageable, price);
            case "small":
                return searchWithSmallerThanOrEqualPrice(pageable, price);
            case "notEqual":
                return searchWithPriceNotEqual(pageable,price);
            default:
                return findAll(pageable,search);
        }

    }

}
