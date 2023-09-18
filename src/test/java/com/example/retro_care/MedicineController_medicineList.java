package com.example.retro_care;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicineController_medicineList {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Empty list medicine
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void listMedicine_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/medicine"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void listMedicine_6() throws Exception{
            this.mockMvc.perform(MockMvcRequestBuilders.get("/api/medicine/get-medicine?page=0&limit=5"))
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful())
                    .andExpect(jsonPath("totalPages").value(1))
                    .andExpect(jsonPath("totalElements").value(3))
                    .andExpect(jsonPath("content[0].id").value(1))
                    .andExpect(jsonPath("content[0].activeElement").value("ok"))
                    .andExpect(jsonPath("content[0].code").value("T00001"))
                    .andExpect(jsonPath("content[0].maker").value("Anh Dao"))
                    .andExpect(jsonPath("content[0].name").value("Pandol"))
                    .andExpect(jsonPath("content[0].note").value("Ngon"))
                    .andExpect(jsonPath("content[0].origin").value("VietNam"))
                    .andExpect(jsonPath("content[0].price").value("15000.1"))
                    .andExpect(jsonPath("content[0].quantity").value("100"))
                    .andExpect(jsonPath("content[0].retailProfits").value("5.1"))
                    .andExpect(jsonPath("content[0].vat").value("5.1"))
                    .andExpect(jsonPath("content[0].kindOfMedicine.id").value("2"))
                    .andExpect(jsonPath("content[2].id").value(3))
                    .andExpect(jsonPath("content[2].activeElement").value("ok"))
                    .andExpect(jsonPath("content[2].code").value("T00011"))
                    .andExpect(jsonPath("content[2].maker").value("Anh Dao"))
                    .andExpect(jsonPath("content[2].name").value("MAT ONG"))
                    .andExpect(jsonPath("content[2].note").value("Ngon"))
                    .andExpect(jsonPath("content[2].origin").value("VietNam"))
                    .andExpect(jsonPath("content[2].price").value("15000.1"))
                    .andExpect(jsonPath("content[2].quantity").value("100"))
                    .andExpect(jsonPath("content[2].retailProfits").value("5.1"))
                    .andExpect(jsonPath("content[2].vat").value("5.1"))
                    .andExpect(jsonPath("content[2].kindOfMedicine.id").value("1"));
    }
}
