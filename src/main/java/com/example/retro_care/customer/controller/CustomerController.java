package com.example.retro_care.customer.controller;

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
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    /**
     * Author: TinDT
     * Goal: create customer
     * * return HttpStatus
     */
    @PostMapping("/create")
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDto customerDto, BindingResult bindingResult) {
        Customer customer = new Customer();
        Customer saveCustomer;
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        BeanUtils.copyProperties(customerDto, customer);
        saveCustomer = customerService.saveCustomer(customer);
        if (saveCustomer != null) {
            return new ResponseEntity<>(saveCustomer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    /**
     * Author: TinDT
     * Goal: update information of customer
     * * return HttpStatus
     */
    @PatchMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Author: TinDT
     * Goal: get information of customer by id
     * * return HttpStatus
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> detailCustomer(@PathVariable Long id) {
        Customer customer = customerService.findCustomerById(id);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
                                             @RequestParam(defaultValue = " is not null or app_user_id", required = false) String groupValue,
                                             @RequestParam(defaultValue = "code", required = false) String sortItem) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Customer> customers = customerService.findAllCustomer(pageable, "%" + search + "%", "%" + code + "%", "%" + address + "%", groupValue, sortItem);
        if (!customers.isEmpty()) {
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
        boolean check = customerService.deleteCustomerById(id);
        if (check) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
