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
public class CartDetailsController_clearACartFrom {
    @Autowired
    private MockMvc mockMvc;

    /**
     * This function is used to test when cartId is provided
     * with null value during the delete-cart process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void clearACartFrom_25() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/carts/delete-cart?cartId=null"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test when cartId is provided
     * with no value during the delete-cart process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void clearACartFrom_26() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/carts/delete-cart?cartId="))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test when cartId is provided
     * with no equivalent value in database during the delete-cart process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void clearACartFrom_27() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/carts/delete-cart?cartId=777"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test when cartId is provided
     * with valid value in database during the delete-cart process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void clearACartFrom_28() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/carts/delete-cart?cartId=84"))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }

}
