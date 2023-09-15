package com.example.retro_care.employee.service;

import com.example.retro_care.employee.model.Employee;

public interface IEmployeeService {
    String getNextCode();

    Employee addEmployee(Employee employee);
}
