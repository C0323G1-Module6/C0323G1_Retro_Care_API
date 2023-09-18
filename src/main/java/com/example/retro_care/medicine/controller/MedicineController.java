package com.example.retro_care.medicine.controller;

import com.example.retro_care.medicine.dto.MedicineDto;
import com.example.retro_care.medicine.model.ImageMedicine;
import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.medicine.model.UnitDetail;
import com.example.retro_care.medicine.service.IImageMedicineService;
import com.example.retro_care.medicine.service.IMedicineService;
import com.example.retro_care.medicine.service.IUnitDetailService;
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
@CrossOrigin("*")
@RequestMapping("/api/medicine")
public class MedicineController {
    @Autowired
    private IMedicineService iMedicineService;
    @Autowired
    private IImageMedicineService iImageMedicineService;
    @Autowired
    private IUnitDetailService iUnitDetailService;


    /**
     * Find a medicine by its ID-TinVV
     *
     * @param id The ID of the medicine to find.
     * @return ResponseEntity with the corresponding HTTP status code.
     * - HttpStatus.OK if the medicine is found.
     */
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity findMedicineById(@PathVariable("id") Long id) {
        iImageMedicineService.findImageMedicineByMedicineId(id);
        iUnitDetailService.findUnitDetailByMedicineId(id);
        iMedicineService.findMedicineById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Add a new medicine to the system-TinVV
     *
     * @param medicineDto   The DTO object containing information about the new medicine.
     * @param bindingResult The result of the data binding and validation process.
     * @return ResponseEntity with the corresponding HTTP status code.
     * - HttpStatus.OK if the medicine is successfully added.
     * - HttpStatus.BAD_REQUEST if there are errors in the data validation process.
     */
    @PostMapping("")
    @ResponseBody
    public ResponseEntity addMedicine(@Valid @RequestBody MedicineDto medicineDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // Create Medicine, UnitDetail, and ImageMedicine objects from medicineDto
        Medicine medicine = new Medicine();
        UnitDetail unitDetail = new UnitDetail();
        ImageMedicine imageMedicine = new ImageMedicine();
        BeanUtils.copyProperties(medicineDto, medicine);
        BeanUtils.copyProperties(medicineDto.getUnitDetailDto(), unitDetail);
        BeanUtils.copyProperties(medicineDto.getImageMedicine(), imageMedicine);
        // Call the services to add medicine, image, and unit detail information to the system
        iMedicineService.addMedicine(medicine);
        iImageMedicineService.addImageMedicine(imageMedicine);
        iUnitDetailService.addUnitDetail(unitDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Edit an existing medicine-TinVV
     *
     * @param medicineDto   The DTO object containing information about the edited medicine.
     * @param bindingResult The result of the data binding and validation process.
     * @return ResponseEntity with the corresponding HTTP status code.
     * - HttpStatus.OK if the medicine is successfully edited.
     * - HttpStatus.BAD_REQUEST if there are errors in the data validation process.
     */
    @PatchMapping("/{id}")
    @ResponseBody
    public ResponseEntity editMedicine(@Valid @RequestBody MedicineDto medicineDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Medicine medicine = new Medicine();
        UnitDetail unitDetail = new UnitDetail();
        ImageMedicine imageMedicine = new ImageMedicine();
        BeanUtils.copyProperties(medicineDto, medicine);
        BeanUtils.copyProperties(medicineDto.getUnitDetailDto(), unitDetail);
        BeanUtils.copyProperties(medicineDto.getImageMedicine(), imageMedicine);
        iMedicineService.editMedicine(medicine);
        iImageMedicineService.updateImageMedicine(imageMedicine);
        iUnitDetailService.updateUnitDetailByMedicineId(unitDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * author: DaoPTA
     * Medicine List
     *
     * @param page pagination of medication list
     * @param size Divide the number of records per page
     * @return ResponseEntity with the corresponding HTTP status code.
     * - HttpStatus.OK if the drug list has data.
     * - HttpStatus.NO_CONTENT if drug list has no data.
     */
    @GetMapping("/get-medicine")
    @ResponseBody
    public ResponseEntity<Page<Medicine>> medicineList(@RequestParam(defaultValue = "0", required = false) int page,
                                                       @RequestParam(defaultValue = "5", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Medicine> medicinePage = iMedicineService.findAll(pageable);
        if (medicinePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicinePage, HttpStatus.OK);
    }


    /**
     * author: DaoPTA
     * workday: 16/09/2023
     *
     * @param id Pass the id to get the object to delete
     * @return ResponseEntity with the corresponding HTTP status code.
     * - HttpStatus.OK If I get the id and delete it
     * - HttpStatus.NO_CONTENT If I don't get the id or status of medicine is true
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedicine(@PathVariable("id") Long id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Medicine> medicinePage = iMedicineService.getAll();
        for (Medicine m : medicinePage) {
            if (m.getId() == id) {
                iMedicineService.removeMedicine(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * author: DaoPTA
     * workday: 18/09/2023
     * Search by name Medicine
     *
     * @param page         Pagination after search
     * @param limit        Limit the number per page
     * @param sort         Arrange records in each page
     * @param searchByName value when filtering
     * @return ResponseEntity<?>
     */
    @GetMapping("/search")
    public ResponseEntity<Page<Medicine>> searchMedicine(@RequestParam(defaultValue = "0", required = false) Integer page,
                                                         @RequestParam(defaultValue = "5", required = false) Integer limit,
                                                         @RequestParam(defaultValue = "code", required = false) String sort,
                                                         @RequestParam(defaultValue = "",name = "searchByName", required = false) String searchByName,
                                                         @RequestParam(defaultValue = "",name = "searchByCode", required = false) String searchByCode,
                                                         @RequestParam(defaultValue = "",name = "searchByActiveElement", required = false) String searchByActiveElement,
                                                         @RequestParam(defaultValue = "",name = "searchByNameKindOf", required = false) String searchByNameKindOf) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by(sort));
        Page<Medicine> medicines = iMedicineService.searchByMedicine(pageable, searchByName, searchByCode, searchByActiveElement,searchByNameKindOf);
        if (medicines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        System.out.println(medicines);
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }
}
