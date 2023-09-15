package com.example.retro_care.medicine.controller;

import com.example.retro_care.medicine.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/unit")
public class UnitController {
    @Autowired
    private IUnitService iUnitService;
    @GetMapping("")
    @ResponseBody
    public ResponseEntity findAll(){
        return new ResponseEntity<>(iUnitService.findAll(), HttpStatus.OK);
    }
}
