package com.example.retro_care.controller.order.OrderController;

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
public class OrderController_createOrder {
    @Autowired
    private MockMvc mockMvc;

    /**
     * This function is used to test the case when
     * both 2 request params(appUserId, loyaltyPoint) are provided with null values
     * during the create-order process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void createOrder_13() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        post("/api/orders/create?appUserId=null&loyaltyPoint=null"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case when
     * both 2 request params(appUserId, loyaltyPoint) are provided during the create-order process
     * but with no value for each param.
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void createOrder_14() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        post("/api/orders/create?appUserId=&loyaltyPoint="))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test the case when
     * both 2 request params(appUserId, loyaltyPoint) are provided during the create-order process
     * but in wrong format.
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void createOrder_15() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        post("/api/orders/create?appUserId=abc&loyaltyPoint=xyz"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }


    /**
     * This function is used to test the case when
     * both 2 request params(appUserId, loyaltyPoint) are validly provided during the create-order process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void createOrder_18() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                post("/api/orders/create?appUserId=2&loyaltyPoint=1000"))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
