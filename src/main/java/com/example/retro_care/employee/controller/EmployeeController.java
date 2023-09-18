package com.example.retro_care.employee.controller;


import com.example.retro_care.employee.dto.EmployeeDto;
import com.example.retro_care.employee.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import com.example.retro_care.employee.service.IEmployeeService;
import org.apache.coyote.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import static java.util.Collections.sort;

@RestController
@CrossOrigin("*")
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    /**
     * Author: TanNV
     * Date: 15/09/2023
     * Used to get employee DTO and reset the new code then return an empty employee with the latest code
     *
     * @return Response entity
     */
    @GetMapping("/create")
    public ResponseEntity<EmployeeDto> getEmployeeToCreate() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee(employeeService.getNextCode());
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    /**
     * Author: TanNV
     * Date: 15/09/2023
     * Receive data and validate, if there is an error, return BAD_REQUEST,
     * then save the employee to the DB. If saved successfully, return OK, otherwise NO_CONTENT
     *
     * @param employeeDto
     * @param bindingResult
     * @return Response entity
     */
    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDto employeeDto, BindingResult bindingResult) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.addEmployee(employee);
        return new ResponseEntity<>("Create successfully", HttpStatus.OK);
    }

    /**
     * Author: TanNV
     * Date: 15/09/2023
     * Use to get employee by id and return Http status OK if it can find it else  return http status NO_CONTENT
     * @param id
     * @return Reponse entity
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        Employee employee = employeeService.getById(id);
        if(employee==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    /**
     * Author: TanNV
     * Date: 16/09/2023
     * Receive data and validate, if there is an error, return BAD_REQUEST,
     * then save the employee to the DB. If saved successfully, return OK
     * @param id id employee
     * @param employeeDto validate info
     * @param bindingResult return error
     * @return Responese Entity with message
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id,
                                                   @RequestBody EmployeeDto employeeDto,
                                                   BindingResult bindingResult){
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
        }
        Employee employee = employeeService.getById(id);
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.updateEmployee(employee);
        return new ResponseEntity<>("Update successfully",HttpStatus.OK);
    }
    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: Call the database to retrieve the data with page, limit and sort
     *
     * @param page
     * @param limit
     * @return ResponseEntity<?>
     */
    @GetMapping("/get-list/{page}/{limit}/{sort}")
    public ResponseEntity<Page<Employee>> getListEmployee(@PathVariable(value = "page", required = false) Integer page,
                                                          @PathVariable(value = "limit", required = false) Integer limit,
                                                          @PathVariable(value = "sort", required = false) String sort) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.ASC, sort));
        Page<Employee> employees = employeeService.getListEmployee(pageable);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
    }


    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: Call the database to retrieve paginated data with fields idRole and employee name
     * @param page
     * @param limit
     * @param sort
     * @param idRole
     * @param nameEmployee
     * @return ResponseEntity<?>
     */
    @GetMapping("/search-list")
    public ResponseEntity<Page<Employee>> searchEmployee(@RequestParam(value = "page", required = false) Integer page,
                                                         @RequestParam(value = "limit", required = false) Integer limit,
                                                         @RequestParam(value = "sort", required = false) String sort,
                                                         @RequestParam(value = "role", required = false) Long idRole,
                                                         @RequestParam(value = "name", required = false) String nameEmployee) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by(sort));
        Page<Employee> employees = employeeService.searchEmployee(pageable, idRole, nameEmployee);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }

    }

    /**
     * Create:SonTT
     * Date create: 15/09/2023
     * Function: with the correct input parameter id true then return HttpStatus.OK otherwise return false
     * @param id
     * @return ResponseEntity<>
     */
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam(value = "id", required = false) Long id) {
        if (employeeService.deleteEmployee(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}


















