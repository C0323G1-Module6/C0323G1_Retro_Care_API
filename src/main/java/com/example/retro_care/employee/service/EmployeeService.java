package com.example.retro_care.employee.service;

import com.example.retro_care.employee.model.Employee;
import com.example.retro_care.employee.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @param employee
     * @return this employee have id
     */
    @Override
    public Employee addEmployee(Employee employee) {

        return employeeRepository.addEmployee(employee.getCodeEmployee(),employee.getNameEmployee(),
                employee.getAddress(),employee.getPhoneNumber(),employee.getStartDay(),
                employee.getBirthday(),employee.getIdCard(),employee.getImage(),
                employee.getNote(),employee.isFlagDelete(),employee.getAppUser().getId());
    }
}
