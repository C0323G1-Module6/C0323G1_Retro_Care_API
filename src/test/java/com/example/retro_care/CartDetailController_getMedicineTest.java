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
public class CartDetailController_getMedicineTest {
    @Autowired
    private MockMvc mockMvc;

    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of medicine when name is null
     * @throws Exception
     */
    @Test
    void getMedicine_1() throws Exception{
         this.mockMvc.perform(
                 MockMvcRequestBuilders.get("/api/carts/getMedicine")
         ).andDo(print())
                 .andExpect(status().is4xxClientError());
    }

    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of medicine when name is ""
     * @throws Exception
     */
    @Test
    void getMedicine_2() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getMedicine?name")
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of medicine when name don't exist in database
     * @throws Exception
     */
    @Test
    void getMedicine_3() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getMedicine?name=abc123")
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * author: VuNL
     * date: 18/09/2023
     * function: test the result of medicine when name  exist in database
     * @throws Exception
     */
    @Test
    void getMedicine_4() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/carts/getMedicine?name=thuoc")
                ).andDo(print())
                .andExpect(status().is2xxSuccessful() );
    }


}
