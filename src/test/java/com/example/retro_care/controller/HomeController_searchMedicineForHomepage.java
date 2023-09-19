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
public class HomeController_searchMedicineForHomepage {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test NOT_FOUND status with type of medicine is "xxxxxxxxxx" and keyword is "xxxxxxxxxx"
     * @throws Exception Not Found
     * @author HuyL
     */
    @Test
    public void searchMedicineForHomepage_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/home/search?type=xxxxxxxxxxx&keyword=xxxxxxxxxx"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    /**
     * Test OK status with empty type and keyword
     * @throws Exception OK Status
     * @author HuyL
     */
    @Test
    public void searchMedicineForHomepage_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/home/search")
                                .param("type", "")
                                .param("keyword", ""))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Test NOT_FOUND status with keyword search is "xxxxxxxxxx" and type is default ""
     * @throws Exception Ok status
     * @author HuyL
     */
    @Test
    public void searchMedicineForHomepage_99() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/home/search?keyword=xxxxxxxxxx"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Test NOT_FOUND status with keyword type is "xxxxxxxxxx" and keyword is default ""
     * @throws Exception Ok status
     * @author HuyL
     */
    @Test
    public void searchMedicineForHomepage_98() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/home/search?type=xxxxxxxxxx"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
