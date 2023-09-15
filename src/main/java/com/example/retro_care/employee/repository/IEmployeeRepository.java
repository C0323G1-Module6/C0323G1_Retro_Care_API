package com.example.retro_care.employee.repository;

import com.example.retro_care.employee.model.Employee;
import com.example.retro_care.user.model.AppUser;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select code_employee from employee where id = (select max(id) from employee)",nativeQuery = true)
    String getLastCodeEmployee();
    @Modifying
    @Transactional
    @Query(value = "insert into employee(code_employee,name_employee,address,phone_number,start_day,birthday,id_card,image,note,flag_delete,app_user_id) " +
            "value (:code_employee,:name_employee,:address,:phone_number,:start_day,:birthday,:id_card,:image,:note,:flag_delete,:app_user_id)",nativeQuery = true)
    Employee addEmployee(@Param(value = "code_employee") String code,
                         @Param(value = "name_employee") String name,
                         @Param(value = "address") String address,
                         @Param(value = "phone_number") String phoneNumber,
                         @Param(value = "start_day") String startDay,
                         @Param(value = "birthday") String birthday,
                         @Param(value = "id_card") String idCard,
                         @Param(value = "image") String image,
                         @Param(value = "note") String note,
                         @Param(value = "flag_delete") Boolean flagDelete,
                         @Param(value = "app_user_id") Long appUserId
    );
}
