package com.example.retro_care.customer.repository;

import com.example.retro_care.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO retro_care.customer(code,name,birth_day,address,phone_number,email,point,note,flag_deleted,app_user_id) VALUES(:#{#customer.code},:#{#customer.name},:#{#customer.birthDay},:#{#customer.address},:#{#customer.phoneNumber},:#{#customer.email},0,:#{#customer.note},true,:#{#customer.appUser.id})", nativeQuery = true)
    void saveCustomer(@Param(value = "customer") Customer customer);

    @Modifying
    @Transactional
    @Query(value = "UPDATE retro_care.customer set name= :#{#customer.name},birth_day = :#{#customer.birthDay},address = :#{#customer.address},phone_number = :#{#customer.phoneNumber},email = :#{#customer.email},flag_deleted = true WHERE id =:#{#customer.id}", nativeQuery = true)
    void updateCustomer(@Param(value = "customer") Customer customer);

    @Query(value = "SELECT id,code,name,birth_day,address,phone_number,email,point,note,flag_deleted,app_user_id from retro_care.customer where id =:id", nativeQuery = true)
    Customer findCustomerById(@Param(value = "id") Long id);

    @Query(value = "SELECT id,code,name,birth_day,address,phone_number,email,point,note,flag_deleted,app_user_id from retro_care.customer where phone_number =:phone_number", nativeQuery = true)
    Customer findCustomerByPhoneNumber(@Param(value = "phone_number") String phoneNumber);

    @Query(value = "SELECT id,code,name,birth_day,address,phone_number,email,point,note,flag_deleted,app_user_id from retro_care.customer where code =:code", nativeQuery = true)
    Customer findCustomerByCode(@Param(value = "code") String code);

    /**
     * Author: QuyenHT
     * Goal: get all customers
     * return list of customers
     */
    @Query(value = " SELECT c.code, c.name, c.birth_day, c.address, c.phone_number, c.note, " +
            "CASE WHEN c.app_user_id is null then 'Khách offline' ELSE 'Khách online' END AS customer_type " +
            "FROM retro_care.customer c " +
            "WHERE c.name LIKE :searchInput AND c.code LIKE :code AND c.address like :address AND (c.app_user_id = :groupValue) " +
            "ORDER BY " +
            "CASE :sortItem WHEN 'code' THEN c.code " +
            "               WHEN 'name' THEN c.name " +
            "               ELSE c.code " +
            "END",
            countQuery = " SELECT COUNT(c.id) from retro_care.customer c WHERE c.name LIKE :searchInput AND c.code LIKE :code AND c.address like :address AND (c.app_user_id = :groupValue)", nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable, @Param(value = "searchInput") String searchInput, @Param(value = "code") String code, @Param(value = "address") String address, @Param(value = "groupValue") String groupValue, @Param(value = "sortItem") String sortItem);


    Page<Customer> findCustomerByNameContaining(Pageable pageable, String searchName);
    /**
     * Author: QuyenHT
     * Goal: Delete customer by id
     * return boolean
     */
    @Modifying
    @Transactional
    @Query(value = " UPDATE retro_care.customer set flag_deleted = false WHERE id = :id ", nativeQuery = true)
    void removeCustomer(@Param(value = "id") Long id);
}
