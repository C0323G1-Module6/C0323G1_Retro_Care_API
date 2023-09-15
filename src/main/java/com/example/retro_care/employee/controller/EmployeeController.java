package com.example.retro_care.employee.controller;

import com.example.retro_care.employee.dto.EmployeeDto;
import com.example.retro_care.employee.model.Employee;
import com.example.retro_care.employee.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/create")
    public ResponseEntity<EmployeeDto> getEmployeeToCreate(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee(employeeService.getNextCode());
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto employeeDto, BindingResult bindingResult){
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        Employee employee1 = employeeService.addEmployee(employee);
        if (employee1 == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employee1,HttpStatus.OK);
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
//        Employee employee = employeeService.getById(id);
//        return new ResponseEntity<>(employee,HttpStatus.OK);
//    }
}
