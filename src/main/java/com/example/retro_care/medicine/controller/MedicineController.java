package com.example.retro_care.medicine.controller;

import com.example.retro_care.medicine.dto.MedicineDto;
import com.example.retro_care.medicine.model.ImageMedicine;
import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.medicine.model.UnitDetail;
import com.example.retro_care.medicine.service.IImageMedicineService;
import com.example.retro_care.medicine.service.IMedicineService;
import com.example.retro_care.medicine.service.IUnitDetailService;
import com.example.retro_care.medicine.service.IUnitService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity findMedicineById(@PathVariable("id") Long id) {
        iImageMedicineService.findImageMedicineByMedicineId(id);
        iUnitDetailService.findUnitDetailByMedicineId(id);
        iMedicineService.findMedicineById(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @PostMapping("")
    @ResponseBody
    public ResponseEntity addMedicine(@Valid @RequestBody MedicineDto medicineDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        Medicine  medicine=new Medicine();
        UnitDetail unitDetail=new UnitDetail();
        ImageMedicine imageMedicine=new ImageMedicine();
        BeanUtils.copyProperties(medicineDto,medicine);
        BeanUtils.copyProperties(medicineDto.getUnitDetail(),unitDetail);
        BeanUtils.copyProperties(medicineDto.getImageMedicine(),imageMedicine);
        iMedicineService.addMedicine(medicine);
        iImageMedicineService.addImageMedicine(imageMedicine);
        iUnitDetailService.addUnitDetail(unitDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("")
    @ResponseBody
    public ResponseEntity editMedicine(@Valid @RequestBody MedicineDto medicineDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        Medicine  medicine=new Medicine();
        UnitDetail unitDetail=new UnitDetail();
        ImageMedicine imageMedicine=new ImageMedicine();
        BeanUtils.copyProperties(medicineDto,medicine);
        BeanUtils.copyProperties(medicineDto.getUnitDetail(),unitDetail);
        BeanUtils.copyProperties(medicineDto.getImageMedicine(),imageMedicine);
        iMedicineService.editMedicine(medicine);
        iImageMedicineService.updateImageMedicine(imageMedicine);
        iUnitDetailService.updateUnitDetailByMedicineId(unitDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
