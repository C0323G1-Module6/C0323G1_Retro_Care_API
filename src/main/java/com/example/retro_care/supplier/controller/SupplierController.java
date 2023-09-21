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
import org.springframework.data.domain.PageRequest;
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
    public ResponseEntity<Page<ISupplierProjection>> getListSupplier(@PageableDefault(size = 5) Pageable pageable,@RequestParam("page")String page,
                                                                     @RequestParam("code")String code,@RequestParam("name")String name,
                                                                      @RequestParam("phoneNumber")String phoneNumber,@RequestParam("address")String address
                                                                    ,@RequestParam("sortBy")String sortBy) {
        int currentPage;
        currentPage = Integer.parseInt(page);
        if (currentPage < 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (iSupplierService.getListSupplier(pageable,code,name,phoneNumber,address,sortBy).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(iSupplierService.getListSupplier(pageable,code,name,phoneNumber,address,sortBy), HttpStatus.OK);
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

    @PatchMapping("/update-supplier/{id}")
    public ResponseEntity<?> updateSupplier(@PathVariable Long id, @Valid @RequestBody SupplierDto supplierDto, BindingResult bindingResult) {
        if (iSupplierService.getSupplierById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            if (!bindingResult.hasErrors()) {
                Supplier supplier = new Supplier();
                BeanUtils.copyProperties(supplierDto, supplier);
                supplier.setId(iSupplierService.getSupplierById(id).getId());
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
    public ResponseEntity<Page<IInvoiceProjection>> detailSupplier(@PathVariable("id") Long id,@PageableDefault(size = 5) Pageable pageable) {

        if (iSupplierService.getSupplierDetailById(id) == null) {
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
    @GetMapping("/get/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable("id")Long id) {
        Supplier supplier = iSupplierService.getSupplierById(id);
        if (supplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {

            return new ResponseEntity<>(supplier,HttpStatus.OK);
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
    public ResponseEntity<ISupplierProjection> getSupplierDetailById(@PathVariable("id")Long id) {
        ISupplierProjection iSupplierProjection = iSupplierService.getSupplierDetailById(id);
        if (iSupplierProjection == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {

            return new ResponseEntity<>(iSupplierProjection,HttpStatus.OK);
        }
    }


}
