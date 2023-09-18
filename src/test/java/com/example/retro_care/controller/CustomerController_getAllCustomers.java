package com.example.retro_care.controller;

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
public class CustomerController_getAllCustomers {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Creator: Hoang Thi Quyen
     * Goal: Empty list
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Hoang Thi Quyen
     * Goal: [name]=null
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
     * Goal: [code] is null
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_code_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?code=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Hoang Thi Quyen
     * Goal: [code] = ""
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_code_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?code=''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Hoang Thi Quyen
     * Goal: [code] is not exist in DB
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_code_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?code=abc"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Hoang Thi Quyen
     * Goal: [code] exist in DB, success
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_code_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?code=KL012"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].name").value("Thị Hạnh Yến"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0913148554"))
                .andExpect(jsonPath("content[0].birthDay").value("1997-01-01"))
                .andExpect(jsonPath("content[0].address").value("Quận 7, Hồ Chí Minh"));
    }
    /**
     * Creator: Hoang Thi Quyen
     * Goal: [address]=null
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_address_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?address=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: Hoang Thi Quyen
     * Goal: [address]=""
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_address_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?address={address}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: Hoang Thi Quyen
     * Goal: getAllCustomers successful
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(7))
                .andExpect(jsonPath("content[0].code").value("KL008"))
                .andExpect(jsonPath("content[0].name").value("Đàm Minh Nhật Ngọc"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0913118550"))
                .andExpect(jsonPath("content[0].birthDay").value("2000-01-01"))
                .andExpect(jsonPath("content[0].address").value("Sơn Trà, Đà Nẵng"))
                .andExpect(jsonPath("content[4].code").value("KL012"))
                .andExpect(jsonPath("content[4].name").value("Thị Hạnh Yến"))
                .andExpect(jsonPath("content[4].phoneNumber").value("0913148554"))
                .andExpect(jsonPath("content[4].birthDay").value("1997-01-01"))
                .andExpect(jsonPath("content[4].address").value("Quận 7, Hồ Chí Minh"));
        ;
    }

}
