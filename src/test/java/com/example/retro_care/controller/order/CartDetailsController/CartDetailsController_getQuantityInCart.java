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
public class CartDetailsController_getQuantityInCart {

    @Autowired
    private MockMvc mockMvc;

    /**
     * This function is used to test the case when
     * both 2 request params(appUserId, medicineId) are provided with null values
     * during the get-quantity-in-cart process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getQuantityInCart_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-quantity-in-cart?appUserId=null&medicineId=null"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case when
     * both 2 request params(appUserId, medicineId) are provided with no values
     * during the get-quantity-in-cart process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getQuantityInCart_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-quantity-in-cart?appUserId=&medicineId="))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case when
     * both 2 request params(appUserId, medicineId) are provided with no equivalent values in DB
     * during the get-quantity-in-cart process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getQuantityInCart_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-quantity-in-cart?appUserId=222&medicineId=777"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case when
     * both 2 request params(appUserId, medicineId) are provided with valid values in DB
     * during the get-quantity-in-cart process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getQuantityInCart_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-quantity-in-cart?appUserId=1&medicineId=1"))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
