package com.example.retro_care.prescription.controller;

import com.example.retro_care.indication.dto.IndicationDto;
import com.example.retro_care.indication.model.Indication;
import com.example.retro_care.indication.service.IIndicationService;
import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.medicine.service.IMedicineService;
import com.example.retro_care.patient.model.Patient;
import com.example.retro_care.patient.service.IPatientService;
import com.example.retro_care.prescription.dto.PrescriptionDto;
import com.example.retro_care.prescription.model.Prescription;
import com.example.retro_care.prescription.service.IPrescriptionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class PrescriptionController {
    @Autowired
    private IPrescriptionService prescriptionService;

    @Autowired
    private IPatientService patientService;

    @Autowired
    private IMedicineService medicineService;

    @Autowired
    private IIndicationService indicationService;

    /**
     * Author: ThanhKN
     * Goal:get all prescription
     * Return page prescription
     * Date:17/09/2023
     *
     * @param page, size
     */
    @GetMapping("/prescription")
    public ResponseEntity<Page<Prescription>> getAllPrescription(@RequestParam(defaultValue = "0", required = false) int page,
                                                                 @RequestParam(defaultValue = "5", required = false) int size,
                                                                 @RequestParam(defaultValue = "", required = false) String searchPrescription,
                                                                 @RequestParam(defaultValue = "",required = false) String search) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Prescription> prescriptionPage ;
        switch (searchPrescription){
            case "searchByName":
                prescriptionPage =prescriptionService.searchByNamePrescription(search,pageable);
                break;
            case "searchByCode":
                prescriptionPage = prescriptionService.searchByCodePrescription(search,pageable);
                break;
            case "searchBySymptoms":
                prescriptionPage = prescriptionService.searchBySymptomsPrescription(search,pageable);
                break;
            default:
                prescriptionPage = prescriptionService.findAllPrescription(pageable);
        }
        return new ResponseEntity<>(prescriptionPage, HttpStatus.OK);
    }

    /**
     * Author: ThanhKN
     * Goal:create prescription
     * Return http status
     * Date:17/09/2023
     *
     * @param prescriptionDto
     */
    @PostMapping("/prescription/create")
    public ResponseEntity<Object> createPrescription(@RequestBody PrescriptionDto prescriptionDto, BindingResult bindingResult) {
        Prescription prescription = new Prescription();

        Medicine medicine;
        new PrescriptionDto().validate(prescriptionDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        Patient patient = patientService.patientById(prescriptionDto.getPatient());
        BeanUtils.copyProperties(prescriptionDto, prescription);
        prescription.setPatient(patient);
        prescriptionService.createPrescription(prescription);
        List<IndicationDto> indicationDtoList = prescriptionDto.getIndicationDto();
        for (IndicationDto i : indicationDtoList) {
            if (i.getDosage() != null) {
                Indication indication = new Indication();
                medicine = medicineService.findMedicineById(i.getMedicine());
                BeanUtils.copyProperties(i, indication);
                indication.setMedicine(medicine);
                indication.setFlagDeleted(false);
                indicationService.createIndication(indication);
            }
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Author: ThanhKN
     * Goal:get prescription by id
     * Return prescription
     * Date:17/09/2023
     *
     * @param id
     */
    @GetMapping("/prescription/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        List<Prescription> prescriptionList = prescriptionService.getAll();
        for (Prescription p : prescriptionList) {
            if (p.getId().equals(id)) {
                Prescription prescription = prescriptionService.getPrescriptionById(id);
                return new ResponseEntity<>(prescription, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * Author: ThanhKN
     * Goal:remove prescription by id
     * Return http status
     * Date:17/09/2023
     *
     * @param id
     */
    @DeleteMapping("/prescription/delete/{id}")
    public ResponseEntity<Object> removePrescription(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Prescription> prescriptionList = prescriptionService.getAll();
        for (Prescription p : prescriptionList) {
            if (p.getId().equals(id)) {
                prescriptionService.removePrescription(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * Author: ThanhKN
     * Goal:edit all prescription
     * Return void
     * Date:17/09/2023
     *
     * @param prescriptionDto
     */
    @PatchMapping("/prescription/edit")
    public ResponseEntity<Object> editPrescription(@RequestBody PrescriptionDto prescriptionDto, BindingResult bindingResult) {
        Prescription prescription = new Prescription();
        Medicine medicine;
        new PrescriptionDto().validate(prescriptionDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        Patient patient = patientService.patientById(prescriptionDto.getPatient());
        BeanUtils.copyProperties(prescriptionDto, prescription);
        prescription.setPatient(patient);
        prescriptionService.editPrescription(prescription);
        List<IndicationDto> indicationDtoList = prescriptionDto.getIndicationDto();
        for (IndicationDto i : indicationDtoList) {
            if (i.getDosage() != null) {
                i.setFlagDeleted(true);
                Indication indication = new Indication();
                medicine = medicineService.findMedicineById(i.getMedicine());
                BeanUtils.copyProperties(i, indication);
                indication.setMedicine(medicine);
                indication.setFlagDeleted(false);
                indication.setPrescription(prescription);
                indicationService.editIndication(indication);
            }
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
