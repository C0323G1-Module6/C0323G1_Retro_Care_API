package com.example.retro_care.medicine.controller;

import com.example.retro_care.kind_of_medicine.model.KindOfMedicine;
import com.example.retro_care.medicine.dto.ImageMedicineDto;
import com.example.retro_care.medicine.dto.KindOfMedicineDto;
import com.example.retro_care.medicine.dto.MedicineDto;
import com.example.retro_care.medicine.dto.UnitDetailDto;
import com.example.retro_care.medicine.model.ImageMedicine;
import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.medicine.model.UnitDetail;
import com.example.retro_care.medicine.service.IImageMedicineService;
import com.example.retro_care.medicine.service.IMedicineService;
import com.example.retro_care.medicine.service.IUnitDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/medicine")
public class MedicineController {
    @Autowired
    private IMedicineService iMedicineService;
    @Autowired
    private IImageMedicineService iImageMedicineService;
    @Autowired
    private IUnitDetailService iUnitDetailService;


    /**
     * Find a medicine by its ID-TinVV
     *
     * @param id The ID of the medicine to find.
     * @return ResponseEntity with the corresponding HTTP status code.
     * - HttpStatus.OK if the medicine is found.
     */
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity findMedicineById(@PathVariable("id") Long id) {
        ImageMedicine imageMedicines = iImageMedicineService.findImageMedicineByMedicineId(id);
        UnitDetail unitDetails = iUnitDetailService.findUnitDetailByMedicineId(id);
        Medicine medicine = iMedicineService.findMedicineById(id);
        ImageMedicineDto imageMedicineDto = new ImageMedicineDto();
        KindOfMedicineDto kindOfMedicineDto = new KindOfMedicineDto();
        UnitDetailDto unitDetailDto = new UnitDetailDto();
        BeanUtils.copyProperties(unitDetails, unitDetailDto);
        BeanUtils.copyProperties(medicine.getKindOfMedicine(), kindOfMedicineDto);
        BeanUtils.copyProperties(imageMedicines, imageMedicineDto);
        MedicineDto medicineDto = new MedicineDto();
        medicineDto.setKindOfMedicineDto(kindOfMedicineDto);
        BeanUtils.copyProperties(medicine, medicineDto);
        unitDetailDto.setMedicine(medicine.getId());
        imageMedicineDto.setMedicine(medicine.getId());
        unitDetailDto.setUnit(unitDetails.getUnit().getId());
        medicineDto.setImageMedicineDto(imageMedicineDto);
        medicineDto.setUnitDetailDto(unitDetailDto);
        return new ResponseEntity<>(medicineDto, HttpStatus.OK);
    }

    /**
     * Add a new medicine to the system-TinVV
     *
     * @param medicineDto   The DTO object containing information about the new medicine.
     * @param bindingResult The result of the data binding and validation process.
     * @return ResponseEntity with the corresponding HTTP status code.
     * - HttpStatus.OK if the medicine is successfully added.
     * - HttpStatus.BAD_REQUEST if there are errors in the data validation process.
     */
    @PostMapping("")
    @ResponseBody
    public ResponseEntity addMedicine(@Valid @RequestBody MedicineDto medicineDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Medicine medicine = new Medicine();
        KindOfMedicine kindOfMedicine = new KindOfMedicine();
        UnitDetail unitDetail = new UnitDetail();
        ImageMedicine imageMedicine = new ImageMedicine();
        BeanUtils.copyProperties(medicineDto, medicine);
        BeanUtils.copyProperties(medicineDto.getKindOfMedicineDto(), kindOfMedicine);
        medicine.setKindOfMedicine(kindOfMedicine);
        BeanUtils.copyProperties(medicineDto.getUnitDetailDto(), unitDetail);
        BeanUtils.copyProperties(medicineDto.getImageMedicineDto(), imageMedicine);
        iMedicineService.addMedicine(medicine);
        Long idMedicine = iMedicineService.getLastInsertedId();
        if (idMedicine != null) {
            iImageMedicineService.addImageMedicine(imageMedicine, idMedicine);
            iUnitDetailService.addUnitDetail(unitDetail, idMedicine, medicineDto.getUnitDetailDto().getUnit());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Edit an existing medicine-TinVV
     *
     * @param medicineDto   The DTO object containing information about the edited medicine.
     * @param bindingResult The result of the data binding and validation process.
     * @return ResponseEntity with the corresponding HTTP status code.
     * - HttpStatus.OK if the medicine is successfully edited.
     * - HttpStatus.BAD_REQUEST if there are errors in the data validation process.
     */
    @PatchMapping("/{id}")
    @ResponseBody
    public ResponseEntity editMedicine(@Valid @RequestBody MedicineDto medicineDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Medicine medicine = new Medicine();
        KindOfMedicine kindOfMedicine = new KindOfMedicine();
        UnitDetail unitDetail = new UnitDetail();
        ImageMedicine imageMedicine = new ImageMedicine();
        BeanUtils.copyProperties(medicineDto, medicine);
        BeanUtils.copyProperties(medicineDto.getKindOfMedicineDto(), kindOfMedicine);
        medicine.setKindOfMedicine(kindOfMedicine);
        BeanUtils.copyProperties(medicineDto.getUnitDetailDto(), unitDetail);
        BeanUtils.copyProperties(medicineDto.getImageMedicineDto(), imageMedicine);
        iMedicineService.editMedicine(medicine);
        iImageMedicineService.updateImageMedicine(imageMedicine, medicine.getId());
        iUnitDetailService.updateUnitDetailByMedicineId(unitDetail, medicine.getId(), medicineDto.getUnitDetailDto().getUnit());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * author: DaoPTA
     * Medicine List
     *
     * @param page pagination of medication list
     * @param size Divide the number of records per page
     * @return ResponseEntity with the corresponding HTTP status code.
     * - HttpStatus.OK if the drug list has data.
     * - HttpStatus.NO_CONTENT if drug list has no data.
     */
    @GetMapping("/api/medicine")
    @ResponseBody
    public ResponseEntity<Page<Medicine>> medicineList(@RequestParam(defaultValue = "0", required = false) int page,
                                                       @RequestParam(defaultValue = "5", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Medicine> medicinePage = iMedicineService.findAll(pageable);
        if (medicinePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicinePage, HttpStatus.OK);
    }


    /**
     * author: DaoPTA
     * workday: 16/09/2023
     *
     * @param id Pass the id to get the object to delete
     * @return ResponseEntity with the corresponding HTTP status code.
     * - HttpStatus.OK If I get the id and delete it
     * - HttpStatus.NO_CONTENT If I don't get the id or status of medicine is true
     */
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Page<Medicine>> deleteMedicine(@PathVariable Long id) {
//        if (iMedicineService.removeMedicine(id)) {
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//    }
//
//    /**
//     * author: DaoPTA
//     * workday: 18/09/2023
//     * Search by name Medicine
//     *
//     * @param page         Pagination after search
//     * @param limit        Limit the number per page
//     * @param sort         Arrange records in each page
//     * @param searchByName value when filtering
//     * @return ResponseEntity<?>
//     */
//    @GetMapping("/search/{page}/{limit}")
//    public ResponseEntity<Page<Medicine>> searchCodeMedicine(@RequestParam(value = "page", required = false) Integer page,
//                                                             @RequestParam(value = "limit", required = false) Integer limit,
//                                                             @RequestParam(value = "sort", required = false) String sort,
//                                                             @RequestParam(value = "searchByName", required = false) String searchByName,
//                                                             @RequestParam(value = "searchByCode", required = false) String searchByCode,
//                                                             @RequestParam(value = "searchByActiveElement", required = false) String searchByActiveElement) {
//        Pageable pageable = PageRequest.of(page, limit, Sort.by(sort));
//        Page<Medicine> medicines = iMedicineService.searchByMedicine(pageable, searchByName, searchByCode, searchByActiveElement);
//        if (medicines.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(medicines, HttpStatus.OK);
//    }
}
