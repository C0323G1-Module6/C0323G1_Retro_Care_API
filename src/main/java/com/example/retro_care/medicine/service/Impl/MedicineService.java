package com.example.retro_care.medicine.service.Impl;

import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.medicine.repository.IMedicineRepository;
import com.example.retro_care.medicine.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

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
        iMedicineRepository.updateMedicine(medicine.getId(), medicine.getName(), medicine.getPrice(),
                medicine.getQuantity(), medicine.getVat(), medicine.getNote(), medicine.getMaker(),
                medicine.getActiveElement(), medicine.getOrigin(), medicine.getRetailProfits(),
                medicine.getKindOfMedicine().getId());
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
        System.out.println(code);
        iMedicineRepository.addMedicine(code, medicine.getName(), medicine.getPrice(),
                medicine.getQuantity(), medicine.getVat(), medicine.getNote(), medicine.getMaker(),
                medicine.getActiveElement(), medicine.getOrigin(),
                medicine.getRetailProfits(), medicine.getKindOfMedicine().getId());
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
    public Page<Medicine> findAll(Pageable pageable) {
        return iMedicineRepository.findAll(pageable);
    }


    /**
     * author: DaoPTA
     * workday: 16/09/2023
     * Create a method delete medicine
     *
     * @param id Pass the id to get the object to delete
     */
    @Override
    public Boolean removeMedicine(Long id) {
        if (iMedicineRepository.findMedicineById(id) == null) {
            return true;
        }
        iMedicineRepository.findMedicineById(id);
        return false;
    }
}
