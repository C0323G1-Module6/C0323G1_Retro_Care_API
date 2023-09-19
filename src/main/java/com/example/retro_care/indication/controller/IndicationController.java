package com.example.retro_care.indication.controller;

import com.example.retro_care.indication.dto.IndicationDto;
import com.example.retro_care.indication.model.Indication;
import com.example.retro_care.indication.service.IIndicationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<Indication> indications = indicationService.getAll();
        for (Indication i: indications) {
            if(i.getId() == id) {
                List<Indication> indicationList = indicationService.getAllIndication(id);
                return new ResponseEntity<>(indicationList, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

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
     * @param indicationDto
     */
    @PostMapping("/indication/create")
    public ResponseEntity<?> createIndication(@RequestBody IndicationDto indicationDto, BindingResult bindingResult) {
        Indication indication = new Indication();
        new IndicationDto().validate(indicationDto,bindingResult);
        if(bindingResult.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError e: bindingResult.getFieldErrors()) {
                errors.put(e.getField(),e.getDefaultMessage());
            }
            return new ResponseEntity<>(errors,HttpStatus.NOT_ACCEPTABLE);
        }
        BeanUtils.copyProperties(indicationDto,indication);
        indicationService.createIndication(indication);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Author: ThanhKN
     * Goal:get indication by id
     * Date:17/09/2023
     * return http status
     * @param indicationDto
     */
    @PatchMapping("/indication/edit")
    public ResponseEntity<?> editIndication(@RequestBody IndicationDto indicationDto,BindingResult bindingResult) {
        Indication indication = new Indication();
        new IndicationDto().validate(indicationDto,bindingResult);
        if(bindingResult.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError e: bindingResult.getFieldErrors()) {
                errors.put(e.getField(),e.getDefaultMessage());
            }
            return new ResponseEntity<>(errors,HttpStatus.NOT_ACCEPTABLE);
        }
        BeanUtils.copyProperties(indicationDto,indication);
        indicationService.editIndication(indication);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
