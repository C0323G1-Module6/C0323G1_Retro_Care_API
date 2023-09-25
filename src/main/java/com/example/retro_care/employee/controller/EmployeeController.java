package com.example.retro_care.employee.controller;


import com.example.retro_care.customer.service.ICustomerService;
import com.example.retro_care.employee.dto.EmployeeDto;
import com.example.retro_care.employee.model.Employee;
import com.example.retro_care.user.common.ValidateAppUser;
import com.example.retro_care.user.model.AppUser;
import com.example.retro_care.user.service.IAppUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import com.example.retro_care.employee.service.IEmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IAppUserService appUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ICustomerService customerService;
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
        employeeDto.setImage("https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/02/avatar-trang-y-nghia.jpeg?fit=512%2C20000&quality=95&ssl=1");
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    /**
     * Author: TanNV
     * Date: 15/09/2023
     * Receive data and validate, if there is an error, return BAD_REQUEST,
     * then save the employee to the DB. If saved successfully, return OK, otherwise NO_CONTENT
     *
     * @param employeeDto validate
     * @param bindingResult errors
     * @return Response entity
     */
    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto employeeDto, BindingResult bindingResult) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        Map<String, String> errorMap= new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError: bindingResult.getFieldErrors()
                 ) {
                errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(errorMap,HttpStatus.NOT_ACCEPTABLE);
        }
        Employee employeeCheck = employeeService.getByPhoneNumber(employeeDto.getPhoneNumber(),-1L);
        if(employeeCheck!=null){
            errorMap.put("phoneNumber","SĐT đã được đăng ký");
        }

        String errMsg = ValidateAppUser.checkValidateOnlyAppUserName(employeeDto.getAppUser());
        if (!errMsg.equals("")) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(errMsg);
        }

        Boolean userNameExisted = appUserService.existsByUsername(employeeDto.getAppUser());
        if (Boolean.TRUE.equals(userNameExisted)) {
            errorMap.put("appUser","Tài khoản này đã tồn tại");

        }
        if(errorMap.size()>0){
            return new ResponseEntity<>(errorMap,HttpStatus.NOT_ACCEPTABLE);
        }

        AppUser appUser = new AppUser();
        appUser.setUserName(employeeDto.getAppUser());
        appUser.setPassword(passwordEncoder.encode("123"));
        Boolean checkAddNewAppUser = appUserService.createNewAppUser(appUser,"ROLE_EMPLOYEE");
        if (!Boolean.TRUE.equals(checkAddNewAppUser)) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Đăng ký thất bại, vui lòng chờ trong giây lát");
        }
        Long userId = appUserService.findAppUserIdByUserName(employeeDto.getAppUser());
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.addEmployee(employee,userId);
        customerService.saveCustomerForAppUser(userId);
        return new ResponseEntity<>("Thêm mới thành công", HttpStatus.OK);
    }

    /**
     * Author: TanNV
     * Date: 15/09/2023
     * Use to get employee by id and return Http status OK if it can find it else  return http status NO_CONTENT
     * @param id employee id
     * @return Reponse entity
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        if(id==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Employee employee = employeeService.getById(id);
        if(employee==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id,
                                                   @RequestBody EmployeeDto employeeDto,
                                                   BindingResult bindingResult){
        if (id == null){
            return new ResponseEntity<>("Không có id",HttpStatus.BAD_REQUEST);
        }
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().toString(),HttpStatus.NOT_ACCEPTABLE);
        }
        Employee employee = employeeService.getById(id);
        if(employee==null){
            return new ResponseEntity<>("Không tìm thấy",HttpStatus.NOT_FOUND);
        }
        Employee employeeCheck = employeeService.getByPhoneNumber(employeeDto.getPhoneNumber(),id);
        if(employeeCheck!=null){
            return new ResponseEntity<>("SĐT đã được đăng ký",HttpStatus.NOT_ACCEPTABLE);
        }

        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.updateEmployee(employee);
        return new ResponseEntity<>("Update thành công",HttpStatus.OK);
    }


    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: Call the database to retrieve paginated data with fields idRole and employee name
     * @param page number of page
     * @param limit limit element in page
     * @param sort sort
     * @param nameEmployee name employee
     * @return ResponseEntity<?>
     */
    @GetMapping("/list/{page}/{limit}/{sort}")
    public ResponseEntity<Page<Employee>> searchEmployee(@PathVariable(value = "page", required = false) Integer page,
                                                         @PathVariable(value = "limit", required = false) Integer limit,
                                                         @PathVariable(value = "sort", required = false) String sort,
                                                         @RequestParam(value = "name", required = false) String nameEmployee) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.ASC, sort));
        Page<Employee> employees;
        if (nameEmployee == null) {
             employees = employeeService.getListEmployee(pageable);

        } else {
            String trimName = nameEmployee.replaceAll("\\s+", " ");
             employees = employeeService.searchEmployee(pageable, trimName);
        }
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
    }
    /**
     * Create: SonTT
     * Date create: 15/09/2023
     * Function: Call the database to retrieve paginated data with fields idRole and employee name
     * @param page number of page
     * @param limit limit element in page
     * @param sort sort
     * @param nameEmployee name employee
     * @return ResponseEntity<?>
     */
    @GetMapping("/list1/{page}/{limit}/{sort}")
    public ResponseEntity<Page<Employee>> listEmployee(@PathVariable(value = "page", required = false) Integer page,
                                                         @PathVariable(value = "limit", required = false) Integer limit,
                                                         @PathVariable(value = "sort", required = false) String sort,
                                                         @RequestParam(value = "name", required = false) String nameEmployee) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, sort));
        Page<Employee> employees;
        if (nameEmployee == null) {
            employees = employeeService.getListEmployee(pageable);

        } else {
            String trimName = nameEmployee.replaceAll("\\s+", " ");
            employees = employeeService.searchEmployee(pageable, trimName);
        }
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
    }

    /**
     * Create:SonTT
     * Date create: 15/09/2023
     * Function: with the correct input parameter id true then return HttpStatus.OK otherwise return false
     * @param id id employee
     * @return ResponseEntity<>
     */
    @DeleteMapping("/delete-employee")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam(value = "id", required = false) Long id) {
        if (employeeService.findEmployee(id)==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            if (employeeService.deleteEmployee(id)) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }
    @GetMapping("/by-user/{username}")
    public ResponseEntity<Employee> getEmployeeByUserName(@PathVariable String username) {
        Employee employee = employeeService.getEmployeeByUserName(username);
        if (employee == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}


















