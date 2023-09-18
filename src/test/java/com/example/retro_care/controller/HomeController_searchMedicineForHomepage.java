package com.example.retro_care.controller;

import com.example.retro_care.home.service.IHomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeController_searchMedicineForHomepage {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IHomeService homeService;

    /**
     * Test NOT_FOUND status with keyword search is "!@%23$%25%5E%26"
     * @throws Exception 404 error
     * @author HuyL
     */
    @Test
    public void searchMedicineForHomepage_5() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/home/search")
                                .param("keyword", "!@%23$%25%5E%26"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    /**
     * Test NOT_FOUND status with type of medicine is "!@%23$%25%5E%26"
     * @throws Exception 404 error
     * @author HuyL
     */
    @Test
    public void searchMedicineForHomepage_5_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/home/search")
                                .param("type", "!@%23$%25%5E%26"))
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
}
