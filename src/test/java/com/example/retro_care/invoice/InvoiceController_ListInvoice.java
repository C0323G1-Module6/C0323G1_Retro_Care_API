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
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Page faults are negative numbers
     * @throws Exception
     */
    @Test
    public void getListInvoice_page_3_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/invoice/{page}",-1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Page errors are text
     * @throws Exception
     */
    @Test
    public void getListInvoice_page_0() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/invoice/{page}","abc"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Page number error is null
     * @throws Exception
     */
    @Test
    public void getListInvoice_page_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/invoice/{page}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Page not found error
     * @throws Exception
     */
    @Test
    public void getListInvoice_page_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/invoice/{page}", 1000000000L))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Display success list
     * @throws Exception
     */
    @Test
    public void getListInvoice_page_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/invoice?page=0"))
                .andDo(print())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].id").value(5))
                .andExpect(jsonPath("content[0].code").value("HD005"))
                .andExpect(jsonPath("content[0].documentNumber").value(369855))
                .andExpect(jsonPath("content[0].paid").value(500000))
                .andExpect(jsonPath("content[1].id").value(4))
                .andExpect(jsonPath("content[1].code").value("HD004"))
                .andExpect(jsonPath("content[1].documentNumber").value(369847))
                .andExpect(jsonPath("content[1].paid").value(300000))
                .andExpect(status().is2xxSuccessful());

    }
}
