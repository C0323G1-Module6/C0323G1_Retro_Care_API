package com.example.retro_care;

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
public class CartDetailController_getAllCartDetailsByUserTest {
    @Autowired
    private MockMvc mockMvc;

    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of cart when user is null
     * @throws Exception
     */
    @Test
    void getAllCartByUserId_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getAllCartDetailsByUser")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of cart when user is ""
     * @throws Exception
     */
    @Test
    void getAllCartByUserId_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getAllCartDetailsByUser?id")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of cart when user is not exist in database
     * @throws Exception
     */
    @Test
    void getAllCartByUserId_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getAllCartDetailsByUser?id=100")
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of cart when user is exist in database
     * @throws Exception
     */
    @Test
    void getAllCartByUserId_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getAllCartDetailsByUser?id=3")
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }




}
