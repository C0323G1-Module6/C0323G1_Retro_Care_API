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
public class HomeController_findMedicineForHomepage {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test to retrieve a list of medicines with a size greater than 0.
     *
     * @throws Exception Thrown when the test encounters an unexpected error.
     * @author HuyL
     */
    @Test
    public void findMedicineForHomepage_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(("/api/home/")))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].medicineId").value(1))
                .andExpect(jsonPath("$[0].medicineImage").exists())
                .andExpect(jsonPath("$[0].medicinePrice").value(10.5))
                .andExpect(jsonPath("$[0].medicineName").value("Paracetamol"))
                .andExpect(jsonPath("$[29].medicineId").value(30))
                .andExpect(jsonPath("$[29].medicineImage").exists())
                .andExpect(jsonPath("$[29].medicinePrice").value(8.4))
                .andExpect(jsonPath("$[29].medicineName").value("Metoprolol"));
    }

    /**
     * Test for a wrong URL, expecting a 404 Not Found response.
     *
     * @throws Exception Thrown when the test encounters an unexpected error.
     * @author HuyL
     */
    @Test
    public void findMedicineForHomepage_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(("/api/home_wrong_url/")))
                .andDo(print())
                .andExpect(jsonPath("$").doesNotExist())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Tests the NOT_FOUND status when the database is empty.
     *
     * @throws Exception Thrown when the test encounters an unexpected error.
     * @author HuyL
     */
    @Test
    public void findMedicineForHomepage_99() throws Exception {
//        Database had empty
        mockMvc.perform(MockMvcRequestBuilders.get("/api/home/"))
                .andDo(print())
                .andExpect(jsonPath("$").isEmpty())
                .andExpect(status().isNotFound());
    }
}
