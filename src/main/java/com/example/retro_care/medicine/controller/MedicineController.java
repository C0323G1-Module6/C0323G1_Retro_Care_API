package com.example.retro_care.medicine.controller;

import com.example.retro_care.kind_of_medicine.model.KindOfMedicine;
import com.example.retro_care.medicine.dto.ImageMedicineDto;
import com.example.retro_care.medicine.dto.KindOfMedicineDto;
import com.example.retro_care.medicine.dto.IMedicineListDto;
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
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Map<String, String> errors = new HashMap<>();
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
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
            Map<String, String> errors = new HashMap<>();
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
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
     * @return ResponseEntity with the corresponding HTTP status code.
     * - HttpStatus.OK if the drug list has data.
     * - HttpStatus.NO_CONTENT if drug list has no data.
     */
    @GetMapping("/get-medicine")
    @ResponseBody
    public ResponseEntity<Page<IMedicineListDto>> medicineList(@RequestParam(defaultValue = "0", required = false) Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<IMedicineListDto> medicinePage = iMedicineService.findAll(pageable, "");
        if (medicinePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicinePage, HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMedicine(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Medicine> medicinePage = iMedicineService.getAll();
        for (Medicine m : medicinePage) {
            if (m.getId().equals(id)) {
                iMedicineService.removeMedicine(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /**
     * Multi-field search method for medicine
     * workday: 19/09/2023
     * author: DaoPTA
     *
     * @param page parameters for paging
     * @param limit Limit the number of records in the page
     * @param searchInMedicine parameters contain different search methods
     * @param search Search by input box
     * @return - If empty, list medicine will be returned
     *         - If there is data, the list to search will be returned
     */
    @GetMapping("/search")
    public ResponseEntity<Page<IMedicineListDto>> searchByMedicine(@RequestParam(defaultValue = "0", required = false) Integer page,
                                                                   @RequestParam(defaultValue = "5", required = false) Integer limit,
                                                                   @RequestParam(defaultValue = "",required = false) String searchInMedicine,
                                                                   @RequestParam(defaultValue = "", required = false) String search,
                                                                   @RequestParam(defaultValue = "", required = false) String conditional){

        Pageable pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.ASC,"code"));
        Page<IMedicineListDto> medicines;
        switch (searchInMedicine){
            case "searchByName":
                medicines = iMedicineService.searchByNameMedicine(pageable,search);
                break;
            case "searchByCode":
                medicines = iMedicineService.searchByCodeMedicine(pageable,search);
                break;
            case "searchByActiveElement":
                medicines = iMedicineService.searchActiveElement(pageable,search);
                break;
            case "searchByNameKindOfMedicine":
                medicines = iMedicineService.searchByNameKindOfMedicine(pageable,search);
                break;
            case "searchByPrice":
                medicines = iMedicineService.searchByPrice(pageable,search, conditional);
                if(conditional.equals("")){
                    return new ResponseEntity<>(medicines,HttpStatus.NO_CONTENT);
                }
            default:
                medicines = iMedicineService.findAll(pageable,search);
                break;
        }
        if (medicines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<>(medicines, HttpStatus.OK);
    }
    @GetMapping("/get-list")
    public ResponseEntity<List<Medicine>> medicineGetList(){
        List<Medicine> medicine = iMedicineService.getAll();
        if (medicine.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }
}