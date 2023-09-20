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
public class HomeController_findFavoriteMedicineForHomepage {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test if the methods show the right results with the product with the highest quantity on top
     * @throws Exception Successful Ok status
     * @author HuyL
     */
    @Test
    public void findFavoriteMedicineForHomepage_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(("/api/home/favorite")))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(3))
                .andExpect(jsonPath("$[0].code").value("VITC01"))
                .andExpect(jsonPath("$[0].quantity").value(1200));
    }

    /**
     * Test when database had empty, the result is not found
     * @throws Exception Not Found
     * @author HuyL
     */
    @Test
    public void findFavoriteMedicineForHomepage_5() throws Exception {
//        Database had empty
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(("/api/home/favorite")))
                .andDo(print())
                .andExpect(jsonPath("$").isEmpty())
                .andExpect(status().isNotFound());
    }

    /**
     * Test for wrong url
     * @throws Exception 404 Not Found
     * @author HuyL
     */
    @Test
    public void findFavoriteMedicineForHomepage_99() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(("/api/home/favorite_wrong_url")))
                .andDo(print())
                .andExpect(jsonPath("$").doesNotExist())
                .andExpect(status().isNotFound());
    }
}
