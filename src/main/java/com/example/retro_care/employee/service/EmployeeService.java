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

     * author: TanNV
     * this function use to find code latest and increase the code by 1 unit
     * @return code has increased by 1 unit
     */
    @Override
    public String getNextCode() {
        String code = employeeRepository.getLastCodeEmployee();
        if(code==null){
            return "NV001";
        }
        int currentNumber = Integer.parseInt(code.substring(2));
        currentNumber ++;
        return "NV" + String.format("%03d", currentNumber);
    }

    /**
     * author: TanNV
     * this function use to give employee to repository and save this employee
     * @param employee
     * @return this employee have id
     */
    @Override
    public void addEmployee(Employee employee) {

        employeeRepository.addEmployee(employee.getCodeEmployee(),employee.getNameEmployee(),
                employee.getAddress(),employee.getPhoneNumber(),employee.getStartDay(),
                employee.getBirthday(),employee.getIdCard(),employee.getImage(),
                employee.getNote(),employee.isFlagDelete(),employee.getAppUser().getId());
    }
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

    /**
     * Author: TanNV
     * Date:16/09/2023
     * Get employee by id
     * @param id
     * @return
     */
    @Override
    public Employee getById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    /**
     * Author: TanNV
     * Date:16/09/2023
     * update employee
     * @param employee
     */
    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee.getNameEmployee(),
                employee.getAddress(),employee.getPhoneNumber(),employee.getStartDay(),
                employee.getBirthday(),employee.getIdCard(),employee.getImage(),
                employee.getNote());
    }
}
