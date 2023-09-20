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

    /**
     * method :removePrescription_28
     * created by :ThanhKn
     * date create: 18/09/2023
     * goal: remove prescription by id with id have list prescription
     */
    @Test
    public void removePrescription_28() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/prescription/delete/{id}",10))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()
        );
    }

    /**
     * method :removePrescription_28
     * created by :ThanhKn
     * date create: 18/09/2023
     * goal: remove prescription by id with id empty
     */
    @Test
    public void removePrescription_26() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/prescription/delete/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError()
                );
    }

    /**
     * method :removePrescription_28
     * created by :ThanhKn
     * date create: 18/09/2023
     * goal: remove prescription by id with id no have list prescription
     */
    @Test
    public void removePrescription_27() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/prescription/delete/{id}",50))
                .andDo(print())
                .andExpect(status().is4xxClientError()
                );
    }

}
