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
     * Tests if the method displays the correct results with the product having the highest quantity on top.
     *
     * @throws Exception Thrown when the test encounters an unexpected error.
     * @author HuyL
     */
    @Test
    public void findFavoriteMedicineForHomepage_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(("/api/home/favorite")))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].medicineId").value(4))
                .andExpect(jsonPath("$[0].medicineName").value("Aspirin"))
                .andExpect(jsonPath("$[0].medicinePrice").value(7.9))
                .andExpect(jsonPath("$[0].medicineImage").exists())
                .andExpect(jsonPath("$[0].medicineSaleQuantity").value(16))
                .andExpect(jsonPath("$[29].medicineId").value(19))
                .andExpect(jsonPath("$[29].medicineName").value("Lisinopril"))
                .andExpect(jsonPath("$[29].medicinePrice").value(12.8))
                .andExpect(jsonPath("$[29].medicineImage").exists())
                .andExpect(jsonPath("$[29].medicineSaleQuantity").value(1));
    }


    /**
     * Tests the case when the database is empty, ensuring the result is not found.
     *
     * @throws Exception Thrown when the test encounters an unexpected error.
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
     * Tests for the case of a wrong URL, expecting a 404 Not Found response.
     *
     * @throws Exception Thrown when the test encounters an unexpected error.
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
