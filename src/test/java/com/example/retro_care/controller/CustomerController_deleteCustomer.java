package com.example.retro_care.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerController_deleteCustomer {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Creator: Hoang Thi Quyen
     * Goal: [id]= null
     * @Throw: Exception
     */
    @Test
    public void deleteCustomers_25() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/delete/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: Hoang Thi Quyen
     * Goal: [id]= ""
     * @Throw: Exception
     */
    @Test
    public void deleteCustomers_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/delete/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: Hoang Thi Quyen
     * Goal: [id]= not exist
     * @Throw: Exception
     */
    @Test
    public void deleteCustomers_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/delete/100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: Hoang Thi Quyen
     * Goal: [id]= exist, successful
     * @Throw: Exception
     */
    @Test
    public void deleteCustomers_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/api/delete/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}