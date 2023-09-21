package com.example.retro_care.medicine.controller;

import com.example.retro_care.medicine.model.Unit;
import com.example.retro_care.medicine.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/unit")
public class UnitController {
    @Autowired
    private IUnitService iUnitService;
    /**
     * Retrieve all units from the system-TinVV
     *
     * @return ResponseEntity with the corresponding HTTP status code and the list of all units.
     *         - HttpStatus.OK if the units are successfully retrieved.
     */
    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Unit>> findAll(){
        return new ResponseEntity<>(iUnitService.findAll(), HttpStatus.OK);
    }
}
