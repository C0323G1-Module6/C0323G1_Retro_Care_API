package com.example.retro_care.kind_of_medicine.service;
import com.example.retro_care.kind_of_medicine.dto.IKindOfMedicineDto;
import com.example.retro_care.kind_of_medicine.model.KindOfMedicine;
import com.example.retro_care.kind_of_medicine.repository.IKindOfMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KindOfMedicineService implements IKindOfMedicineService {
    @Autowired
    private IKindOfMedicineRepository kindOfMedicineRepository;

    @Override
    public List<KindOfMedicine> getListKindOfMedicine() {
        return kindOfMedicineRepository.findAll();
    }

    @Override
    public Page<IKindOfMedicineDto> getPageKindOfMedicine(Pageable pageable, String searchCode, String searchName) {
        return kindOfMedicineRepository.findAllKindOfMedicine(pageable, searchCode, searchName);
    }

    @Override
    public KindOfMedicine getKindOfMedicineById(Long id) {
        return kindOfMedicineRepository.findById(id).get();
    }

    @Override
    public void deleteKindOfMedicineById(Long id) {
        kindOfMedicineRepository.deleteKindOfMedicineById(id);
    }

    @Override
    public Boolean deleteKindOfMedicine(Long id) {
        kindOfMedicineRepository.deleteById(id);
        return true;
    }

    @Override
    public void addKindOfMedicine(KindOfMedicine kindOfMedicine) {
        List<KindOfMedicine> kindOfMedicineList = kindOfMedicineRepository.findAll();
        // get max id
        int maxId = kindOfMedicineRepository.getMaxId();
        int newId = maxId + 1;
        String newCode="";
        if(newId <10){
            newCode = "NT000"+newId;
        }
        if (newId <100){
            newCode = "NT00"+newId;
        }
        if (newId <1000){
            newCode = "NT0"+newId;
        }
        String newName = kindOfMedicine.getName();
        Boolean newFlagDeleted = false;
        KindOfMedicine newKindOfMedicine = new KindOfMedicine(newCode, newName, newFlagDeleted);
        System.out.println(newKindOfMedicine);
        if (!kindOfMedicineList.contains(kindOfMedicine.getName())) {
            kindOfMedicineRepository.save(newKindOfMedicine);
        }

    }

    @Override
    public void editKindOfMedicine(KindOfMedicine kindOfMedicine) {
        kindOfMedicineRepository.save(kindOfMedicine);
    }
}
