package com.example.retro_care.customer_controller;

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
public class CustomerRestController_getInfoCustomer {
    @Autowired
    private MockMvc mockMvc;
    /**
     * this function is success
     * Author: TinDT
     */

    @Test
    public void getInfoCustomer_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customers/api/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * This function is used to check the id parameter is empty
     * * Author: TinDT
     */
    @Test
    public void getInfoCustomer_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customers/api/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check that the id parameter does not exist
     * * Author: TinDT
     */
    @Test
    public void getInfoCustomer_id_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customers/api/{id}", "79"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
