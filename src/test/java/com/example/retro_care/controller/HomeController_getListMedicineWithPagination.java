package com.example.retro_care.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeController_getListMedicineWithPagination {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test to ensure that attempting to access an invalid URL returns a 4xx client error.
     *
     * @throws Exception When an unexpected exception occurs during the test
     * @author HuyL
     */
    @Test
    public void getListMedicineWithPagination_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/home/list-page/wrong-url"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test the getListMedicineWithPagination endpoint with valid parameters.
     *
     * @throws Exception When an unexpected exception occurs during the test
     * @author HuyL
     */
    @Test
    public void getListMedicineWithPagination_6() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("api/home/list-page")
                                .param("page", "0")
                                .param("limit", "8")
                                .param("keyword", "")
                                .param("type", "bổ gan")
                                .param("sortDirection", "asc")
                                .param("sortBy", "medicinePrice")
                )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("content[0].medicineId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("content[0].medicineImage").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("content[0].medicinePrice").value(10.5))
                .andExpect(MockMvcResultMatchers.jsonPath("content[0].medicineName").value("Paracetamol"))
                .andExpect(MockMvcResultMatchers.jsonPath("content[29].medicineId").value(30))
                .andExpect(MockMvcResultMatchers.jsonPath("content[29].medicineImage").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("content[29].medicinePrice").value(8.4))
                .andExpect(MockMvcResultMatchers.jsonPath("content[29].medicineName").value("Metoprolol"));
    }
}
