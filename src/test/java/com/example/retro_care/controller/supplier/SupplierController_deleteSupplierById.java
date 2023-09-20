package com.example.retro_care.controller.supplier;
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
public class SupplierController_deleteSupplierById {
    @Autowired
    private MockMvc mockMvc;
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id = null
     **/
    @Test
    public void deleteSupplierById_id_25() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/supplier/delete/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void deleteSupplierById_id_26() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/supplier/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id not exits
     **/
    @Test
    public void deleteSupplierById_id_27() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/supplier/delete/{id}", "100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id is negative
     **/
    @Test
    public void deleteSupplierById_id_99() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/supplier/delete/{id}", "-1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create:18/09/2023
     * description: test id is not a number
     **/
    @Test
    public void deleteSupplierById_id_98() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/supplier/delete/{id}", "a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id is 0
     **/
    @Test
    public void deleteSupplierById_id_97() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/supplier/delete/{id}", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create:18/09/2023
     * description: test true
     **/
    @Test
    public void deleteSupplierById_id_28() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/supplier/delete/{id}", "4"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
