package com.example.retro_care.employeeController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_ListEmployee {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create: SonTT
     * Date create: 18/09/2023
     * Handling: The given data is empty
     * @throws Exception
     */
    @Test
    public void getListEmployee_5() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/employees/get-list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: SonTT
     * Date create: 18/09/2023
     * Handling: Enter data including pages, quantity and arrangement with returned List
     * @throws Exception
     */
    @Test
    public void getListEmployee_6() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/employees/get-list/{page}/{limit}/{sort}",0,5,"code_employee"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(9))
                .andExpect(jsonPath("content[0].id").value("1"))
                .andExpect(jsonPath("content[0].nameEmployee").value("thanh"))
                .andExpect(jsonPath("content[0].address").value("đà nẵng"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0984736547"))
                .andExpect(jsonPath("content[0].startDay").value("2023-09-09"))
                .andExpect(jsonPath("content[0].birthday").value("2023-09-02"))
                .andExpect(jsonPath("content[0].idCard").value("345123345742"))
                .andExpect(jsonPath("content[4].id").value("5"))
                .andExpect(jsonPath("content[4].nameEmployee").value("Son"))
                .andExpect(jsonPath("content[4].address").value("đà nẵng"))
                .andExpect(jsonPath("content[4].phoneNumber").value("0984736547"))
                .andExpect(jsonPath("content[4].startDay").value("2023-09-09"))
                .andExpect(jsonPath("content[4].birthday").value("2023-09-02"))
                .andExpect(jsonPath("content[4].idCard").value("345123345742"));
    }

    /**
     * Create: SonTT
     * Date create: 18/09/2023
     * Handling: Enter data including pages, quantity, arrangement and role, name even null
     * @throws Exception
     */
    @Test
    public void getListEmployee_searchRoleAndName_7() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/employees/search-list/{page}/{limit}/{sort}?role=null&&name=null",0,5,"code_employee"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: SonTT
     * Date create: 18/09/2023
     * Handling: Enter data including pages, quantity, arrangement and role is empty, name is null
     * @throws Exception
     */
    @Test
    public void getListEmployee_searchRole_8() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/employees/search-list/{page}/{limit}/{sort}?role=''&&name=null",0,5,"code_employee"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: SonTT
     * Date create: 18/09/2023
     * Handling: Enter data including pages, quantity, arrangement and role is 3, name is null
     * @throws Exception
     */
    @Test
    public void getListEmployee_searchRole_9() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/employees/search-list/{page}/{limit}/{sort}?role= 3 &&name=null",0,5,"code_employee"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: SonTT
     * Date create: 18/09/2023
     * Handling: Enter data including pages, quantity, arrangement and role is 2, name is null
     * @throws Exception
     */
    @Test
    public void getListEmployee_searchRole_10() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/employees/search-list/{page}/{limit}/{sort}?role= 2 &&name=null",0,5,"code_employee"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: SonTT
     * Date create: 18/09/2023
     * Handling: Enter data including pages, quantity, arrangement and role is 1, name is null with returned List
     * @throws Exception
     */
    @Test
    public void getListEmployee_searchRole_11() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/employees/search-list/{page}/{limit}/{sort}?role= 1 &&name=null",0,5,"code_employee"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(9))
                .andExpect(jsonPath("content[0].id").value("1"))
                .andExpect(jsonPath("content[0].nameEmployee").value("thanh"))
                .andExpect(jsonPath("content[0].address").value("đà nẵng"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0984736547"))
                .andExpect(jsonPath("content[0].startDay").value("2023-09-09"))
                .andExpect(jsonPath("content[0].birthday").value("2023-09-02"))
                .andExpect(jsonPath("content[0].idCard").value("345123345742"))
                .andExpect(jsonPath("content[4].id").value("5"))
                .andExpect(jsonPath("content[4].nameEmployee").value("Son"))
                .andExpect(jsonPath("content[4].address").value("đà nẵng"))
                .andExpect(jsonPath("content[4].phoneNumber").value("0984736547"))
                .andExpect(jsonPath("content[4].startDay").value("2023-09-09"))
                .andExpect(jsonPath("content[4].birthday").value("2023-09-02"))
                .andExpect(jsonPath("content[4].idCard").value("345123345742"));
    }

    /**
     * Create: SonTT
     * Date create: 18/09/2023
     * Handling: Enter data including pages, quantity, arrangement and role is null, name is empty
     * @throws Exception
     */
    @Test
    public void getListEmployee_searchName_8() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/employees/search-list/{page}/{limit}/{sort}?role=null&&name=''",0,5,"code_employee"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: SonTT
     * Date create: 18/09/2023
     * Handling: Enter data including pages, quantity, arrangement and role is null, name is minh man
     * @throws Exception
     */
    @Test
    public void getListEmployee_searchName_9() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/employees/search-list/{page}/{limit}/{sort}?role= null &&name='minh man'",0,5,"code_employee"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: SonTT
     * Date create: 18/09/2023
     * Handling: Enter data including pages, quantity, arrangement and role is null, name is Dao
     * @throws Exception
     */
    @Test
    public void getListEmployee_searchName_10() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/employees/search-list/{page}/{limit}/{sort}?role= null &&name='Dao'",0,5,"code_employee"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: SonTT
     * Date create: 18/09/2023
     * Handling: Enter data including pages, quantity, arrangement and role is 1, name is n with returned List
     * @throws Exception
     */
    @Test
    public void getListEmployee_searchName_11() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/employees/search-list/{page}/{limit}/{sort}?role= 1 &&name='n'",0,5,"code_employee"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(9))
                .andExpect(jsonPath("content[0].id").value("1"))
                .andExpect(jsonPath("content[0].nameEmployee").value("thanh"))
                .andExpect(jsonPath("content[0].address").value("đà nẵng"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0984736547"))
                .andExpect(jsonPath("content[0].startDay").value("2023-09-09"))
                .andExpect(jsonPath("content[0].birthday").value("2023-09-02"))
                .andExpect(jsonPath("content[0].idCard").value("345123345742"))
                .andExpect(jsonPath("content[4].id").value("5"))
                .andExpect(jsonPath("content[4].nameEmployee").value("Son"))
                .andExpect(jsonPath("content[4].address").value("đà nẵng"))
                .andExpect(jsonPath("content[4].phoneNumber").value("0984736547"))
                .andExpect(jsonPath("content[4].startDay").value("2023-09-09"))
                .andExpect(jsonPath("content[4].birthday").value("2023-09-02"))
                .andExpect(jsonPath("content[4].idCard").value("345123345742"));
    }

}
