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
public class PrescriptionController_deletePrescription {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void removePrescription_25() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("prescription/delete/{id}",null))
                .andDo(print())
                .andExpect(status().is4xxClientError()
        );
    }
}
