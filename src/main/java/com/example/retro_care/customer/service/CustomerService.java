package com.example.retro_care.customer.service;

import com.example.retro_care.customer.model.Customer;
import com.example.retro_care.customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer.getName(), customer.getBirthday(), customer.getAddress(), customer.getPhoneNumber(), customer.getEmail(), customer.getNote(), customer.getAppUser().getId());
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer.getName(), customer.getBirthday(), customer.getAddress(), customer.getPhoneNumber(), customer.getEmail(), customer.getNote(), customer.getId());
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

    /**
     * Author: QuyenHT
     * Goal: get all customers
     * return list of customers
     */
    @Override
    public Page<Customer> findAllCustomer(Pageable pageable, String searchInput, String code, String address, Long appUserId, String sortItem) {
        return customerRepository.findAllCustomer(pageable, searchInput, code, address, appUserId, sortItem);
    }

    /**
     * Author: QuyenHT
     * Goal: Delete customer by id
     * return boolean
     */
    @Override
    public boolean deleteCustomerById(Long id) {
        try {
            customerRepository.removeCustomer(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
