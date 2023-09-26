package com.example.retro_care.customer.controller;

import com.example.retro_care.customer.dto.FormatCustomer;
import com.example.retro_care.customer.dto.CustomerDto;
import com.example.retro_care.customer.dto.ICustomerDto;
import com.example.retro_care.customer.model.Customer;
import com.example.retro_care.customer.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    private static final String EMAIL = "email";
    /**
     * Author: HanhNLM
     * Goal: update online customer
     * return HttpStatus or error
     */
    @PatchMapping("/online-customer")
    public ResponseEntity<Map<String,String>> updateOnlineCustomer(@RequestBody CustomerDto customerDto,BindingResult bindingResult){
        Map<String, String> error = new HashMap<>();
        Customer customer = new Customer();
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                error.put(err.getField(), err.getDefaultMessage());
            }
        }

        if(customerService.existsByEmail(customerDto.getEmail(), customerDto.getId())){
            error.put(EMAIL, "Email đã tồn tại trong hệ thống!");
        }
        if(customerService.existsByPhoneNumber(customerDto.getPhoneNumber(), customerDto.getId())){
            error.put("numberPhone", "Số điện thoại đã tồn tại!");
        }
        if(error.size() > 0){
            return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
        }
        BeanUtils.copyProperties(customerDto,customer);
        customerService.updateOnlineCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);

    }

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
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }



    /**
     * Author: TinDT
     * Goal: create customer
     * * return HttpStatus
     */
    @PostMapping("/create")
    public ResponseEntity<Map<String,String>> saveCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult) {
        Customer customer = new Customer();
        Map<String, String> errors = new HashMap<>();
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }

        }
        Customer customerCheck = customerService.findCustomerByEmail(customerDto.getEmail());
        if (customerCheck != null){
            errors.put(EMAIL,"Email đã được đăng ký");
        }
        Customer  customerCheckPhone = customerService.findCustomerByPhone(customerDto.getPhoneNumber());
        if (customerCheckPhone != null) {
            errors.put("phoneNumber", "Số điện thoại đã được đăng ký");
        }
        if (errors.size() != 0){
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        BeanUtils.copyProperties(customerDto, customer);
        customerService.saveCustomer(customer);

        return new ResponseEntity<>( HttpStatus.OK);

    }

    /**
     * Author: TinDT
     * Goal: update information of customer
     * * return HttpStatus
     */
    @PatchMapping("/update/{id}")
    public ResponseEntity<Map<String,String>> updateCustomer(@Valid @RequestBody CustomerDto customerDto,@PathVariable Long id,BindingResult bindingResult) {
        Customer customer= customerService.findCustomerById(id);
        new CustomerDto().validate(customerDto,bindingResult);
        Map<String, String> errors = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
        }
        else if (!(customer.getEmail().equals(customerDto.getEmail()))){
            Customer customerCheckEmail = customerService.findCustomerByEmail(customerDto.getEmail());
            if (customerCheckEmail != null){
                errors.put(EMAIL,"Email đã tồn tại");
            }
        }
        if (!(customer.getPhoneNumber().equals(customerDto.getPhoneNumber()))){
            Customer customerCheckPhone = customerService.findCustomerByPhone(customerDto.getPhoneNumber());
            if (customerCheckPhone != null){
                errors.put("phoneNumber","Số điện thoại đã tồn tại");
            }
        }
        if (errors.size() != 0){
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            BeanUtils.copyProperties(customerDto,customer);
            customer.setId(id);
            customerService.updateCustomer(customer);}
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Author: TinDT
     * Goal: get information of customer by id
     * * return HttpStatus
     */
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> detailCustomer(@PathVariable Long id) {
        Customer customer = customerService.findCustomerById(id);
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }
    /**
     * Author: TinDT
     * Goal: get information of customer by app_user
     * * return HttpStatus
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<CustomerDto> detailCustomerByAppUser(@PathVariable Long id) {
        Customer customer = customerService.findCustomerByAppUser(id);
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
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
    public ResponseEntity<Page<ICustomerDto>> getAllCustomers(@RequestParam(defaultValue = "0", required = false) Integer page,
                                                              @RequestParam(defaultValue = "", required = false) String name,
                                                              @RequestParam(defaultValue = "", required = false) String code,
                                                              @RequestParam(defaultValue = "", required = false) String address,
                                                              @RequestParam(defaultValue = "", required = false) String phoneNumber,
                                                              @RequestParam(defaultValue = "") String groupValue,
                                                              @RequestParam(defaultValue = "id") String sortItem,
                                                              @RequestParam(defaultValue = "DESC") String sort) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(sortItem).ascending();
        } else if (sort.equals("DESC")) {
            sortable = Sort.by(sortItem).descending();
        }
        Pageable pageable = PageRequest.of(page, 5, sortable);
        Page<ICustomerDto> customers = customerService.findAllCustomer("%" + name + "%", "%" + code + "%", "%" + address + "%", "%" + phoneNumber + "%", groupValue, pageable);
        if (customers.getTotalElements() != 0) {
            return ResponseEntity.ok(customers);
        }
        return ResponseEntity.noContent().build();
    }



    /**
     * Author: QuyenHT
     * Goal: Delete customer by id
     * return HttpStatus
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Long id) {
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
    @PatchMapping("/update-new/{id}")
    public ResponseEntity<Map<String,String>> updateNewCustomer(@Valid @RequestBody CustomerDto customerDto,@PathVariable Long id,BindingResult bindingResult) {
        Customer customer= customerService.findCustomerById(id);
        new CustomerDto().validate(customerDto,bindingResult);
        Map<String, String> errors = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
        }

//            Customer customerCheckEmail = customerService.findCustomerByEmail(customerDto.getEmail());
            if (!(customer.getEmail().equals(customerDto.getEmail()))){
            Customer customerCheckEmail = customerService.findCustomerByEmail(customerDto.getEmail());
            if (customerCheckEmail != null){
                errors.put(EMAIL,"Email đã tồn tại");
            }
        }
        if (!(customer.getPhoneNumber().equals(customerDto.getPhoneNumber()))){
            Customer customerCheckPhone = customerService.findCustomerByPhone(customerDto.getPhoneNumber());
            if (customerCheckPhone != null){
                errors.put("phoneNumber","Số điện thoại đã tồn tại");
            }
        }

        if (errors.size() != 0){
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            BeanUtils.copyProperties(customerDto,customer);
            customer.setId(id);
            customerService.updateCustomer(customer);}
        return new ResponseEntity<>(HttpStatus.OK);
    }
}