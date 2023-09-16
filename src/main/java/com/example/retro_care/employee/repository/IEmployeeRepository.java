package com.example.retro_care.employee.repository;

import com.example.retro_care.employee.model.Employee;
import com.example.retro_care.user.model.AppRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
  import org.springframework.transaction.annotation.Transactional;
  import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
   /**
    * Author: TanNV
    * Date: 15/09/2023
    * Get code of employee latest
    * @return  code of employee latest
    */
    @Query(value = "select code_employee from employee where id = (select max(id) from employee)",nativeQuery = true)
    String getLastCodeEmployee();

   /**
    * Author: TanNV
    * Date: 15/09/2023
    * Use to save employee
    * @param code
    * @param name
    * @param address
    * @param phoneNumber
    * @param startDay
    * @param birthday
    * @param idCard
    * @param image
    * @param note
    * @param flagDelete
    * @param appUserId
    * @return void
    */
    @Modifying
    @Transactional
    @Query(value = "insert into employee(code_employee,name_employee,address,phone_number,start_day,birthday,id_card,image,note,flag_delete,app_user_id) " +
            "value (:code_employee,:name_employee,:address,:phone_number,:start_day,:birthday,:id_card,:image,:note,:flag_delete,:app_user_id)",nativeQuery = true)
    void addEmployee(@Param(value = "code_employee") String code,
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
   /**
    * Author: TanNV
    * Date: 16/09/2023
    * Use to update employee
    * @param name
    * @param address
    * @param phoneNumber
    * @param startDay
    * @param birthday
    * @param idCard
    * @param image
    * @param note
    * @return void
    */
   @Modifying
   @Transactional
   @Query(value = "UPDATE `retro_care`.`employee` SET `address` = :address, `birthday` = :birthday, `id_card` = :id_card, `image` = :image, `name_employee` = :name_employee, `note` = :note, `phone_number` = :phone_number, `start_day` = :start_day WHERE (`id` = '2')",nativeQuery = true)
   void updateEmployee(@Param(value = "name_employee") String name,
                        @Param(value = "address") String address,
                        @Param(value = "phone_number") String phoneNumber,
                        @Param(value = "start_day") String startDay,
                        @Param(value = "birthday") String birthday,
                        @Param(value = "id_card") String idCard,
                        @Param(value = "image") String image,
                        @Param(value = "note") String note
   );


    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: Get data from database with condition flag_delete = true
     * @param pageable
     * @return Page with data Employee
     */
    @Query(value = "SELECT * FROM employee JOIN app_user on app_user.id = employee.app_user_id JOIN user_role on user_role.app_user_id = app_user.id JOIN app_role on app_role.id = user_role.app_role_id WHERE employee.flag_delete = true", nativeQuery = true)
    Page<Employee> getListEmployee(Pageable pageable);

    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: Retrieve data from the database as long as it has not been deleted and request the employee name or employee position
     * @param pageable
     * @param id
     * @param name
     * @return Page with data Employee
     */
    @Query(value = "SELECT employee.*,app_role.name FROM employee" +
            " JOIN app_user on app_user.id = employee.app_user_id" +
            " JOIN user_role on user_role.app_user_id = app_user.id" +
            " JOIN app_role on app_role.id = user_role.app_role_id" +
            " WHERE employee.flag_delete = true AND" +
            " employee.name_employee LIKE concat('%',:name_employee,'%') OR app_role = :id_position", nativeQuery = true)
    Page<Employee> searchEmployeeByNameAndRole(Pageable pageable, @Param("id_position") Long id, @Param("name_employee") String name);

    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: Get data AppRole from database
     * @return List with data AppRole
     */
    @Query(value = "select * from app_role where flag_delete = true ", nativeQuery = true)
    List<AppRole> getRole();

    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: Find employee not been deleted and is id
     * @param id
     * @return Object Employee
     */
    @Query(value = "SELECT * from employee where employee.id = :id and employee.flag_delete = true", nativeQuery = true)
    Employee findEmployeeById(@Param("id") Long id);

    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: delete employee with id
     * @param id
     */
    @Query(value = "update employee set flag_delete = false where employee.id = :id",nativeQuery = true)
    void deleteEmployeeById(@Param("id") Long id);
}
