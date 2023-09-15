package com.example.retro_care.employee.repository;

import com.example.retro_care.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
}
