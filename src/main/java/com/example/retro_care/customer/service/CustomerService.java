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
     * Author: HANHNLM
     * Goal: update customers online
     */
    @Override
    public int updateOnlineCustomer(Customer customer) {
        return customerRepository.updateOnlineCustomer(customer);
    }
    /**
     * Author: HANHNLM
     * Goal: exits email of customer
     */
    @Override
    public boolean existsByEmail(String email, Long id) {
        return customerRepository.existsByEmailAndIdNot(email,id);
    }
    /**
     * Author: HANHNLM
     * Goal: exits phone of customer
     */
    @Override
    public boolean existsByPhoneNumber(String phoneNumber, Long id) {
        return customerRepository.existsByPhoneNumberAndIdNot(phoneNumber,id);
    }

    /**
     * Author: TinDT
     * Goal: create customer
     * * return customer
     */
    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setFlagDeleted(true);
        customer.setPoint(0l);
        customerRepository.saveCustomer(customer.getCode(),customer.getName(),customer.getBirthday(),customer.getAddress(),customer.getPhoneNumber(),customer.getEmail(),customer.getPoint(),customer.getNote(),customer.getFlagDeleted());

        Customer checkingCustomer = customerRepository.findCustomerByPhoneNumber(customer.getPhoneNumber());
        return checkingCustomer;
    }

    /**
     * Author: TinDT
     * Goal: update for customer
     * * return
     */
    @Override
    public void updateCustomer(Customer customer) {
        System.out.println(customer);
        customerRepository.updateCustomer(customer.getName(),customer.getBirthday(),customer.getAddress(),customer.getPhoneNumber(),customer.getEmail(),customer.getNote(),customer.getId());

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
     * Author: TinDT
     * Goal: find customer by email
     * * return customer
     */
    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }
    /**
     * Author: TinDT
     * Goal: find customer by email
     * * return customer
     */
    @Override
    public Customer findCustomerByPhone(String phoneNumber) {
        return customerRepository.findCustomerByPhoneNumber(phoneNumber);
    }

    /**
     * Author: QuyenHT
     * Goal: get all customers
     * return list of customers
     */
    @Override
    public Page<ICustomerDto> findAllCustomer(String name, String code, String address, String phoneNumber, String groupValue, String sortItem, Pageable pageable) {
        return customerRepository.findAllCustomer(name, code, address, phoneNumber, groupValue, sortItem, pageable);

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
