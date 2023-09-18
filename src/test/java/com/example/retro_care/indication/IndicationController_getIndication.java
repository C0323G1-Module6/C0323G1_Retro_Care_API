package com.example.retro_care.indication;

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
public class IndicationController_getIndication {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getIndication_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/indication/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError()
        );
    }

    @Test
    public void getIndication_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/indication/{id}",30))
                .andDo(print())
                .andExpect(status().is(204)
                );
    }

    @Test
    public void getIndication_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/indication/{id}",1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()
                );
    }
}
