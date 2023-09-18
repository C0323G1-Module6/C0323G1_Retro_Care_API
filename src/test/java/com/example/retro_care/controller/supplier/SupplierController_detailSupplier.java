package com.example.retro_care.controller.supplier;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
public class SupplierController_detailSupplier {
    @Autowired
    private MockMvc mockMvc;

    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id = null
     **/
    @Test
    public void detailSupplier_id_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/detail-supplier/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id = ""
     **/
    @Test
    public void detailSupplier_id_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/detail-supplier/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id not exits
     **/
    @Test
    public void detailSupplier_id_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/detail-supplier/{id}", "10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id is negative
     **/
    @Test
    public void detailSupplier_id_99() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/detail-supplier/{id}", "-1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create:18/09/2023
     * description: test id is not a number
     **/
    @Test
    public void detailSupplier_id_98() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/detail-supplier/{id}", "a"))
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
        this.mockMvc.perform(MockMvcRequestBuilders.get("/detail-supplier/{id}", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create:18/09/2023
     * description: test true
     **/
    @Test
    public void detailSupplier_id_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/supplier/{id}", "1"))
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

    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test list success
     **/
    @Test
    public void detailSupplier_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/supplier/detail-supplier/{id}","2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].codeInvoice").value("HD001"))
                .andExpect(jsonPath("content[0].documentNumber").value("369852"))
                .andExpect(jsonPath("content[0].createDate").value("2023-09-16"))
                .andExpect(jsonPath("content[0].createTime").value("09:26:14"))
                .andExpect(jsonPath("content[0].totalAmount").value("10000.0"))
                .andExpect(jsonPath("content[0].amountDue").value("0.0"))
                .andExpect(jsonPath("content[2].codeInvoice").value("HD003"))
                .andExpect(jsonPath("content[2].documentNumber").value("369844"))
                .andExpect(jsonPath("content[2].createDate").value("2023-09-16"))
                .andExpect(jsonPath("content[2].createTime").value("06:26:14"))
                .andExpect(jsonPath("content[2].totalAmount").value("10000.0"))
                .andExpect(jsonPath("content[2].amountDue").value("0.0"));
    }
}
