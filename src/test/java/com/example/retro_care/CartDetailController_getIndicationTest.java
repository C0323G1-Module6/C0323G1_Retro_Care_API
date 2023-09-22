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
public class CartDetailController_getIndicationTest {
    @Autowired
    private MockMvc mockMvc;


    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of indication when prescription id is null
     * @throws Exception
     */
    @Test
    void getIndication_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getIndication")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of indication when prescription is ""
     * @throws Exception
     */
    @Test
    void getIndication_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getIndication?id")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of indication when prescription do not exist in database
     * @throws Exception
     */
    @Test
    void getIndication_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getIndication?id=1000")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of indication when prescription exist in database
     * @throws Exception
     */
    @Test
    void getIndication_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getIndication?id=1")
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
