package com.example.retro_care.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicineRestController_findMedicineById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: TinVV
     * Date create: 18/09/2023
     * Function: test id parameter is null
     *
     * @throws Exception
     */
    @Test
    public void findMedicineById_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/medicine/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TinVV
     * Date create: 18/09/2023
     * Function: test id parameter is empty
     *
     * @throws Exception
     */
    @Test
    public void findMedicineById_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/medicine/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TinVV
     * Date create: 18/09/2023
     * Function: test id parameter doesn't exist
     *
     * @throws Exception
     */
    @Test
    public void findMedicineById_id_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/medicine/{id}", "9"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TinVV
     * Date create: 18/09/2023
     * Function: test id parameter exist
     *
     * @throws Exception
     */
    @Test
    public void findMedicineById_id_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/medicine/{id}", "4"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(4))
                .andExpect(jsonPath("code").value("MED001"))
                .andExpect(jsonPath("nameCustomer").value("Medicine"))
                .andExpect(jsonPath("price").value(10.5))
                .andExpect(jsonPath("quantity").value(100))
                .andExpect(jsonPath("vat").value(0.1))
                .andExpect(jsonPath("note").value("Note for Medicine 1"))
                .andExpect(jsonPath("maker").value("Maker 1"))
                .andExpect(jsonPath("activeElement").value("Active Element 1"))
                .andExpect(jsonPath("origin").value("Origin 1"))
                .andExpect(jsonPath("retailProfits").value(0.2))
                .andExpect(jsonPath("kindOfMedicine").value(3))
                .andExpect(jsonPath("flagDeleted").value(3));
    }

    /**
     * Create by: TinVV
     * Date create: 18/09/2023
     * Function: test id parameter invalid
     *
     * @throws Exception
     */
    @Test
    public void findMedicineById_id() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/medicine/{id}", "a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
