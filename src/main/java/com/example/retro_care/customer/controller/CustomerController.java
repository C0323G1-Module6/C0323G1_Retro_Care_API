package com.example.retro_care.customer.controller;

import com.example.retro_care.customer.dto.FormatCustomer;
import com.example.retro_care.customer.dto.CustomerDto;
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
     * return HttpStatus
     */
    @GetMapping("/dto/create")
    public ResponseEntity<CustomerDto> getCustomerForCreate() {
        CustomerDto customerDto = new CustomerDto();
        String customerCode = FormatCustomer.generateCustomerCode();
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
            return new ResponseEntity<>("Thêm mới khách hàng thành công", HttpStatus.OK);

    }

    /**
     * Author: TinDT
     * Goal: update information of customer
     * * return HttpStatus
     */
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@Valid @RequestBody CustomerDto customerDto,@PathVariable Long id,BindingResult bindingResult) {
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError err: bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        Customer customer= customerService.findCustomerById(id);
        System.out.println(customer);
        if (customer==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(customerDto,customer);
        customer.setId(id);
        customerService.updateCustomer(customer);
        return new ResponseEntity<>("Cập nhật thông tin khách hành thành công",HttpStatus.OK);
    }


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
                                             @RequestParam(defaultValue = " app_user_id is null or app_user_id is not null ", required = false) String groupValue,
                                             @RequestParam(defaultValue = "code") String sortItem) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Customer> customers = customerService.findAllCustomer(pageable, "%" + search + "%", "%" + code + "%", "%" + address + "%", groupValue, sortItem);
        System.out.println(customers.getContent());
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
