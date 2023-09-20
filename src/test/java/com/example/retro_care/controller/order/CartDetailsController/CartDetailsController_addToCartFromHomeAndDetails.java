package com.example.retro_care.controller.order.CartDetailsController;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class CartDetailsController_addToCartFromHomeAndDetails {
    @Autowired
    private MockMvc mockMvc;


    /**
     * This function is used to test the case in home/details screen when
     * all 3 request params(appUserId, medicineId, and newQuantity) are provided
     * with all null values during the add-to-cart process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void addToCartFromHomeAndDetails_13() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/carts/add-from-home-details?appUserId=null&medicineId=null&newQuantity=null"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case in home/details screen when
     * all 3 request params(appUserId, medicineId, and newQuantity) are provided during the add-to-cart process
     * but with no value for each param.
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void addToCartFromHomeAndDetails_14() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/carts/add-from-home-details?appUserId=&medicineId=&newQuantity="))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case in home/details screen when
     * all 3 request params(appUserId, medicineId, and newQuantity) are provided during the add-to-cart process
     * but in wrong format.
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void addToCartFromHomeAndDetails_15() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/carts/add-from-home-details?appUserId=abc&medicineId=xyz&newQuantity=oxy"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case in home/details screen when
     * all 3 request params(appUserId, medicineId, and newQuantity) are validly provided during the add-to-cart process.
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void addToCartFromHomeAndDetails_18() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/carts/add-from-home-details?appUserId=2&medicineId=1&newQuantity=1"))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }


}
