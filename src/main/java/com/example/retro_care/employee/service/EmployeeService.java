package com.example.retro_care.employee.service;

import com.example.retro_care.employee.model.Employee;
import com.example.retro_care.employee.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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
     *
     * @param employee
     * @param userId
     * @return this employee have id
     */
    @Override
    public void addEmployee(Employee employee, Long userId) {

        employeeRepository.addEmployee(employee.getCodeEmployee(),employee.getNameEmployee(),
                employee.getAddress(),employee.getPhoneNumber(),employee.getStartDay(),
                employee.getBirthday(),employee.getIdCard(),employee.getImage(),
                employee.getNote(),employee.isFlagDelete(),userId);
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
     * @param name
     * @return Page
     */
    @Override
    public Page<Employee> searchEmployee(Pageable pageable, String name) {
        return employeeRepository.searchEmployeeByNameAndRole(pageable,name);
    }

    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: Get data AppRole from repository
     * @return List
     */
    @Override
    public Employee findEmployee(Long id) {
        try{
            return employeeRepository.findEmployeeById(id);
        }catch (Exception e){
            return null;
        }

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
        try{
            employeeRepository.deleteEmployeeById(id);
            return true;
        }catch (Exception e){
            return false;
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
                employee.getNote(),employee.getId());
    }
}
