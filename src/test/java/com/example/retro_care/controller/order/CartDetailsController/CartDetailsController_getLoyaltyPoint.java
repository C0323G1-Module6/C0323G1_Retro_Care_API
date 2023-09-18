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
public class CartDetailsController_getLoyaltyPoint {

    @Autowired
    private MockMvc mockMvc;

    /**
     * This function is used to test the case when
     *  request param (appUserId) is provided with null value
     * during the get-loyalty-point process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getLoyaltyPoint_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-loyalty-point?appUserId=null"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case when
     *  request param (appUserId) is provided with no value
     * during the get-loyalty-point process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getLoyaltyPoint_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-loyalty-point?appUserId="))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case when
     *  request param (appUserId) is provided with no equivalent value in DB
     * during the get-loyalty-point process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getLoyaltyPoint_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-loyalty-point?appUserId=777"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case when
     *  request param (appUserId) is provided with valid value
     * during the get-loyalty-point process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getLoyaltyPoint_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-loyalty-point?appUserId=1"))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
