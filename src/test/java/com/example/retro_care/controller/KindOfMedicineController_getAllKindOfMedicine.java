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
     * Check case list equal 0 name
     * @throws Exception
     */

    @Test
    public void KindOfMedicineController_getAllKindOfMedicine_5() throws Exception {

        KindOfMedicineCreationDto kindOfMedicineCreationDto = new KindOfMedicineCreationDto();
        kindOfMedicineCreationDto.setCode("NT001");
        kindOfMedicineCreationDto.setName("Bổ Gan");
        kindOfMedicineCreationDto.setFlagDeleted(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/kindOfMedicine/get"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(15))
                .andExpect(jsonPath("content[0].code").value("NT001"))
                .andExpect(jsonPath("content[0].name").value("Bổ Gan"));

    }

    /**
     * Check case "list more than 0" name
     * @throws Exception
     */

    @Test
    public void KindOfMedicineController_getAllKindOfMedicine_6() throws Exception {

        KindOfMedicineCreationDto kindOfMedicineCreationDto = new KindOfMedicineCreationDto();
        kindOfMedicineCreationDto.setCode("NT001");
        kindOfMedicineCreationDto.setName("Bổ Gan");
        kindOfMedicineCreationDto.setFlagDeleted(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/kindOfMedicine")
                        .content(this.objectMapper.writeValueAsString(kindOfMedicineCreationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
