package com.example.retro_care.customer.controller;

import com.example.retro_care.customer.model.Customer;
import com.example.retro_care.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/customers/api")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/update")
    public ResponseEntity<Customer> editProduct(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> detailProduct(@PathVariable Long id) {
        Customer customer = customerService.findCustomerById(id);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
