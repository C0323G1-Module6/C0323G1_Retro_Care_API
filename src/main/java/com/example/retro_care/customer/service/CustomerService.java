package com.example.retro_care.customer.service;

import com.example.retro_care.customer.dto.ICustomerDto;
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

    /**
     * Author: TinDT
     * Goal: create customer
     * * return customer
     */
    @Override
    public Customer saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
        Customer checkingCustomer = customerRepository.findCustomerByPhoneNumber(customer.getPhoneNumber());
        return checkingCustomer;
    }

    @Override
    public Page<Customer> findAllByName(Pageable pageable, String searchName) {
        return customerRepository.findCustomerByNameContaining(pageable,searchName);
    }

    /**
     * Author: TinDT
     * Goal: update for customer
     * * return
     */
    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    /**
     * Author: TinDT
     * Goal: find customer by id
     * * return customer
     */
    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }
    /**
     * Author: TinDT
     * Goal: find customer by code
     * * return customer
     */

    @Override
    public Customer findCustomerByCode(String code) {
        return customerRepository.findCustomerByCode(code);
    }

    /**
     * Author: QuyenHT
     * Goal: get all customers
     * return list of customers
     */
    @Override
    public Page<ICustomerDto> findAllCustomer(String searchInput, String code, String address, String groupValue, String sortItem, Pageable pageable) {
        return customerRepository.findAllCustomer(searchInput, code, address, groupValue, sortItem, pageable);

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
