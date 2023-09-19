package com.example.retro_care.customer.service;

import com.example.retro_care.customer.dto.ICustomerDto;
import com.example.retro_care.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Customer saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer findCustomerById(Long id);
    Customer findCustomerByCode(String code);
    Page<ICustomerDto> findAllCustomer(String searchInput, String code, String address, String phoneNumber, String groupValue, String sortItem, Pageable pageable);
    boolean deleteCustomerById(Long id);

    Page<Customer> findAllByName(Pageable pageable, String searchName);
}
