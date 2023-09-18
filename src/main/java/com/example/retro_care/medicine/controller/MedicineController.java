package com.example.retro_care.medicine.controller;

import com.example.retro_care.medicine.dto.MedicineDto;
import com.example.retro_care.medicine.model.ImageMedicine;
import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.medicine.model.UnitDetail;
import com.example.retro_care.medicine.service.IImageMedicineService;
import com.example.retro_care.medicine.service.IMedicineService;
import com.example.retro_care.medicine.service.IUnitDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin("*")
@RequestMapping("/medicine")
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
     *         - HttpStatus.OK if the medicine is found.
     */
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity findMedicineById(@PathVariable("id") Long id) {
        iImageMedicineService.findImageMedicineByMedicineId(id);
        iUnitDetailService.findUnitDetailByMedicineId(id);
        iMedicineService.findMedicineById(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    /**
     * Add a new medicine to the system-TinVV
     *
     * @param medicineDto     The DTO object containing information about the new medicine.
     * @param bindingResult   The result of the data binding and validation process.
     * @return                ResponseEntity with the corresponding HTTP status code.
     *                        - HttpStatus.OK if the medicine is successfully added.
     *                        - HttpStatus.BAD_REQUEST if there are errors in the data validation process.
     */
    @PostMapping("")
    @ResponseBody
    public ResponseEntity addMedicine(@Valid @RequestBody MedicineDto medicineDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        // Create Medicine, UnitDetail, and ImageMedicine objects from medicineDto
        Medicine  medicine=new Medicine();
        UnitDetail unitDetail=new UnitDetail();
        ImageMedicine imageMedicine=new ImageMedicine();
        BeanUtils.copyProperties(medicineDto,medicine);
        BeanUtils.copyProperties(medicineDto.getUnitDetailDto(),unitDetail);
        BeanUtils.copyProperties(medicineDto.getImageMedicine(),imageMedicine);
        // Call the services to add medicine, image, and unit detail information to the system
        iMedicineService.addMedicine(medicine);
        iImageMedicineService.addImageMedicine(imageMedicine);
        iUnitDetailService.addUnitDetail(unitDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /**
     * Edit an existing medicine-TinVV
     *
     * @param medicineDto     The DTO object containing information about the edited medicine.
     * @param bindingResult   The result of the data binding and validation process.
     * @return                ResponseEntity with the corresponding HTTP status code.
     *                        - HttpStatus.OK if the medicine is successfully edited.
     *                        - HttpStatus.BAD_REQUEST if there are errors in the data validation process.
     */
    @PatchMapping("/{id}")
    @ResponseBody
    public ResponseEntity editMedicine(@Valid @RequestBody MedicineDto medicineDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        Medicine  medicine=new Medicine();
        UnitDetail unitDetail=new UnitDetail();
        ImageMedicine imageMedicine=new ImageMedicine();
        BeanUtils.copyProperties(medicineDto,medicine);
        BeanUtils.copyProperties(medicineDto.getUnitDetailDto(),unitDetail);
        BeanUtils.copyProperties(medicineDto.getImageMedicine(),imageMedicine);
        iMedicineService.editMedicine(medicine);
        iImageMedicineService.updateImageMedicine(imageMedicine);
        iUnitDetailService.updateUnitDetailByMedicineId(unitDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
