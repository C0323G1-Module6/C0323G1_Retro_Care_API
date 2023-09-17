package com.example.retro_care.indication.controller;

import com.example.retro_care.indication.model.Indication;
import com.example.retro_care.indication.service.IIndicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class IndicationController {
    @Autowired
    private IIndicationService indicationService;

    /**
     * Author: ThanhKN
     * Goal:get indication by id
     * Date:17/09/2023
     * return indication list
     */
    @GetMapping("/indication/{id}")
    public ResponseEntity<List<Indication>> getIndication(@PathVariable Long id) {
        List<Indication> indicationList = indicationService.getAllIndication(id);
        return new ResponseEntity<>(indicationList, HttpStatus.OK);
    }

    /**
     * Author: ThanhKN
     * Goal:remove indication by id
     * Date:17/09/2023
     * return indication http status
     * @param id
     */
    @DeleteMapping("/indication/delete/{id}")
    public ResponseEntity<?> removeIndication(@PathVariable Long id) {
        indicationService.removeIndication(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Author: ThanhKN
     * Goal:get indication by id
     * Date:17/09/2023
     * return http status
     * @param indication
     */
    @PostMapping("/indication/create")
    public ResponseEntity<?> createIndication(@RequestBody Indication indication) {
        indicationService.createIndication(indication);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Author: ThanhKN
     * Goal:get indication by id
     * Date:17/09/2023
     * return http status
     * @param indication
     */
    @PutMapping("/indication/edit")
    public ResponseEntity<?> editIndication(@RequestBody Indication indication) {
        indicationService.editIndication(indication);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
