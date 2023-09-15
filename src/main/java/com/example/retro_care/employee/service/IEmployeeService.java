package com.example.retro_care.employee.service;

import com.example.retro_care.employee.model.Employee;
import com.example.retro_care.user.model.AppRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
 String getNextCode();

    Employee addEmployee(Employee employee);
    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: Create a method that takes data and returns it to the Page
     * @param pageable
     * @return Page
     */
    Page<Employee> getListEmployee(Pageable pageable);

    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: Create a method that takes data and returns it to the Page
     * @param pageable
     * @param id
     * @param name
     * @return Page
     */
    Page<Employee> searchEmployee(Pageable pageable, Long id , String name);

    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: Get data AppUser from database
     * @return List
     */
    List<AppRole> getRole();

    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: Delete employee with id
     * @param id
     * @return boolean
     */
    boolean deleteEmployee(Long id);
}
