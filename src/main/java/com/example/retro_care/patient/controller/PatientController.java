package com.example.retro_care.patient.controller;

import com.example.retro_care.patient.model.Patient;
import com.example.retro_care.patient.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PatientController {
    @Autowired
    private IPatientService patientService;

    /**
     * Author: ThanhKN
     * Goal:get all prescription
     * Return list patient
     * Date:17/09/2023
     */
    @GetMapping("/patient")
    public ResponseEntity<List<Patient>> getAllPatient(){
        List<Patient> patientList = patientService.getAllPatient();
        if(patientList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }
}
