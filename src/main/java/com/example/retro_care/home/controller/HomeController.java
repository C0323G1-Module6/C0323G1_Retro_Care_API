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
@RequestMapping("/api/home")
@CrossOrigin
public class HomeController {
    @Autowired
    private IHomeService homeService;

    @GetMapping
    public ResponseEntity<List<Medicine>> findAllMedicineForHomepage() {
        return new ResponseEntity<>(homeService.findAllMedicineForHomepage(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Medicine>> searchMedicineForHomepage(String inputString) {
        return new ResponseEntity<>(homeService.searchMedicineForHomepage(inputString), HttpStatus.OK);
    }

    @GetMapping("/favorite")
    public ResponseEntity<List<Medicine>> findFavoriteMedicineForHomepage() {
        return new ResponseEntity<>(homeService.findFavoriteMedicineForHomepage(), HttpStatus.OK);
    }

}
