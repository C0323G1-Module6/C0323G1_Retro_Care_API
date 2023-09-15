package com.example.retro_care.employee.service;

import com.example.retro_care.employee.model.Employee;
import com.example.retro_care.employee.repository.IEmployeeRepository;
import com.example.retro_care.user.model.AppRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepository employeeRepository;

    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: Get data from repository with method getListEmployee
     * @param pageable
     * @return Page with data Employee
     */
    @Override
    public Page<Employee> getListEmployee(Pageable pageable) {
        return employeeRepository.getListEmployee(pageable);
    }

    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: search employee with id and name and with pagination
     * @param pageable
     * @param id
     * @param name
     * @return Page
     */
    @Override
    public Page<Employee> searchEmployee(Pageable pageable, Long id, String name) {
        return employeeRepository.searchEmployeeByNameAndRole(pageable,id,name);
    }

    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: Get data AppRole from repository
     * @return List
     */
    @Override
    public List<AppRole> getRole() {
        return employeeRepository.getRole();
    }

    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: If the id is not found, return false otherwise return true
     * @param id
     * @return boolean
     */
    @Override
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.findEmployeeById(id) == null){
            return false;
        }else {
            employeeRepository.deleteEmployeeById(id);
            return true;
        }
    }
}
