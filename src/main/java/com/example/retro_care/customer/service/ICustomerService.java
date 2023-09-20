package com.example.retro_care.customer.service;

import com.example.retro_care.customer.dto.ICustomerDto;
import com.example.retro_care.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    /**
     * Author: TinDT
     * Goal: save customers
     */
    Customer saveCustomer(Customer customer);
    /**
     * Author: TinDT
     * Goal: update customers
     */
    void updateCustomer(Customer customer);
    /**
     * Author: TinDT
     * Goal: find customers by id
     * return customer
     */
    Customer findCustomerById(Long id);
    /**
     * Author: TinDT
     * Goal: find customers by code
     * return customer
     */
    Customer findCustomerByCode(String code);

    /**
     * Author: TinDT
     * Goal: find customers by email
     * return customer
     */
    Customer findCustomerByEmail(String email);
    /**
     * Author: TinDT
     * Goal: find customers by phone
     * return customer
     */
    Customer findCustomerByPhone(String phoneNumber);
    /**
     * Author: QuyenHT
     * Goal: find all customers
     * return customers
     */
    Page<ICustomerDto> findAllCustomer(String name, String code, String address, String phoneNumber, String groupValue, String sortItem, Pageable pageable);
     /**
     * Author: QuyenHT
     * Goal: delete customers
     * return res
     */
    boolean deleteCustomerById(Long id);
}
