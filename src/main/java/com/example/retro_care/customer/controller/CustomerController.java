package com.example.retro_care.customer.controller;

import com.example.retro_care.customer.dto.CreatCode;
import com.example.retro_care.customer.dto.CustomerDto;
import com.example.retro_care.customer.dto.ICustomerDto;
import com.example.retro_care.customer.model.Customer;
import com.example.retro_care.customer.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin("*")
@RequestMapping("/customers/api")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    /**
     * Author: TinDT
     * Goal: get customer for page to create customer information
     * return creation page  of customers
     */
    @GetMapping("/dto/create")
    public ResponseEntity<CustomerDto> getCustomerForCreate() {
        CustomerDto customerDto = new CustomerDto();
        String customerCode = CreatCode.generateCustomerCode();
        while (true) {
            if (customerService.findCustomerByCode(customerCode) == null) {
                break;
            }
        }
        customerDto.setCode(customerCode);
        System.out.println(customerDto.getCode());
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    /**
     * Author: TinDT
     * Goal: create customer
     * * return HttpStatus
     */
    @PostMapping("/create")
    public ResponseEntity<?> saveCustomer(@Valid  @RequestBody CustomerDto customerDto, BindingResult bindingResult) {
        Customer customer = new Customer();
        Customer saveCustomer;
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String,String> errors = new HashMap<>();
            for (FieldError err: bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(errors,HttpStatus.NOT_ACCEPTABLE);
        }
        BeanUtils.copyProperties(customerDto, customer);
        saveCustomer = customerService.saveCustomer(customer);
            return new ResponseEntity<>(saveCustomer, HttpStatus.OK);

    }

    /**
     * Author: TinDT
     * Goal: update information of customer
     * * return HttpStatus
     */
    @PatchMapping("/update")
    public ResponseEntity<?> updateCustomer(@Valid @RequestBody CustomerDto customerDto,BindingResult bindingResult) {
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError err: bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    /**
//     * Author: TinDT
//     * Goal: Send customers needing updates to the customer updates page
//     * * return HttpStatus
//     */
//    @GetMapping("/dto/update/{id}")
//    public ResponseEntity<CustomerDto> getCustomerForUpdate(@PathVariable Long id) {
//        CustomerDto customerDto = new CustomerDto();
//        Customer customer = customerService.findCustomerById(id);
//        BeanUtils.copyProperties(customer,customerDto);
//        return new ResponseEntity<>(customerDto, HttpStatus.OK);
//    }

    /**
     * Author: TinDT
     * Goal: get information of customer by id
     * * return HttpStatus
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> detailCustomer(@PathVariable Long id) {
        Customer customer = customerService.findCustomerById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    /**
     * Author: QuyenHT
     * Goal: get all customers
     * return list of customers
     */
    @GetMapping("/list")
    public ResponseEntity<?> getAllCustomers(@RequestParam(defaultValue = "0", required = false) Integer page,
                                             @RequestParam(defaultValue = "", required = false) String search,
                                             @RequestParam(defaultValue = "", required = false) String code,
                                             @RequestParam(defaultValue = "", required = false) String address,
                                             @RequestParam(defaultValue = "" ) String groupValue,
                                             @RequestParam(defaultValue = "" ) String sortItem) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<ICustomerDto> customers = customerService.findAllCustomer("%" + search + "%", "%" + code + "%", "%" + address + "%", groupValue, sortItem, pageable);
        if (customers.getTotalElements()!=0) {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/list-customer")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0", required = false)int page,
                                    @RequestParam(defaultValue = "", required = false) String searchName) {
        Pageable pageable = PageRequest.of(page,5);
        Page<Customer> customers = customerService.findAllByName(pageable, searchName);
        System.out.println(customers.getContent());
        if (customers.getTotalElements()!=0) {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Author: QuyenHT
     * Goal: Delete customer by id
     * return HttpStatus
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long id) {
        Customer customer = customerService.findCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boolean check = customerService.deleteCustomerById(id);
        if (check) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
