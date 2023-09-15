package com.example.retro_care.prescription.controller;

import com.example.retro_care.indication.model.Indication;
import com.example.retro_care.indication.service.IIndicationService;
import com.example.retro_care.prescription.model.Prescription;
import com.example.retro_care.prescription.service.IPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class PrescriptionController {
    @Autowired
    private IPrescriptionService prescriptionService;
    @Autowired
    private IIndicationService indicationService;

    @GetMapping("/prescription")
    public ResponseEntity<Page<Prescription>> getAllPrescription(@RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<Prescription> prescriptionPage = prescriptionService.findAllPrescription(pageable);
        if(prescriptionPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(prescriptionPage,HttpStatus.OK);
    }

    @PostMapping("/prescription/create")
    public ResponseEntity<?> createPrescription(@RequestBody Prescription prescription, @RequestBody Indication indication){
        prescriptionService.createPrescription(prescription);
        indicationService.createIndication(indication);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
