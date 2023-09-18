package com.example.retro_care.supplier.controller;


import com.example.retro_care.supplier.dto.SupplierDto;
import com.example.retro_care.supplier.model.IInvoiceProjection;
import com.example.retro_care.supplier.model.ISupplierProjection;
import com.example.retro_care.supplier.model.Supplier;
import com.example.retro_care.supplier.service.ISupplierService;
import org.hibernate.boot.jaxb.spi.Binding;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private ISupplierService iSupplierService;
    /**
     * method :getListSupplier()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Pageable pageable
     * return Page<ISupplierProjection>
     */

    @GetMapping("")
    public ResponseEntity<Page<ISupplierProjection>> getListSupplier(@PageableDefault(size = 5) Pageable pageable) {
        Page<ISupplierProjection> listSupplier = iSupplierService.getListSupplier(pageable);
        if (!listSupplier.isEmpty()) {
            return new ResponseEntity<>(listSupplier, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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

    @PutMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteSupplierById(@RequestParam("id") Long id) {
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
        if (!bindingResult.hasErrors()) {
            Supplier supplier = new Supplier();
            BeanUtils.copyProperties(supplierDto, supplier);
            iSupplierService.createSupplier(supplier);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
    }
    /**
     * method :updateSupplierById()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param:  Supplier supplier
     * return void
     */

    @PutMapping("/update-supplier/{id}")
    public ResponseEntity<?> updateSupplier(@RequestParam("id") Long id, @Valid @RequestBody SupplierDto supplierDto, BindingResult bindingResult) {
        if (iSupplierService.getSupplierById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            if (!bindingResult.hasErrors()) {
                Supplier supplier = new Supplier();
                BeanUtils.copyProperties(supplierDto, supplier);
                iSupplierService.updateSupplierById(supplier);
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
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
    public ResponseEntity<Page<IInvoiceProjection>> detailSupplier(@RequestParam("id") Long id, @PageableDefault(size = 5) Pageable pageable) {
        if (iSupplierService.getSupplierById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
           return new ResponseEntity<>(iSupplierService.findAllListInvoiceByIdSupplier(id,pageable),HttpStatus.OK);
        }
    }
    /**
     * method :getSupplierById()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Long id
     * return Supplier
     */
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable("id")Long id) {
        Supplier supplier = iSupplierService.getSupplierById(id);
        if (supplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {

            return new ResponseEntity<>(supplier,HttpStatus.OK);
        }
    }


}
