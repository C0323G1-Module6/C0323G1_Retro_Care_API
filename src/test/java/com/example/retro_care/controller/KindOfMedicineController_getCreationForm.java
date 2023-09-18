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
public class KindOfMedicineController_getCreationForm {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Check case null name
     * @throws Exception
     */

    @Test
    public void getCreationForm_13() throws Exception {

        KindOfMedicineCreationDto kindOfMedicineCreationDto = new KindOfMedicineCreationDto();
//        kindOfMedicineCreationDto.setCode("");
//        kindOfMedicineCreationDto.setName("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/kindOfMedicine/create")
                        .content(this.objectMapper.writeValueAsString(kindOfMedicineCreationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Check case empty name
     * @throws Exception
     */
@Test
    public void getCreationForm_14() throws Exception {

        KindOfMedicineCreationDto kindOfMedicineCreationDto = new KindOfMedicineCreationDto();
        kindOfMedicineCreationDto.setCode("");
        kindOfMedicineCreationDto.setName("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/kindOfMedicine/create")
                        .content(this.objectMapper.writeValueAsString(kindOfMedicineCreationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Check case wrong format name
     * @throws Exception
     */
    @Test
    public void getCreationForm_15() throws Exception {

        KindOfMedicineCreationDto kindOfMedicineCreationDto = new KindOfMedicineCreationDto();
        kindOfMedicineCreationDto.setCode("");
        kindOfMedicineCreationDto.setName(".......");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/kindOfMedicine/create")
                        .content(this.objectMapper.writeValueAsString(kindOfMedicineCreationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Check case over max length name
     * @throws Exception
     */
    @Test
    public void getCreationForm_16() throws Exception {

        KindOfMedicineCreationDto kindOfMedicineCreationDto = new KindOfMedicineCreationDto();
        kindOfMedicineCreationDto.setCode("");
        kindOfMedicineCreationDto.setName("Thuốc bổ thận mát gan lợi tiểu chống mất ngủ");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/kindOfMedicine/create")
                        .content(this.objectMapper.writeValueAsString(kindOfMedicineCreationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Check case pass name
     * @throws Exception
     */
    @Test
    public void getCreationForm_17() throws Exception {

        KindOfMedicineCreationDto kindOfMedicineCreationDto = new KindOfMedicineCreationDto();
        kindOfMedicineCreationDto.setCode("NT001");
        kindOfMedicineCreationDto.setName("Bổ Gan");
        kindOfMedicineCreationDto.setFlagDeleted(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/kindOfMedicine/create")
                        .content(this.objectMapper.writeValueAsString(kindOfMedicineCreationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
