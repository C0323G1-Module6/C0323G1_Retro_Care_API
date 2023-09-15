package com.example.retro_care.customer.service;

import com.example.retro_care.customer.model.Customer;
import com.example.retro_care.customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public void saveCustomer(Customer customer) {
         customerRepository.saveCustomer(customer.getName(),customer.getBirthday(),customer.getAddress(),customer.getPhoneNumber(),customer.getEmail(),customer.getNote(),customer.getAppUser().getId());
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer.getName(),customer.getBirthday(),customer.getAddress(), customer.getPhoneNumber(), customer.getEmail(), customer.getNote(), customer.getId());
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }
}
