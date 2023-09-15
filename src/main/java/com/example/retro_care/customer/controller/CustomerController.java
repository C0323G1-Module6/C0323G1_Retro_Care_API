package com.example.retro_care.customer.controller;

import com.example.retro_care.customer.model.Customer;
import com.example.retro_care.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    /**
     *
     * @param page
     * @param search
     * @param code
     * @param address
     * @param id
     * @param sortItem
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> getAllCustomers(@RequestParam(defaultValue = "0", required = false) Integer page,
                                             @RequestParam(defaultValue = "", required = false) String search,
                                             @RequestParam(defaultValue = "", required = false) String code,
                                             @RequestParam(defaultValue = "", required = false) String address,
                                             @RequestParam(defaultValue = "", required = false) Long id,
                                             @RequestParam(defaultValue = "code", required = false) String sortItem) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Customer> customers = customerService.findAllCustomer(pageable, "%" + search + "%", "%" + code + "%", "%" + address + "%", id, sortItem);
        if (!customers.isEmpty()) {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long id) {
        boolean check = customerService.deleteCustomerById(id);
        if (check) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
