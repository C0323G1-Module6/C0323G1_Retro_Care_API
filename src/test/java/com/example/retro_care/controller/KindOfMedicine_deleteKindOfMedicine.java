package com.example.retro_care.controller;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class KindOfMedicine_deleteKindOfMedicine {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Check case delete null name
     *Author: CaoNV
     * @throws Exception
     */
    @Test
    public void deleteKindOfMedicine_25() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/kindOfMedicine/delete/id=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Check case delete empty name
     *Author: CaoNV
     * @throws Exception
     */

    @Test
    public void deleteKindOfMedicine_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/kindOfMedicine/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Check case delete do not exits name
     *Author: CaoNV
     * @throws Exception
     */
    @Test
    public void deleteKindOfMedicine_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/kindOfMedicine/delete/{id}", 20))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Check case delete successfully name
     *Author: CaoNV
     * @throws Exception
     */
    @Test
    public void deleteKindOfMedicine_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/kindOfMedicine/delete/{id}", 6))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



}
