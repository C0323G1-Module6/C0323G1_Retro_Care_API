package com.example.retro_care.invoice;

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
public class InvoiceController_ListInvoice {
    @Autowired
    private MockMvc mockMvc;

    /**
     *
     * @throws Exception
     */
    @Test
    public void getListInvoice_page_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/invoice/{page}",-1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getListInvoice_page_0() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/invoice/{page}","abc"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListInvoice_page_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/invoice/{page}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListInvoice_page_35() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/invoice/{page}", 1000000000L))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     *
     * @throws Exception
     */
    @Test
    public void getListInvoice_page_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/invoice?page=0"))
                .andDo(print())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].code").value("HD001"))
                .andExpect(jsonPath("content[0].documentNumber").value(369852))
                .andExpect(jsonPath("content[1].id").value(2))
                .andExpect(jsonPath("content[1].code").value("HD002"))
                .andExpect(jsonPath("content[1].documentNumber").value(369853))
                .andExpect(status().is2xxSuccessful());

    }
}
