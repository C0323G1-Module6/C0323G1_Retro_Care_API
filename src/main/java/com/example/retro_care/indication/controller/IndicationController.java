package com.example.retro_care.indication.controller;

import com.example.retro_care.indication.model.Indication;
import com.example.retro_care.indication.service.IIndicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class IndicationController {
    @Autowired
    private IIndicationService indicationService;

    @GetMapping("/indication/{id}")
    public ResponseEntity<List<Indication>> getIndication(@PathVariable Long id){
        List<Indication> indicationList = indicationService.getAllIndication(id);
        return new ResponseEntity<>(indicationList, HttpStatus.OK);
    }
}
