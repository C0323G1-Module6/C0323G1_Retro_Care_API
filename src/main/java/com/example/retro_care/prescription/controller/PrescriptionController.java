package com.example.retro_care.prescription.controller;

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

    /**
     * Author: ThanhKN
     * Goal:get all prescription
     * Return page prescription
     * Date:17/09/2023
     * @param page, size
     */
    @GetMapping("/prescription")
    public ResponseEntity<Page<Prescription>> getAllPrescription(@RequestParam(defaultValue = "0",required = false) int page,
                                                                 @RequestParam(defaultValue = "5",required = false) int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<Prescription> prescriptionPage = prescriptionService.findAllPrescription(pageable);
        if(prescriptionPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(prescriptionPage,HttpStatus.OK);
    }

    /**
     * Author: ThanhKN
     * Goal:create prescription
     * Return http status
     * Date:17/09/2023
     * @param prescription
     */
    @PostMapping("/prescription/create")
    public ResponseEntity<?> createPrescription(@RequestBody Prescription prescription){
        prescriptionService.createPrescription(prescription);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Author: ThanhKN
     * Goal:get prescription by id
     * Return prescription
     * Date:17/09/2023
     * @param id
     */
    @GetMapping("/prescription/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        Prescription prescription = prescriptionService.getPrescriptionById(id);
        return new ResponseEntity<>(prescription,HttpStatus.OK);
    }

    /**
     * Author: ThanhKN
     * Goal:remove prescription by id
     * Return http status
     * Date:17/09/2023
     * @param id
     */
    @DeleteMapping("/prescription/delete/{id}")
    public ResponseEntity<?> removePrescription(@PathVariable Long id){
        prescriptionService.removePrescription(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Author: ThanhKN
     * Goal:edit all prescription
     * Return void
     * Date:17/09/2023
     * @param prescription
     */
    @PutMapping("/prescription/edit/{id}")
    public ResponseEntity<?> editPrescription(@RequestBody Prescription prescription){
        prescriptionService.editPrescription(prescription);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
