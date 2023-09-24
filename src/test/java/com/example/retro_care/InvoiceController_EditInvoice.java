//package com.example.retro_care;
//
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import com.example.retro_care.invoice.model.InvoiceDto;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.Date;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class InvoiceController_EditInvoice {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    /**
//     * input invoiceDto is null
//     * Code by CuongHLT
//     * @throws Exception
//     */
//    @Test
//    public void editInvoice_19() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .patch("/api/invoice/edit")
//                                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * input code is ""
//     * Code by CuongHLT
//     * @throws Exception
//     */
//    @Test
//    public void editInvoice_code_20() throws Exception {
////        edit invoiceDto and set base info
//        InvoiceDto invoiceDto = new InvoiceDto();
//        invoiceDto.setId(10L);
//        invoiceDto.setCode("");
//        invoiceDto.setDocumentNumber("9386482");
//        invoiceDto.setNote("Sản phẩm OK ok");
//        invoiceDto.setPaid(1D);
//        invoiceDto.setFlagDeleted(false);
//        invoiceDto.setCreationDate(new Date());
////        edit and set Supplier
//        invoiceDto.setSupplierId(1L);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .patch("/api/invoice/edit")
//                                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * input code is null
//     * Code by CuongHLT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void editInvoice_code_19() throws Exception {
////        edit invoiceDto and set base info
//        InvoiceDto invoiceDto = new InvoiceDto();
//        invoiceDto.setId(10L);
//        invoiceDto.setCode("HDN00011");
//        invoiceDto.setDocumentNumber("9386482");
//        invoiceDto.setNote("Sản phẩm OK ok");
//        invoiceDto.setPaid(1D);
//        invoiceDto.setFlagDeleted(false);
//        invoiceDto.setCreationDate(new Date());
////        edit and set Supplier
//        invoiceDto.setSupplierId(1L);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .patch("/api/invoice/edit")
//                                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * input document is ""
//     * Code by CuongHLT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void editInvoice_documentNumber_20() throws Exception {
////        edit invoiceDto and set base info
//        InvoiceDto invoiceDto = new InvoiceDto();
//        invoiceDto.setId(10L);
//        invoiceDto.setCode("HDN00011");
//        invoiceDto.setNote("Sản phẩm OK ok");
//        invoiceDto.setPaid(1D);
//        invoiceDto.setFlagDeleted(false);
//        invoiceDto.setCreationDate(new Date());
////        edit and set Supplier
//        invoiceDto.setSupplierId(1L);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .patch("/api/invoice/edit")
//                                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * input DocumentNumber is too long
//     * Code by CuongHLT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void editInvoice_documentNumber_23() throws Exception {
////        edit invoiceDto and set base info
//        InvoiceDto invoiceDto = new InvoiceDto();
//        invoiceDto.setId(10L);
//        invoiceDto.setCode("HDN00011");
//        invoiceDto.setDocumentNumber("938");
//        invoiceDto.setNote("Sản phẩm OK ok");
//        invoiceDto.setPaid(1D);
//        invoiceDto.setFlagDeleted(false);
//        invoiceDto.setCreationDate(new Date());
////        edit and set Supplier
//        invoiceDto.setSupplierId(1L);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .patch("/api/invoice/edit")
//                                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * input DocumentNumber lenght is too short
//     * Code by CuongHLT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void editInvoice_documentNumber_22() throws Exception {
////        edit invoiceDto and set base info
//        InvoiceDto invoiceDto = new InvoiceDto();
//        invoiceDto.setId(10L);
//        invoiceDto.setCode("HDN00011");
//        invoiceDto.setDocumentNumber("93864829386482938648293864829386482938648293864829386482938648293864829386482938648293864829386482938648293864829386482938648293864829386482938648293864829386482938648293864829386482938648293864829386482");
//        invoiceDto.setNote("Sản phẩm OK ok");
//        invoiceDto.setPaid(1D);
//        invoiceDto.setFlagDeleted(false);
//        invoiceDto.setCreationDate(new Date());
////        edit and set Supplier
//        invoiceDto.setSupplierId(1L);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .patch("/api/invoice/edit")
//                                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * input paid is null
//     * Code by CuongHLT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void editInvoice_paid_19() throws Exception {
////        edit invoiceDto and set base info
//        InvoiceDto invoiceDto = new InvoiceDto();
//        invoiceDto.setId(10L);
//        invoiceDto.setCode("HDN00011");
//        invoiceDto.setDocumentNumber("9386482");
//        invoiceDto.setNote("Sản phẩm OK ok");
//        invoiceDto.setFlagDeleted(false);
//        invoiceDto.setCreationDate(new Date());
////        edit and set Supplier
//        invoiceDto.setSupplierId(1L);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .patch("/api/invoice/edit")
//                                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * input paid is < 0
//     * Code by CuongHLT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void editInvoice_paid_22() throws Exception {
////        edit invoiceDto and set base info
//        InvoiceDto invoiceDto = new InvoiceDto();
//        invoiceDto.setId(10L);
//        invoiceDto.setCode("HDN00011");
//        invoiceDto.setDocumentNumber("9386482");
//        invoiceDto.setNote("Sản phẩm OK ok");
//        invoiceDto.setPaid(-1D);
//        invoiceDto.setFlagDeleted(false);
//        invoiceDto.setCreationDate(new Date());
////        edit and set Supplier
//        invoiceDto.setSupplierId(1L);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .patch("/api/invoice/edit")
//                                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//     * input paid is too big
//     * Code by CuongHLT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void editInvoice_paid_23() throws Exception {
////        edit invoiceDto and set base info
//        InvoiceDto invoiceDto = new InvoiceDto();
//        invoiceDto.setId(10L);
//        invoiceDto.setCode("HDN00011");
//        invoiceDto.setDocumentNumber("9386482");
//        invoiceDto.setNote("Sản phẩm OK ok");
//        invoiceDto.setPaid(Double.MAX_VALUE);
//        invoiceDto.setFlagDeleted(false);
//        invoiceDto.setCreationDate(new Date());
////        edit and set Supplier
//        invoiceDto.setSupplierId(1L);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .patch("/api/invoice/edit")
//                                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * input flagDeleted is null
//     * Code by CuongHLT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void editInvoice_flagDeleted_19() throws Exception {
////        edit invoiceDto and set base info
//        InvoiceDto invoiceDto = new InvoiceDto();
//        invoiceDto.setId(10L);
//        invoiceDto.setCode("HDN00011");
//        invoiceDto.setDocumentNumber("9386482");
//        invoiceDto.setNote("Sản phẩm OK ok");
//        invoiceDto.setPaid(1D);
//        invoiceDto.setCreationDate(new Date());
////        edit and set Supplier
//        invoiceDto.setSupplierId(1L);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .patch("/api/invoice/edit")
//                                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * input supplierId is null
//     * Code by CuongHLT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void editInvoice_supplierId_19() throws Exception {
////        edit invoiceDto and set base info
//        InvoiceDto invoiceDto = new InvoiceDto();
//        invoiceDto.setId(10L);
//        invoiceDto.setCode("HDN00011");
//        invoiceDto.setDocumentNumber("9386482");
//        invoiceDto.setNote("Sản phẩm OK ok");
//        invoiceDto.setPaid(1D);
//        invoiceDto.setFlagDeleted(false);
//        invoiceDto.setCreationDate(new Date());
////        edit and set Supplier
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .patch("/api/invoice/edit")
//                                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//     * input success data for edit
//     * Code by CuongHLT
//     *
//     * @throws Exception
//     */
//    @Test
//    public void editInvoice_24() throws Exception {
////        edit invoiceDto and set base info
//        InvoiceDto invoiceDto = new InvoiceDto();
//        invoiceDto.setId(10L);
//        invoiceDto.setCode("HDN00011");
//        invoiceDto.setDocumentNumber("9386482");
//        invoiceDto.setNote("Sản phẩm OK ok");
//        invoiceDto.setPaid(1D);
//        invoiceDto.setFlagDeleted(false);
//        invoiceDto.setCreationDate(new Date());
////        edit and set Supplier
//        invoiceDto.setSupplierId(1L);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .patch("/api/invoice/edit")
//                                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}
