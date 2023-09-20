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
public class SupplierController_getSupplierById {
    @Autowired
    private MockMvc mockMvc;
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id = null
     **/
    @Test
    public void getSupplierById_id_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/supplier/get/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id = ""
     **/
    @Test
    public void getSupplierById_id_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/supplier/get/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id not exits
     **/
    @Test
    public void getSupplierById_id_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/supplier/get/{id}", "100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id is negative
     **/
    @Test
    public void getSupplierById_id_99() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/supplier/get/{id}", "-1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create:18/09/2023
     * description: test id is not a number
     **/
    @Test
    public void getSupplierById_id_98() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/supplier/get/{id}", "a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id is 0
     **/
    @Test
    public void getSupplierById_id_97() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/supplier/get/{id}", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create:18/09/2023
     * description: test true
     **/
    @Test
    public void getSupplierById_id_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/supplier/get/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("address").value("143 Hải Phòng,Đà Nẵng"))
                .andExpect(jsonPath("code").value("NUTINE"))
                .andExpect(jsonPath("email").value("nutine@gmail.com"))
                .andExpect(jsonPath("flagDeleted").value("false"))
                .andExpect(jsonPath("name").value("Dược Phẩm Nutine"))
                .andExpect(jsonPath("note").value("Chưa thanh toán nợ"))
                .andExpect(jsonPath("phoneNumber").value("0908223242"));
    }
}
