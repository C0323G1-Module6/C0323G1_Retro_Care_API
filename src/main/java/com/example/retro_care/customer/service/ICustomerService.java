package com.example.retro_care.customer.service;

import com.example.retro_care.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer findCustomerById(Long id);

    Page<Customer> findAllCustomer(Pageable pageable, String searchInput, String code, String address, Long appUserId,String sortItem);
    boolean deleteCustomerById(Long id);
}
