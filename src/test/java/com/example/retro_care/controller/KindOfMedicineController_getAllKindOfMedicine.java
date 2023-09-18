package com.example.retro_care.controller;

import com.example.retro_care.kind_of_medicine.dto.KindOfMedicineCreationDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class KindOfMedicineController_getAllKindOfMedicine {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Check case list null name
     * Author: CaoNV
     * @throws Exception
     */

    @Test
    public void KindOfMedicineController_getAllKindOfMedicine_5() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/kindOfMedicine/get?page=5"))
                .andDo(print())
                .andExpect(status().is(204));

    }
    /**
     * Check case list size equal 0 name
     * Author: CaoNV
     * @throws Exception
     */

    @Test
    public void KindOfMedicineController_getAllKindOfMedicine_6() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/kindOfMedicine/get?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }


}
