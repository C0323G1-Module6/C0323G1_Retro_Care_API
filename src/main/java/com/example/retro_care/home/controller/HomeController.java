package com.example.retro_care.home.controller;

import com.example.retro_care.home.service.IHomeService;
import com.example.retro_care.medicine.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class HomeController {
    @Autowired
    private IHomeService homeService;

    @GetMapping
    public ResponseEntity<List<Medicine>> findAllMedicineForHomepage() {
        return new ResponseEntity<>(homeService.findAllMedicineForHomepage(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Medicine>> searchMedicineHomepage(String name) {
        return new ResponseEntity<>(homeService.searchMedicineForHomepage(name), HttpStatus.OK);
    }

}