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
public class HomeController_findAllMedicineForHomepage {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test for get list with size > 0
     * @throws Exception successful
     * @author HuyL
     */
    @Test
    public void findAllMedicineForHomepage_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(("/api/home/")))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].code").value("IBU01"))
                .andExpect(jsonPath("$[0].name").value("Ibuprofen Tablets"))
                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[2].code").value("VITC01"))
                .andExpect(jsonPath("$[2].name").value("Vitamin C Tablets"));
    }

    /**
     * Test for wrong url
     * @throws Exception 404 Not Found
     * @author HuyL
     */
    @Test
    public void findAllMedicineForHomepage_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(("/api/home_wrong_url/")))
                .andDo(print())
                .andExpect(jsonPath("$").doesNotExist())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Test NOT_FOUND status by empty database
     * @throws Exception NOT_FOUND
     * @author HuyL
     */
    @Test
    public void findAllMedicineForHomepage_99() throws Exception {
//        Database had empty
        mockMvc.perform(MockMvcRequestBuilders.get("/api/home/"))
                .andDo(print())
                .andExpect(jsonPath("$").isEmpty())
                .andExpect(status().isNotFound());
    }
}
