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
     *
     * @throws Exception
     */

    @Test
    public void KindOfMedicineController_getAllKindOfMedicine_5() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/kindOfMedicine/get?page=90"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Check case list size equal 0 name
     * Author: CaoNV
     *
     * @throws Exception
     */
    @Test
    public void KindOfMedicineController_getAllKindOfMedicine_1() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/kindOfMedicine/get?page=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }


    @Test
    public void KindOfMedicineController_getAllKindOfMedicine_6() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/kindOfMedicine/get?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    /**
     * Check case searchCode null name
     * Author: CaoNV
     *
     * @throws Exception
     */

    @Test
    public void KindOfMedicineController_getAllKindOfMedicine_searchCode_7() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/kindOfMedicine/get?page=2&&searchCode=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Check case searchName null name
     * Author: CaoNV
     *
     * @throws Exception
     */

    @Test
    public void KindOfMedicineController_getAllKindOfMedicine_searchName_7() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/kindOfMedicine/get?page=2&&searchName=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Check case searchCode empty name
     * Author: CaoNV
     *
     * @throws Exception
     */

    @Test
    public void KindOfMedicineController_getAllKindOfMedicine_searchCode_8() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/kindOfMedicine/get?page=2&&searchCode=''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Check case searchName empty name
     * Author: CaoNV
     *
     * @throws Exception
     */

    @Test
    public void KindOfMedicineController_getAllKindOfMedicine_searchName_8() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/kindOfMedicine/get?page=2&&searchName=''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Check case searchCode do not exist name
     * Author: CaoNV
     *
     * @throws Exception
     */

    @Test
    public void KindOfMedicineController_getAllKindOfMedicine_searchCode_9() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/kindOfMedicine/get?page=90&&searchCode="))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Check case searchName dot not exist name
     * Author: CaoNV
     *
     * @throws Exception
     */

    @Test
    public void KindOfMedicineController_getAllKindOfMedicine_searchName_9() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/kindOfMedicine/get?page=90&&searchName="))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    /**
     * Check case searchCode successfully name
     * Author: CaoNV
     *
     * @throws Exception
     */

    @Test
    public void KindOfMedicineController_getAllKindOfMedicine_searchCode_11() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/kindOfMedicine/get?page=1&&searchCode="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    /**
     * Check case searchName successfully name
     * Author: CaoNV
     *
     * @throws Exception
     */

    @Test
    public void KindOfMedicineController_getAllKindOfMedicine_searchName_11() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/kindOfMedicine/get?page=1&&searchName="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }


}
