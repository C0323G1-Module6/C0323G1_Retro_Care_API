package com.example.retro_care.employee.repository;

import com.example.retro_care.employee.model.Employee;
import com.example.retro_care.user.model.AppRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

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
