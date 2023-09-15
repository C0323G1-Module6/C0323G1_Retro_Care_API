package com.example.retro_care.kind_of_medicine.controller;

import com.example.retro_care.kind_of_medicine.dto.KindOfMedicineCreationDto;
import com.example.retro_care.kind_of_medicine.model.KindOfMedicine;
import com.example.retro_care.kind_of_medicine.service.IKindOfMedicineService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/kindOfMedicine")
@CrossOrigin(origins = "*")
public class KindOfMedicineController {
    @Autowired
    private IKindOfMedicineService kindOfMedicineService;

    //List
    @GetMapping("")
    public ResponseEntity<List<KindOfMedicine>> displayListKindOfMedicine() {
        return new ResponseEntity<>(kindOfMedicineService.getListKindOfMedicine(), HttpStatus.OK);
    }

    //    Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<List<KindOfMedicine>> deleteKindOfMedicine(@PathVariable("id") Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        kindOfMedicineService.deleteKindOfMedicineById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public String deleteKindOfMedicine(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (kindOfMedicineService.deleteKindOfMedicine(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete successfully");
        } else {
            redirectAttributes.addFlashAttribute("message", "id not found");
        }
        return "redirect: /kindOfMedicine";
    }

    //    Create
    @PostMapping("/create")
    public ResponseEntity<?> getCreationForm(@RequestBody KindOfMedicine kindOfMedicine) {

        try {
            kindOfMedicineService.addKindOfMedicine(kindOfMedicine);
            return ResponseEntity.status(HttpStatus.OK).body("add successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("add fail");
        }
    }

    //    Edit
    @GetMapping("/edit/{id}")
    public String getFormEdit(@PathVariable int id, RedirectAttributes redirectAttributes, Model model) {
        if (kindOfMedicineService.getKindOfMedicineById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "id not found");
            return "redirect: /kindOfMedicine";
        } else {
            KindOfMedicineCreationDto kindOfMedicineCreationDto = new KindOfMedicineCreationDto();
            BeanUtils.copyProperties(kindOfMedicineService.getKindOfMedicineById(id), kindOfMedicineCreationDto);
            model.addAttribute("kindOfMedicineCreationDto", kindOfMedicineCreationDto);
            return "edit";
        }
    }

    @PostMapping("/edit")
    public String editKindOfMedicine(@Valid @ModelAttribute KindOfMedicineCreationDto kindOfMedicineCreationDto,
                                     BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new KindOfMedicineCreationDto().validate(kindOfMedicineCreationDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        KindOfMedicine kindOfMedicine = new KindOfMedicine();
        BeanUtils.copyProperties(kindOfMedicineCreationDto, kindOfMedicine);
        kindOfMedicineService.editKindOfMedicine(kindOfMedicine);
        redirectAttributes.addFlashAttribute("message", "edit successfully");
        return "redirect:/kindOfMedicine";
    }

    // Pagination
    @Transactional
    @GetMapping("/get")
    public ResponseEntity<Page<KindOfMedicine>> getAllKindOfMedicine(@RequestParam(value = "page", defaultValue = "0")
                                                                             Integer page, String searchCode, String searchName) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by(Sort.Order.asc("id")));
        Page<KindOfMedicine> contractsPage = kindOfMedicineService.getPageKindOfMedicine(pageable, searchCode, searchName);
        if (contractsPage == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractsPage, HttpStatus.OK);

    }
}
