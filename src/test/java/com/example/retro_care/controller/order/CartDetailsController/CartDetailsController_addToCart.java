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
public class CartDetailsController_addToCart {

    @Autowired
    private MockMvc mockMvc;

    /**
     * This function is used to test the case in cart screen when
     * all 3 request params(appUserId, medicineId, and newQuantity) are provided
     * with all null values during the add-to-cart process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void addToCart_13() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/carts/add-from-cart?appUserId=null&medicineId=null&quantity=null"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case in cart screen when
     * all 3 request params(appUserId, medicineId, and newQuantity) are provided during the add-to-cart process
     * but with no value for each param.
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void addToCart_14() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/carts/add-from-cart?appUserId=&medicineId=&quantity="))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case in cart screen when
     * all 3 request params(appUserId, medicineId, and quantity) are provided during the add-to-cart process
     * but in wrong format.
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void addToCart_15() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/carts/add-from-cart?appUserId=abc&medicineId=xyz&quantity=oxy"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case in cart screen when
     * all 3 request params(appUserId, medicineId, and quantity) are validly provided during the add-to-cart process.
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void addToCart_18() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/carts/add-from-cart?appUserId=2&medicineId=1&quantity=1"))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
