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
     * Goal: [id]= ""
     * @Throw: Exception
     */
    @Test
    public void deleteCustomers_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/customers/api/delete/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: Hoang Thi Quyen
     * Goal: [id]= not exist in DB
     * @Throw: Exception
     */
    @Test
    public void deleteCustomers_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/customers/api/delete/{id}",100))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: Hoang Thi Quyen
     * Goal: [id]= exist in DB, successful
     * @Throw: Exception
     */
    @Test
    public void deleteCustomers_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/customers/api/delete/{id}",13))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}