package com.example.retro_care.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
public class CustomerController_getAllCustomers {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Creator: Hoang Thi Quyen
     * Goal: Empty list
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_name_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/customers/api/list?search=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: Hoang Thi Quyen
     * Goal: [name] is not exist in DB
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_name_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?search=ghien"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: Hoang Thi Quyen
     * Goal: successful
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_6() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/customers/api/list?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(14))
                .andExpect(jsonPath("content[0].code").value("KL001"))
                .andExpect(jsonPath("content[0].name").value("Đàm Minh Ngọc"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0913118555"))
                .andExpect(jsonPath("content[0].birthDay").value("2000-01-01"))
                .andExpect(jsonPath("content[0].address").value("Sơn Trà, Đà Nẵng"))
                .andExpect(jsonPath("content[4].code").value("KL005"))
                .andExpect(jsonPath("content[4].name").value("Thị Hạnh"))
                .andExpect(jsonPath("content[4].phoneNumber").value("0913148555"))
                .andExpect(jsonPath("content[4].birthDay").value("1997-01-01"))
                .andExpect(jsonPath("content[4].address").value("Quận 7, Hồ Chí Minh"));;
    }



}
