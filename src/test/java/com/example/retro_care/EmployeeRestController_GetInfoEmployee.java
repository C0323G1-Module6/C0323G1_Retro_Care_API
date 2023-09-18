package com.example.retro_care;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_GetInfoEmployee {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Author:Tan_NV
     * Date: 18/09/2023
     * check id is empty
     * @throws Exception
     */
    @Test
    public void getInfoEmployee_id_1() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/employees/{id}",""))
                        .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:Tan_NV
     * Date: 18/09/2023
     * check id is not found
     * @throws Exception
     */
    @Test
    public void getInfoEmployee_id_2() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employees/{id}","1000000"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author:Tan_NV
     * Date: 18/09/2023
     * check id is ok
     * @throws Exception
     */
    @Test
    public void getInfoEmployee_id_3() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employees/{id}","3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
