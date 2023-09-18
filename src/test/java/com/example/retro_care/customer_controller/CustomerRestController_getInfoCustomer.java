package com.example.retro_care.customer_controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_getInfoCustomer {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getInfoCustomer_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customers/api/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getInfoCustomer_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customers/api/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
