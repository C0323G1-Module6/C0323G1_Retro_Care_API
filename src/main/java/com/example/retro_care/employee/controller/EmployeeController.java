package com.example.retro_care.employee.controller;

import com.example.retro_care.employee.model.Employee;
import com.example.retro_care.employee.service.IEmployeeService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @GetMapping("/get_list/{page}/{limit}")
    public ResponseEntity<Page<Employee>> getListEmployee(@PathVariable(value = "page", required = false) Integer page,
                                                          @PathVariable(value = "limit", required = false) Integer limit) {
        Pageable pageable = PageRequest.of(page, limit);
      Page<Employee> employees=  employeeService.getListEmployee(pageable);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
    }

    @GetMapping("/search-list/{page}/{limit}/{sort}")
    public ResponseEntity<Page<Employee>> searchEmployee(@PathVariable(value = "page", required = false) Integer page,
                                                         @PathVariable(value = "limit", required = false) Integer limit,
                                                         @PathVariable(value = "sort", required = false) String sort,
                                                         @RequestParam(value = "role", required = false) Long idRole,
                                                         @RequestParam(value = "name", required = false) String nameEmployee) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by(sort));
        if (idRole == null && nameEmployee.isEmpty()) {
            return new ResponseEntity<>(employeeService.getListEmployee(pageable), HttpStatus.OK);
        } else {
            if (employeeService.searchEmployee(pageable, idRole, nameEmployee).isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(employeeService.searchEmployee(pageable, idRole, nameEmployee), HttpStatus.OK);
            }
        }
    }
}
