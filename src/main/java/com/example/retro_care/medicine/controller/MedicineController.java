package com.example.retro_care.medicine.controller;

import com.example.retro_care.medicine.service.IMedicineService;
import com.example.retro_care.medicine.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/medicine")
public class MedicineController {
    @Autowired
    private IMedicineService iMedicineService;
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity findMedicineById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iMedicineService.findMedicineById(id), HttpStatus.OK);
    }
}
