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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class KindOfMedicineController_editKindOfMedicine {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Check case null name
     *Author: CaoNV
     * @throws Exception
     */

    @Test
    public void editKindOfMedicine_19() throws Exception {

        KindOfMedicineCreationDto kindOfMedicineCreationDto = new KindOfMedicineCreationDto();
//        kindOfMedicineCreationDto.setCode("");
//        kindOfMedicineCreationDto.setName("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/kindOfMedicine/edit")
                        .content(this.objectMapper.writeValueAsString(kindOfMedicineCreationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case empty name
     * Author: CaoNV
     * @throws Exception
     */
    @Test
    public void editKindOfMedicine_20() throws Exception {

        KindOfMedicineCreationDto kindOfMedicineCreationDto = new KindOfMedicineCreationDto();
        kindOfMedicineCreationDto.setCode("");
        kindOfMedicineCreationDto.setName("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/kindOfMedicine/edit")
                        .content(this.objectMapper.writeValueAsString(kindOfMedicineCreationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case wrong format name
     * Author: CaoNV
     * @throws Exception
     */
    @Test
    public void editKindOfMedicine_21() throws Exception {

        KindOfMedicineCreationDto kindOfMedicineCreationDto = new KindOfMedicineCreationDto();
        kindOfMedicineCreationDto.setCode("");
        kindOfMedicineCreationDto.setName(".......");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/kindOfMedicine/edit")
                        .content(this.objectMapper.writeValueAsString(kindOfMedicineCreationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case over max length name
     * Author: CaoNV
     * @throws Exception
     */
    @Test
    public void editKindOfMedicine_23() throws Exception {

        KindOfMedicineCreationDto kindOfMedicineCreationDto = new KindOfMedicineCreationDto();
        kindOfMedicineCreationDto.setCode("");
        kindOfMedicineCreationDto.setName("Thuốc bổ thận mát gan lợi tiểu chống mất ngủ");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/kindOfMedicine/edit")
                        .content(this.objectMapper.writeValueAsString(kindOfMedicineCreationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case pass name
     * Author: CaoNV
     * @throws Exception
     */
    @Test
    public void editKindOfMedicine_24() throws Exception {

        KindOfMedicineCreationDto kindOfMedicineCreationDto = new KindOfMedicineCreationDto();
        kindOfMedicineCreationDto.getId();
        kindOfMedicineCreationDto.setCode("NT001");
        kindOfMedicineCreationDto.setName("Bổ Gan");
        kindOfMedicineCreationDto.setFlagDeleted(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/kindOfMedicine/edit")
                        .content(this.objectMapper.writeValueAsString(kindOfMedicineCreationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}