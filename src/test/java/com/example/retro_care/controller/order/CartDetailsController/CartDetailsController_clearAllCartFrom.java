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
public class CartDetailsController_clearAllCartFrom {

    @Autowired
    private MockMvc mockMvc;

    /**
     * This function is used to test when appUserId is provided
     * with null value during the delete-cart process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void clearAllCartFrom_25() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/carts/delete-all?appUserId=null"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test when appUserId is provided
     * with no value during the delete-cart process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void clearAllCartFrom_26() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/carts/delete-all?appUserId="))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test when appUserId is provided
     * but has no equivalent value on database during the delete-cart process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void clearAllCartFrom_27() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/carts/delete-all?appUserId=777"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to test when appUserId is provided
     * but has no equivalent value on database during the delete-cart process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void clearAllCartFrom_28() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/carts/delete-all?appUserId=1"))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
