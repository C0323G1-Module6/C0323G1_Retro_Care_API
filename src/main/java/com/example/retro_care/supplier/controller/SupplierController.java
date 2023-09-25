package com.example.retro_care.supplier.controller;


import com.example.retro_care.supplier.dto.SupplierDto;
import com.example.retro_care.supplier.model.IInvoiceProjection;
import com.example.retro_care.supplier.model.ISupplierProjection;
import com.example.retro_care.supplier.model.Supplier;
import com.example.retro_care.supplier.service.ISupplierService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private ISupplierService iSupplierService;

    /**
     * method :getListSupplier()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param :Pageable pageable
     * return Page<ISupplierProjection>
     */

    @GetMapping("")
    public ResponseEntity<Page<ISupplierProjection>> getListSupplier(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                                     @RequestParam(value = "code", defaultValue = "") String code,
                                                                     @RequestParam(value = "name", defaultValue = "") String name,
                                                                     @RequestParam(value = "phoneNumber", defaultValue = "") String phoneNumber,
                                                                     @RequestParam(value = "address", defaultValue = "") String address,
                                                                     @RequestParam("sortBy") String sortBy) {

        Sort sort = checkOrderBy(sortBy);
        Pageable pageable = PageRequest.of(page, 5, sort);

        int currentPage = page;
        if (currentPage < 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (iSupplierService.getListSupplier(pageable, code, name, phoneNumber, address).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(iSupplierService.getListSupplier(pageable, code, name, phoneNumber, address), HttpStatus.OK);
        }
    }

    /**
     * method :deleteSupplierById()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Long id
     * return void
     */

    @PatchMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteSupplierById(@PathVariable("id") Long id) {
        if (iSupplierService.getSupplierById(id) != null) {
            iSupplierService.deleteSupplierById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * method :createSupplier()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Supplier supplier
     * return void
     */

    @PostMapping("/create-supplier")
    public ResponseEntity<?> createSupplier(@Valid @RequestBody SupplierDto supplierDto, BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
        }
        Supplier checkCode = iSupplierService.getSupplierByCode(supplierDto.getCode());
        Supplier checkName = iSupplierService.getSupplierByName(supplierDto.getName());
        Supplier checkEmail = iSupplierService.getSupplierByEmail(supplierDto.getEmail());
        Supplier checkPhoneNumber = iSupplierService.getSupplierByPhoneNumber(supplierDto.getPhoneNumber());

        if (checkEmail != null && checkEmail.getEmail().equals(supplierDto.getEmail())) {
            errors.put("email", "Email đã tồn tại.");
        }
        if (checkCode != null && checkCode.getCode().equals(supplierDto.getCode())) {
            errors.put("code", "Mã nhà cung cấp đã tồn tại.");
        }
        if (checkName != null && checkName.getName().equals(supplierDto.getName())) {
            errors.put("name", "Tên nhà cung cấp đã tồn tại.");
        }
        if (checkPhoneNumber != null && checkPhoneNumber.getPhoneNumber().equals(supplierDto.getPhoneNumber())) {
            errors.put("phoneNumber", "Số điện thoại đã tồn tại.");
        }
        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(supplierDto, supplier);
        iSupplierService.createSupplier(supplier);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * method :updateSupplierById()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Supplier supplier
     * return void
     */

    @PatchMapping("/update-supplier/{id}")
    public ResponseEntity<Map<String, String>> updateSupplier(@PathVariable Long id, @Valid @RequestBody SupplierDto supplierDto, BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        Supplier supplier = iSupplierService.getSupplierById(id);
        if (supplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
        }
        if (!supplier.getEmail().equals(supplierDto.getEmail())) {
            Supplier checkEmail = iSupplierService.getSupplierByEmail(supplierDto.getEmail());
            if (checkEmail != null) {
                errors.put("email", "Email đã tồn tại");
            }
        }
        if (!supplier.getName().equals(supplierDto.getName())) {
            Supplier checkName = iSupplierService.getSupplierByName(supplierDto.getName());
            if (checkName != null) {
                errors.put("name", "Tên nhà cung cấp đã tồn tại");
            }
        }
        if (!supplier.getPhoneNumber().equals(supplierDto.getPhoneNumber())) {
            Supplier checkPhoneNumber = iSupplierService.getSupplierByPhoneNumber(supplierDto.getPhoneNumber());
            if (checkPhoneNumber != null) {
                errors.put("phoneNumber", "Số điện thoại đã tồn tại");
            }
        }
        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        Supplier newSupplier = new Supplier();
        BeanUtils.copyProperties(supplierDto, newSupplier);
        newSupplier.setId(supplier.getId());
        iSupplierService.updateSupplierById(newSupplier);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * method :findAllListInvoiceByIdSupplier()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Long id, Pageable pageable
     * return Page<IInvoiceProjection>
     */
    @GetMapping("/detail-supplier/{id}")
    public ResponseEntity<Page<IInvoiceProjection>> detailSupplier(@PathVariable("id") Long id, @PageableDefault(size = 5) Pageable pageable,
                                                                   @RequestParam("page") String page, @RequestParam(value = "startDate", required = false) String startDate,
                                                                   @RequestParam(value = "endDate", required = false) String endDate) {
        int currentPage;
        currentPage = Integer.parseInt(page);
        if (startDate == null || startDate.isEmpty()) {
            startDate = null;
        }
        if (endDate == null || endDate.isEmpty()) {
            endDate = null;
        }
        if (currentPage < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (iSupplierService.getSupplierDetailById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (iSupplierService.findAllListInvoiceByIdSupplier(id, pageable, startDate, endDate).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(iSupplierService.findAllListInvoiceByIdSupplier(id, pageable, startDate, endDate), HttpStatus.OK);
        }
    }

    public Sort         checkOrderBy(String orderBy) {
        Sort sort;
        switch (orderBy) {
            case "code":
                sort = Sort.by("code").descending();
                break;
            case "name":
                sort = Sort.by("name").ascending();
                break;
            case "phone_number":
                sort = Sort.by("phone_number").ascending();
                break;
            case "address":
                sort = Sort.by("address").descending();
                break;
            default:
                sort = Sort.by("id").descending();
                break;
        }
        return sort;
    }

    /**
     * method :getSupplierById()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Long id
     * return Supplier
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable("id") Long id) {
        Supplier supplier = iSupplierService.getSupplierById(id);
        if (supplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(supplier, HttpStatus.OK);
        }
    }

    /**
     * method :getSupplierDetailById()
     * created by :ThanhVH
     * date create: 19/09/2023
     *
     * @param: Long id
     * return ISupplierProjection
     */
    @GetMapping("/get-detail/{id}")
    public ResponseEntity<ISupplierProjection> getSupplierDetailById(@PathVariable("id") Long id) {
        ISupplierProjection iSupplierProjection = iSupplierService.getSupplierDetailById(id);
        if (iSupplierProjection == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(iSupplierProjection, HttpStatus.OK);
        }
    }

    /**
     * method :getListSupplier()
     * created by :ThanhVH
     * date create: 21/09/2023
     *
     * @param: return List<Supplier>
     */
    @GetMapping("/list")
    public ResponseEntity<List<Supplier>> getListSupplier() {
        List<Supplier> list = iSupplierService.getListSupplier();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }


}
