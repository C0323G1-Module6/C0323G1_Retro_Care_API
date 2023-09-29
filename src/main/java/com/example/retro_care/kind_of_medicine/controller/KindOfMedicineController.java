package com.example.retro_care.kind_of_medicine.controller;

import com.example.retro_care.kind_of_medicine.dto.IKindOfMedicineDto;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/kindOfMedicines")
@CrossOrigin(origins = "*")
public class KindOfMedicineController {
    @Autowired
    private IKindOfMedicineService kindOfMedicineService;
    /**
     * method :displayListKindOfMedicine()
     * created by :CaoNv
     * date create: 14/09/2023
     *
     * @param: List<KindOfMedicine>
     * return List<KindOfMedicine>
     */
    //List
    @GetMapping("")
    public ResponseEntity<List<KindOfMedicine>> displayListKindOfMedicine() {
        return new ResponseEntity<>(kindOfMedicineService.getListKindOfMedicine(), HttpStatus.OK);
    }

    // Get by id
    /**
     * method :getKindOfMedicineById()
     * created by :CaoNv
     * date create: 14/09/2023
     *
     * @param: KindOfMedicine
     * return KindOfMedicine
     */
    @GetMapping("/kindOfMedicine/{id}")
    public ResponseEntity<KindOfMedicine> getKindOfMedicineById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(kindOfMedicineService.getKindOfMedicineById(id), HttpStatus.OK);
    }

    //    Delete
    /**
     * method :deleteKindOfMedicine()
     * created by :CaoNv
     * date create: 14/09/2023
     *
     * @param: Long id
     *  void
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<KindOfMedicine>> deleteKindOfMedicine(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<KindOfMedicine> kindOfMedicineList = kindOfMedicineService.getListKindOfMedicine();
        for (KindOfMedicine k : kindOfMedicineList) {
            if (k.getId().equals(id)) {
                kindOfMedicineService.deleteKindOfMedicineById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // Deletes
    /**
     * method :deleteItems()
     * created by :CaoNv
     * date create: 14/09/2023
     *
     * @param: List<Long> ids
     * void
     */
    @PostMapping("/delete-items")
    public ResponseEntity<KindOfMedicine> deleteItems(@RequestBody List<Long> ids) {
        if (ids == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //    Create
    /**
     * method :getCreationForm()
     * created by :CaoNv
     * date create: 14/09/2023
     *
     * @param: Object
     * void
     */
    @PostMapping("/create")
    public ResponseEntity<Object> getCreationForm(@Valid @RequestBody KindOfMedicineCreationDto kindOfMedicineCreationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        kindOfMedicineCreationDto.setFlagDeleted(false);
        KindOfMedicine kindOfMedicine = new KindOfMedicine();
        BeanUtils.copyProperties(kindOfMedicineCreationDto,kindOfMedicine);
        kindOfMedicineService.addKindOfMedicine(kindOfMedicine);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Edit
    /**
     * method :editKindOfMedicine()
     * created by :CaoNv
     * date create: 14/09/2023
     *
     * @param: editKindOfMedicine
     * void
     */
    @PutMapping("/edit")
    public ResponseEntity<Object> editKindOfMedicine(@RequestBody KindOfMedicine kindOfMedicine) {
        kindOfMedicine.setFlagDeleted(false);
        if (kindOfMedicineService.getKindOfMedicineById(kindOfMedicine.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            kindOfMedicineService.editKindOfMedicine(kindOfMedicine);
            return ResponseEntity.status(HttpStatus.OK).body("Update successfully");
        }
    }


    // Pagination
    /**
     * method :getAllKindOfMedicine()
     * created by :CaoNv
     * date create: 14/09/2023
     *
     * @param: Long id
     * return List<KindOfMedicine>
     */
    @GetMapping("/get")
    public ResponseEntity<Page<?>> getAllKindOfMedicine(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                                                        @RequestParam(value = "searchCode", defaultValue = "", required = false) String searchCode,
                                                        @RequestParam(value = "searchName", defaultValue = "", required = false) String searchName) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Order.desc("id")));
        Page<IKindOfMedicineDto> contractsPage = kindOfMedicineService.getPageKindOfMedicine(pageable, "%" + searchCode + "%", "%" + searchName + "%");
        if (contractsPage.getTotalElements() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (page > contractsPage.getTotalPages() - 1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(contractsPage, HttpStatus.OK);

    }
}
