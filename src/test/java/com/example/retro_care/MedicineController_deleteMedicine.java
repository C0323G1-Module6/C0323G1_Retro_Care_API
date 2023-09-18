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
public class MedicineController_deleteMedicine {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deleteMedicine_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/medicine/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void deleteMedicine_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/medicine/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteMedicine_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/medicine/{id}", 100))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteMedicine_25() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/medicine/id=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
