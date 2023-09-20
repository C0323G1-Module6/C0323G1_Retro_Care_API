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
public class CartDetailController_getPrescriptionByNameTest {
    @Autowired
    private MockMvc mockMvc;

    /**
     * author: VuNL
     * date: date create
     * function: test the result of prescription by name when name is null
     * @throws Exception
     */
    @Test
    void getPrescriptionsByName_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getPrescriptionByName")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author: VuNL
     * date: date create
     * function: test the result of prescription by name when name is ""
     * @throws Exception
     */
    @Test
    void getPrescriptionsByName_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getPrescriptionByName?name")
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * author: VuNL
     * date: date create
     * function: test the result of prescription by name when name don't exist in database
     * @throws Exception
     */
    @Test
    void getPrescriptionsByName_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getPrescriptionByName?name=abc123")
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * author: VuNL
     * date: date create
     * function: test the result of prescription by name when name is exist in database
     * @throws Exception
     */
    @Test
    void getPrescriptionsByName_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getPrescriptionByName?name=toa")
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
