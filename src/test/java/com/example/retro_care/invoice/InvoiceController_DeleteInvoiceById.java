package com.example.retro_care.invoice;

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
public class InvoiceController_DeleteInvoiceById {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Test case to delete an existing invoice by ID = null.
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void delete_invoice_25() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/invoice/delete/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Test case to delete an existing invoice by ID = "".
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void delete_invoice_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/invoice/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Test case to delete an existing invoice by ID no cos in data
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void delete_invoice_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/invoice/delete/{id}", 200))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Function: Test case for deleting an existing invoice by ID.
     * @throws Exception if an error occurs during the test
     */

    @Test
    public void delete_invoice_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/invoice/delete/{id}", 2))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
