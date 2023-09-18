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
public class PrescriptionController_getAllPrescription {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllPrescription_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/prescription?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()
        );
    }

    @Test
    public void getAllPrescription_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/prescription?page=1"))
                .andDo(print())
                .andExpect(status().is(204)
                );
    }
}
