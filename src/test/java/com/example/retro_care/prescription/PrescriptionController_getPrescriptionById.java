package com.example.retro_care.prescription;

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
public class PrescriptionController_getPrescriptionById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * method :getPrescriptionById_4
     * created by :ThanhKn
     * date create: 18/09/2023
     * goal: get prescription by id with id have list prescription
     */
    @Test
    public void getPrescriptionById_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/prescription/{id}",6))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * method :getPrescriptionById_3
     * created by :ThanhKn
     * date create: 18/09/2023
     * goal: get prescription by id with id no have list prescription
     */
    @Test
    public void getPrescriptionById_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/prescription/{id}",100))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
