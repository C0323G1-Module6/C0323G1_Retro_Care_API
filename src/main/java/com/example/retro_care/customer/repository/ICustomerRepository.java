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
    /**
     * Author: TinDT
     * Goal: save customers
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO retro_care.customer(code,name,birth_day,address,phone_number,email,point,note,flag_deleted) VALUES(:code,:name,:birth_day,:address,:phone_number,:email,:point,:note,:flag_deleted)", nativeQuery = true)
    void saveCustomer(@Param(value = "code") String code,@Param(value = "name") String name,@Param(value = "birth_day") String birthDay,@Param(value = "address")String address,@Param(value = "phone_number") String phoneNumber,@Param(value = "email") String email,@Param(value = "point")Long point,@Param(value = "note")String note,@Param(value = "flag_deleted")Boolean flagDeleted);
    /**
     * Author: TinDT
     * Goal: update customers
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE retro_care.customer set name = :name,birth_day = :birth_day ,address = :address ,phone_number = :phone_number,email = :email,note= :note  WHERE id =:id", nativeQuery = true)
    void updateCustomer(@Param(value = "name") String name,@Param(value = "birth_day") String birthDay,@Param(value = "address")String address,@Param(value = "phone_number") String phoneNumber,@Param(value = "email") String email,@Param(value = "note")String note,@Param(value = "id")Long id);
    /**
     * Author: TinDT
     * Goal: find customers by id
     * return customer
     */
    @Query(value = "SELECT id,code,name,birth_day,address,phone_number,email,point,note,flag_deleted,app_user_id from retro_care.customer where id =:id", nativeQuery = true)
    Customer findCustomerById(@Param(value = "id") Long id);
    /**
     * Author: TinDT
     * Goal: find customers by phone number
     * return customer
     */
    @Query(value = "SELECT id,code,name,birth_day,address,phone_number,email,point,note,flag_deleted,app_user_id from retro_care.customer where phone_number =:phone_number", nativeQuery = true)
    Customer findCustomerByPhoneNumber(@Param(value = "phone_number") String phoneNumber);
    /**
     * Author: TinDT
     * Goal: find customers by email
     * return customer
     */
    @Query(value = "SELECT id,code,name,birth_day,address,phone_number,email,point,note,flag_deleted,app_user_id from retro_care.customer where email =:email", nativeQuery = true)
    Customer findCustomerByEmail(@Param(value = "email") String email);
    /**
     * Author: TinDT
     * Goal: find customers by code
     * return customer
     */
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
