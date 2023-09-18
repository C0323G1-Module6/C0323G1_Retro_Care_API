package com.example.retro_care.employeeController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_DeleteEmployee {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Author: SonTT
     * Date create: 18/09/2023
     * Handling: Input 1 null media type to the path
     * @throws Exception
     */
    @Test
    public void deleteEmployee_25() throws Exception {
            this.mockMvc.perform(
                            MockMvcRequestBuilders
                                    .delete("/employees/delete-employee"))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
    }

    /**
     * Author: SonTT
     * Date create: 18/09/2023
     * Handling: Input 1 "" media type to the path
     * @throws Exception
     */
    @Test
    public void deleteEmployee_26() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/employees/delete-employee").param("id",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: SonTT
     * Date create: 18/09/2023
     * Handling: Input 1 "120" media type to the path
     * @throws Exception
     */
    @Test
    public void deleteEmployee_27() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/employees/delete-employee").param("id","120"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: SonTT
     * Date create: 18/09/2023
     * Handling: Enter id with an  value in database , media type the path
     * @throws Exception
     */
    @Test
    public void deleteEmployee_28() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/employees/delete-employee").param("id", String.valueOf(9)).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
