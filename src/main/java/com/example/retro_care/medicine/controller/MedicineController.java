package com.example.retro_care.medicine.controller;

import com.example.retro_care.medicine.dto.IMedicineListDto;
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
import org.springframework.data.repository.query.Param;
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
    public ResponseEntity<Page<IMedicineListDto>> medicineList(@RequestParam(defaultValue = "0", required = false) int page,
                                                       @RequestParam(defaultValue = "5", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<IMedicineListDto> medicinePage = iMedicineService.findAll(pageable, "");
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
     * Multi-field search method for medicine
     * workday: 19/09/2023
     * author: DaoPTA
     *
     * @param page parameters for paging
     * @param limit Limit the number of records in the page
     * @param sort Sorted by medicine code
     * @param searchInMedicine parameters contain different search methods
     * @param search Search by input box
     * @return - If empty, list medicine will be returned
     *         - If there is data, the list to search will be returned
     */
    @GetMapping("/search")
    public ResponseEntity<Page<IMedicineListDto>> searchByMedicine(@RequestParam(defaultValue = "0", required = false) Integer page,
                                                                   @RequestParam(defaultValue = "5", required = false) Integer limit,
                                                                   @RequestParam(defaultValue = "code", required = false) String sort,
                                                                   @RequestParam(defaultValue = "",required = false) String searchInMedicine,
                                                                   @RequestParam(defaultValue = "", required = false) String search){
        Pageable pageable = PageRequest.of(page, limit, Sort.by(sort));
        Page<IMedicineListDto> medicines;
        switch (searchInMedicine){
            case "searchByName":
                medicines = iMedicineService.searchByNameMedicine(pageable,search);
                break;
            case "searchByCode":
               medicines = iMedicineService.searchByCodeMedicine(pageable,search);
                break;
            case "searchByActiveElement":
               medicines = iMedicineService.searchActiveElement(pageable,search);
                break;
            case "searchByNameKindOfMedicine":
               medicines = iMedicineService.searchByNameKindOfMedicine(pageable,search);
                break;
            default:
                medicines = iMedicineService.findAll(pageable,search);
        }
        if (medicines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new  ResponseEntity<>(medicines, HttpStatus.OK);
    }
}
