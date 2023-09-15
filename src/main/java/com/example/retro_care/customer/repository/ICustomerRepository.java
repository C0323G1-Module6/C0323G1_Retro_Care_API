package com.example.retro_care.customer.repository;

import com.example.retro_care.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO retro_care.customer(name,birth_day,address,phone_number,email,point,note,flag_delete,app_user_id) VALUE(:name,:birth_day,:address,:phone_number,:email,0,:note,true,:app_user_id)", nativeQuery = true)
    void saveCustomer(@Param(value = "name") String name, @Param(value = "birth_day") String birthDay, @Param(value = "address") String address, @Param(value = "phone_number") String phoneNumber, @Param(value = "email") String email, @Param(value = "note") String note, @Param(value = "app_user_id") Long appUserId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE retro_care.customer set name =:name,birth_day=:birth_day,address=:address,phone_number=:phone_number,email=:email,note=:note,flag_delete = true WHERE id =:id", nativeQuery = true)
    void updateCustomer(@Param(value = "name") String name,@Param(value = "birth_day")String birthDay,@Param(value = "address")String address,@Param(value = "phone_number")String phoneNumber,@Param(value = "email")String email,@Param(value = "note")String note,@Param(value = "id")Long id);
}
