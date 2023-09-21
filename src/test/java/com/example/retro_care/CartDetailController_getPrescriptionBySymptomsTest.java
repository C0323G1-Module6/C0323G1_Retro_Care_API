package com.example.retro_care;

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
public class CartDetailController_getPrescriptionBySymptomsTest {
    @Autowired
    private MockMvc mockMvc;

    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of prescription when name is null
     * @throws Exception
     */
    @Test
    void getPrescriptionsBySymptoms_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getPrescriptionBySymptoms")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of prescription when name is ""
     * @throws Exception
     */
    @Test
    void getPrescriptionsBySymptoms_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getPrescriptionBySymptoms?symptoms")
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of prescription when symptom is not exsit in database
     * @throws Exception
     */
    @Test
    void getPrescriptionsBySymptoms_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getPrescriptionBySymptoms?symptoms=abc123")
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of prescription when name is exist in database
     * @throws Exception
     */
    @Test
    void getPrescriptionsBySymptoms_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getPrescriptionBySymptoms?symptoms=ho")
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
