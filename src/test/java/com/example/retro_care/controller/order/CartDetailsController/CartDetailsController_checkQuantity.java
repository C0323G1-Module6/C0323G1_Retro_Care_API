package com.example.retro_care.controller.order.CartDetailsController;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartDetailsController_checkQuantity {
    @Autowired
    private MockMvc mockMvc;

    /**
     * This function is used to test the case when
     * both 2 request params(medicineId, inputQuantity) are provided with null values
     * during the check-quantity process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void checkQuantity_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/check-quantity?medicineId=null&inputQuantity=null"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case when
     * both 2 request params(medicineId, inputQuantity) are provided with no values
     * during the check-quantity process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void checkQuantity_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/check-quantity?medicineId=&inputQuantity="))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case when
     * both 2 request params(medicineId, inputQuantity) are provided with no equivalent values in DB
     * during the check-quantity process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void checkQuantity_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/check-quantity?medicineId=222&inputQuantity=777"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case when
     * both 2 request params(medicineId, inputQuantity) are validly provided
     * during the check-quantity process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void checkQuantity_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/check-quantity?medicineId=1&inputQuantity=1"))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
