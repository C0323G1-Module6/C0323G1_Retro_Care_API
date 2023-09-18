package com.example.retro_care;

import com.example.retro_care.employee.dto.EmployeeDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_CreateEmployee {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input null to field name
     * @throws Exception
     */
    @Test
    public void create_employee_name_5() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee(null);
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard("123456789");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employees/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input empty to field name
     * @throws Exception
     */
    @Test
    public void create_employee_name_6() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard("123456789");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input number to field name
     * @throws Exception
     */
    @Test
    public void create_employee_name_7() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("123456");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard("123456789");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input max length to field name
     * @throws Exception
     */
    @Test
    public void create_employee_name_8() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard("123456789");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input null to field address
     * @throws Exception
     */
    @Test
    public void create_employee_address_9() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress(null);
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard("123456789");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input empty to field address
     * @throws Exception
     */
    @Test
    public void create_employee_address_10() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress("");
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard("123456789");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input max length to field address
     * @throws Exception
     */
    @Test
    public void create_employee_address_11() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard("123456789");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input null to field birthday
     * @throws Exception
     */
    @Test
    public void create_employee_birthday_12() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday(null);
        employeeDto.setNote("");
        employeeDto.setIdCard("123456789");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input empty to field birthday
     * @throws Exception
     */
    @Test
    public void create_employee_birthday_13() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday("");
        employeeDto.setNote("");
        employeeDto.setIdCard("123456789");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input null to field start day
     * @throws Exception
     */
    @Test
    public void create_employee_startDay_14() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday(null);
        employeeDto.setNote("");
        employeeDto.setIdCard("123456789");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input empty to field start day
     * @throws Exception
     */
    @Test
    public void create_employee_startDay_15() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday("");
        employeeDto.setNote("");
        employeeDto.setIdCard("123456789");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input null to field idCard
     * @throws Exception
     */
    @Test
    public void create_employee_idCard_16() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard(null);
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input empty to field idCard
     * @throws Exception
     */
    @Test
    public void create_employee_idCard_17() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard("");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input max length to field idCard
     * @throws Exception
     */
    @Test
    public void create_employee_idCArd_18() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard("111111111111111111111");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input wrong format to field idCard
     * @throws Exception
     */
    @Test
    public void create_employee_idCArd_19() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard("01234567aaa");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input null to field phoneNumber
     * @throws Exception
     */
    @Test
    public void create_employee_phoneNumber_20() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard("123456789");
        employeeDto.setPhoneNumber(null);
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input empty to field phoneNumber
     * @throws Exception
     */
    @Test
    public void create_employee_phoneNumber_21() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard("123456789");
        employeeDto.setPhoneNumber("");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input max length to field phoneNumber
     * @throws Exception
     */
    @Test
    public void create_employee_phoneNumber_22() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard("123456789");
        employeeDto.setPhoneNumber("1231231231231231231231231232");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input wrong format to field phoneNumber
     * @throws Exception
     */
    @Test
    public void create_employee_phoneNumber_23() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard("012345678");
        employeeDto.setPhoneNumber("asdasd");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:TanNV
     * Date:18/09/2023
     * Function test input all item successfully
     * @throws Exception
     */
    @Test
    public void create_employee_all_item_24() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCodeEmployee("NV004");
        employeeDto.setNameEmployee("Tan");
        employeeDto.setAddress("123 NVL");
        employeeDto.setBirthday("2002-02-02");
        employeeDto.setNote("");
        employeeDto.setIdCard("012345678");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setStartDay("2023-09-18");
        employeeDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/employees/create")
                                .content(this.objectMapper.writeValueAsString(employeeDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}