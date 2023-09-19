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
     * @Param: none
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
     * Goal: 4xx error
     * @Param: [name]=null
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_name_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?search={searchInput}/", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Hoang Thi Quyen
     * Goal: 4xx error
     * @Param: [name]=" "
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_name_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?search={searchInput}/", " "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Hoang Thi Quyen
     * Goal:  4xx error
     * @Param: [name] is not exist in DB
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_name_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?search={searchInput}", "ghien"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Hoang Thi Quyen
     * Goal: 4xx error
     * @Param: [code] is null
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
     * Goal: 4xx error
     * @Param: [code] = ""
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_code_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?code={code}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Hoang Thi Quyen
     * Goal: 4xx error
     * @Param: [code] is not exist in DB
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_code_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?code={code}", "abc"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Hoang Thi Quyen
     * Goal:  success
     * @Param: [code] exist in DB
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_code_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?code={code}", "KL012"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].name").value("Thị Hạnh Yến"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0913148554"))
                .andExpect(jsonPath("content[0].birthDay").value("1997-01-01"))
                .andExpect(jsonPath("content[0].address").value("Quận 7, Hồ Chí Minh"));
    }

    /**
     * Creator: Hoang Thi Quyen
     * Goal: 4xx error
     * @Param: [address]=null
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_address_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?address={address}/", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Hoang Thi Quyen
     * Goal: 4xx error
     * @Param: [address]=" "
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_address_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?address={address}", " "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Hoang Thi Quyen
     * Goal: Successful
     * @Param: [address]="Hà Nội"
     * @Throw: Exception
     */

    @Test
    public void getAllCustomers_address_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?address={address}", "Hà Nội"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getAllCustomers_address_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?address={address}", "Đà Nẵng"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].name").value("Đàm Minh Nhật Ngọc"))
                .andExpect(jsonPath("content[0].address").value("Sơn Trà, Đà Nẵng"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0913118550"))
                .andExpect(jsonPath("content[0].birthDay").value("2000-01-01"))
                .andExpect(jsonPath("content[4].name").value("Trần Ánh Nguyệt"))
                .andExpect(jsonPath("content[4].address").value("Sơn Trà, Đà Nẵng"))
                .andExpect(jsonPath("content[4].phoneNumber").value("0913178765"))
                .andExpect(jsonPath("content[4].birthDay").value("2000-01-03"));
    }


    /**
     * Creator: Hoang Thi Quyen
     * Goal: 4xx error
     * @Param: [phone]=null
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_phoneNumber_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?phoneNumber={phoneNumber}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: Hoang Thi Quyen
     * Goal: 4xx error
     * @Param: [phone]=" "
     * @Throw: Exception
     */
    @Test
    public void getAllCustomers_phoneNumber_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/list?phoneNumber={phoneNumber}", " "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: Hoang Thi Quyen
     * Goal: getAllCustomers successful
     * @Param: none
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
    }
}
