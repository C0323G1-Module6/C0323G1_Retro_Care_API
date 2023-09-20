package com.example.retro_care.home.controller;

import com.example.retro_care.home.service.IHomeService;
import com.example.retro_care.medicine.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/home")
@CrossOrigin
public class HomeController {
    @Autowired
    private IHomeService homeService;

    /**
     * Find all medicines for homepage
     * @return List all medicine that do not have flag_deleted
     * @author HuyL
     */
    @GetMapping
    public ResponseEntity<List<Medicine>> findAllMedicineForHomepage() {
        List<Medicine> medicines = homeService.findAllMedicineForHomepage();

        if (medicines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    /**
     * Search medicines with name or type input string
     * @param keyword is the search string, get from the request param API
     * @param type    is the kind of medicine, get from the request param API
     * @return list all medicine related to keyword and type and do not have flag_deleted
     * @author HuyL
     */
    @GetMapping("/search")
    public ResponseEntity<List<Medicine>> searchMedicineForHomepage(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "") String type) {
        List<Medicine> medicines = homeService.searchMedicineForHomepage(keyword, type);

        if (medicines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    /**
     * Find favorite medicine base on their sale quantities
     * @return 30 medicines that have the most sale quantity
     * @author HuyL
     */
    @GetMapping("/favorite")
    public ResponseEntity<List<Medicine>> findFavoriteMedicineForHomepage() {
        List<Medicine> medicines = homeService.findFavoriteMedicineForHomepage();

        if (medicines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }
}
