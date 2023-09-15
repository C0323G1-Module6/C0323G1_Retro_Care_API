package com.example.retro_care.customer.service;

import com.example.retro_care.customer.model.Customer;

public interface ICustomerService {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer findCustomerById(Long id);
}
