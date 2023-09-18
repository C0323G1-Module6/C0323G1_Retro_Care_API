package com.example.retro_care;

import com.example.retro_care.invoice.model.InvoiceDetail;
import com.example.retro_care.invoice.model.InvoiceDto;
import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.supplier.model.Supplier;
import com.example.retro_care.user.model.AppUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceController_CreateInvoice {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * input invoiceDto is null
     * Code by CuongHLT
     * @throws Exception
     */
    @Test
    public void createInvoice_13() throws Exception {
        InvoiceDto invoiceDto = new InvoiceDto();
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * input code is ""
     * Code by CuongHLT
     * @throws Exception
     */
    @Test
    public void createInvoice_code_14() throws Exception {
//        create invoiceDto and set base info
        InvoiceDto invoiceDto = new InvoiceDto();
//        Code wrong format
        invoiceDto.setCode("");
        invoiceDto.setDocumentNumber("9386482");
        invoiceDto.setNote("Sản phẩm OK");
        invoiceDto.setPaid(0D);
        invoiceDto.setFlagDeleted(false);
        invoiceDto.setAppUserId(new AppUser());
        invoiceDto.setSupplierId(new Supplier());
//        create set of invoiceDetail and add
        Set<InvoiceDetail> invoiceDetailSet = new HashSet<>();
//        create medicine
        Medicine medicine1 = new Medicine();
        medicine1.setId(1L);
        Medicine medicine2 = new Medicine();
        medicine2.setId(2L);
        invoiceDetailSet.add(new InvoiceDetail(3.4F, null, 100, "231212", false, medicine1));
        invoiceDetailSet.add(new InvoiceDetail(3.5F, null, 100, "240101", false, medicine2));
//        set invoiceDetailSet
        invoiceDto.setInvoiceDetailSet(invoiceDetailSet);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * input code is null
     * Code by CuongHLT
     * @throws Exception
     */
    @Test
    public void createInvoice_code_15() throws Exception {
//        create invoiceDto and set base info
        InvoiceDto invoiceDto = new InvoiceDto();
//        Code wrong format
        invoiceDto.setCode("HD00009");
        invoiceDto.setDocumentNumber("9386482");
        invoiceDto.setNote("Sản phẩm OK");
        invoiceDto.setPaid(0D);
        invoiceDto.setFlagDeleted(false);
        invoiceDto.setAppUserId(new AppUser());
        invoiceDto.setSupplierId(new Supplier());
//        create set of invoiceDetail and add
        Set<InvoiceDetail> invoiceDetailSet = new HashSet<>();
//        create medicine
        Medicine medicine1 = new Medicine();
        medicine1.setId(1L);
        Medicine medicine2 = new Medicine();
        medicine2.setId(2L);
        invoiceDetailSet.add(new InvoiceDetail(3.4F, null, 100, "231212", false, medicine1));
        invoiceDetailSet.add(new InvoiceDetail(3.5F, null, 100, "240101", false, medicine2));
//        set invoiceDetailSet
        invoiceDto.setInvoiceDetailSet(invoiceDetailSet);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * input document is ""
     * Code by CuongHLT
     * @throws Exception
     */
    @Test
    public void createInvoice_documentNumber_14() throws Exception {
//        create invoiceDto and set base info
        InvoiceDto invoiceDto = new InvoiceDto();
//        Code wrong format
        invoiceDto.setCode("HDN00009");
        invoiceDto.setDocumentNumber("");
        invoiceDto.setNote("Sản phẩm OK");
        invoiceDto.setPaid(0D);
        invoiceDto.setFlagDeleted(false);
        invoiceDto.setAppUserId(new AppUser());
        invoiceDto.setSupplierId(new Supplier());
//        create set of invoiceDetail and add
        Set<InvoiceDetail> invoiceDetailSet = new HashSet<>();
//        create medicine
        Medicine medicine1 = new Medicine();
        medicine1.setId(1L);
        Medicine medicine2 = new Medicine();
        medicine2.setId(2L);
        invoiceDetailSet.add(new InvoiceDetail(3.4F, null, 100, "231212", false, medicine1));
        invoiceDetailSet.add(new InvoiceDetail(3.5F, null, 100, "240101", false, medicine2));
//        set invoiceDetailSet
        invoiceDto.setInvoiceDetailSet(invoiceDetailSet);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * input DocumentNumber is too long
     * Code by CuongHLT
     * @throws Exception
     */
    @Test
    public void createInvoice_documentNumber_16() throws Exception {
//        create invoiceDto and set base info
        InvoiceDto invoiceDto = new InvoiceDto();
//        Code wrong format
        invoiceDto.setCode("HDN00009");
        invoiceDto.setDocumentNumber("9386482938648293864829386482938648293864829386482938648293864829386482938648293864829386482938648293864829386482938648293864829386482938648293864829386482938648293864829386482938648293864829386482938648293864829386482");
        invoiceDto.setNote("Sản phẩm OK");
        invoiceDto.setPaid(0D);
        invoiceDto.setFlagDeleted(false);
        invoiceDto.setAppUserId(new AppUser());
        invoiceDto.setSupplierId(new Supplier());
//        create set of invoiceDetail and add
        Set<InvoiceDetail> invoiceDetailSet = new HashSet<>();
//        create medicine
        Medicine medicine1 = new Medicine();
        medicine1.setId(1L);
        Medicine medicine2 = new Medicine();
        medicine2.setId(2L);
        invoiceDetailSet.add(new InvoiceDetail(3.4F, null, 100, "231212", false, medicine1));
        invoiceDetailSet.add(new InvoiceDetail(3.5F, null, 100, "240101", false, medicine2));
//        set invoiceDetailSet
        invoiceDto.setInvoiceDetailSet(invoiceDetailSet);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * input DocumentNumber lenght is too short
     * Code by CuongHLT
     * @throws Exception
     */
    @Test
    public void createInvoice_documentNumber_17() throws Exception {
//        create invoiceDto and set base info
        InvoiceDto invoiceDto = new InvoiceDto();
//        Code wrong format
        invoiceDto.setCode("HDN00009");
        invoiceDto.setDocumentNumber("6482");
        invoiceDto.setNote("Sản phẩm OK");
        invoiceDto.setPaid(0D);
        invoiceDto.setFlagDeleted(false);
        invoiceDto.setAppUserId(new AppUser());
        invoiceDto.setSupplierId(new Supplier());
//        create set of invoiceDetail and add
        Set<InvoiceDetail> invoiceDetailSet = new HashSet<>();
//        create medicine
        Medicine medicine1 = new Medicine();
        medicine1.setId(1L);
        Medicine medicine2 = new Medicine();
        medicine2.setId(2L);
        invoiceDetailSet.add(new InvoiceDetail(3.4F, null, 100, "231212", false, medicine1));
        invoiceDetailSet.add(new InvoiceDetail(3.5F, null, 100, "240101", false, medicine2));
//        set invoiceDetailSet
        invoiceDto.setInvoiceDetailSet(invoiceDetailSet);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * input paid is null
     * Code by CuongHLT
     * @throws Exception
     */
    @Test
    public void createInvoice_paid_13() throws Exception {
//        create invoiceDto and set base info
        InvoiceDto invoiceDto = new InvoiceDto();
//        Code wrong format
        invoiceDto.setCode("HDN00009");
        invoiceDto.setDocumentNumber("6482");
        invoiceDto.setNote("Sản phẩm OK");
        invoiceDto.setFlagDeleted(false);
        invoiceDto.setAppUserId(new AppUser());
        invoiceDto.setSupplierId(new Supplier());
//        create set of invoiceDetail and add
        Set<InvoiceDetail> invoiceDetailSet = new HashSet<>();
//        create medicine
        Medicine medicine1 = new Medicine();
        medicine1.setId(1L);
        Medicine medicine2 = new Medicine();
        medicine2.setId(2L);
        invoiceDetailSet.add(new InvoiceDetail(3.4F, null, 100, "231212", false, medicine1));
        invoiceDetailSet.add(new InvoiceDetail(3.5F, null, 100, "240101", false, medicine2));
//        set invoiceDetailSet
        invoiceDto.setInvoiceDetailSet(invoiceDetailSet);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * input paid is null
     * Code by CuongHLT
     * @throws Exception
     */
    @Test
    public void createInvoice_paid_14() throws Exception {
//        create invoiceDto and set base info
        InvoiceDto invoiceDto = new InvoiceDto();
//        Code wrong format
        invoiceDto.setCode("HDN00009");
        invoiceDto.setDocumentNumber("6482");
        invoiceDto.setNote("Sản phẩm OK");
        invoiceDto.setFlagDeleted(false);
        invoiceDto.setAppUserId(new AppUser());
        invoiceDto.setSupplierId(new Supplier());
//        create set of invoiceDetail and add
        Set<InvoiceDetail> invoiceDetailSet = new HashSet<>();
//        create medicine
        Medicine medicine1 = new Medicine();
        medicine1.setId(1L);
        Medicine medicine2 = new Medicine();
        medicine2.setId(2L);
        invoiceDetailSet.add(new InvoiceDetail(3.4F, null, 100, "231212", false, medicine1));
        invoiceDetailSet.add(new InvoiceDetail(3.5F, null, 100, "240101", false, medicine2));
//        set invoiceDetailSet
        invoiceDto.setInvoiceDetailSet(invoiceDetailSet);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * input DocumentNumber is < 0
     * Code by CuongHLT
     * @throws Exception
     */
    @Test
    public void createInvoice_paid_16() throws Exception {
//        create invoiceDto and set base info
        InvoiceDto invoiceDto = new InvoiceDto();
//        Code wrong format
        invoiceDto.setCode("HDN00009");
        invoiceDto.setDocumentNumber("6482");
        invoiceDto.setPaid(-1D);
        invoiceDto.setNote("Sản phẩm OK");
        invoiceDto.setFlagDeleted(false);
        invoiceDto.setAppUserId(new AppUser());
        invoiceDto.setSupplierId(new Supplier());
//        create set of invoiceDetail and add
        Set<InvoiceDetail> invoiceDetailSet = new HashSet<>();
//        create medicine
        Medicine medicine1 = new Medicine();
        medicine1.setId(1L);
        Medicine medicine2 = new Medicine();
        medicine2.setId(2L);
        invoiceDetailSet.add(new InvoiceDetail(3.4F, null, 100, "231212", false, medicine1));
        invoiceDetailSet.add(new InvoiceDetail(3.5F, null, 100, "240101", false, medicine2));
//        set invoiceDetailSet
        invoiceDto.setInvoiceDetailSet(invoiceDetailSet);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * input paid is too big
     * Code by CuongHLT
     * @throws Exception
     */
    @Test
    public void createInvoice_paid_17() throws Exception {
//        create invoiceDto and set base info
        InvoiceDto invoiceDto = new InvoiceDto();
//        Code wrong format
        invoiceDto.setCode("HDN00009");
        invoiceDto.setDocumentNumber("6482");
        invoiceDto.setPaid(Double.MAX_VALUE);
        invoiceDto.setNote("Sản phẩm OK");
        invoiceDto.setFlagDeleted(false);
        invoiceDto.setAppUserId(new AppUser());
        invoiceDto.setSupplierId(new Supplier());
//        create set of invoiceDetail and add
        Set<InvoiceDetail> invoiceDetailSet = new HashSet<>();
//        create medicine
        Medicine medicine1 = new Medicine();
        medicine1.setId(1L);
        Medicine medicine2 = new Medicine();
        medicine2.setId(2L);
        invoiceDetailSet.add(new InvoiceDetail(3.4F, null, 100, "231212", false, medicine1));
        invoiceDetailSet.add(new InvoiceDetail(3.5F, null, 100, "240101", false, medicine2));
//        set invoiceDetailSet
        invoiceDto.setInvoiceDetailSet(invoiceDetailSet);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * input flagDeleted is null
     * Code by CuongHLT
     * @throws Exception
     */
    @Test
    public void createInvoice_flagDeleted_13() throws Exception {
//        create invoiceDto and set base info
        InvoiceDto invoiceDto = new InvoiceDto();
//        Code wrong format
        invoiceDto.setCode("HDN00009");
        invoiceDto.setDocumentNumber("6482");
        invoiceDto.setPaid(0D);
        invoiceDto.setNote("Sản phẩm OK");
        invoiceDto.setAppUserId(new AppUser());
        invoiceDto.setSupplierId(new Supplier());
//        create set of invoiceDetail and add
        Set<InvoiceDetail> invoiceDetailSet = new HashSet<>();
//        create medicine
        Medicine medicine1 = new Medicine();
        medicine1.setId(1L);
        Medicine medicine2 = new Medicine();
        medicine2.setId(2L);
        invoiceDetailSet.add(new InvoiceDetail(3.4F, null, 100, "231212", false, medicine1));
        invoiceDetailSet.add(new InvoiceDetail(3.5F, null, 100, "240101", false, medicine2));
//        set invoiceDetailSet
        invoiceDto.setInvoiceDetailSet(invoiceDetailSet);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * input appUserId is null
     * Code by CuongHLT
     * @throws Exception
     */
    @Test
    public void createInvoice_appUserId_13() throws Exception {
//        create invoiceDto and set base info
        InvoiceDto invoiceDto = new InvoiceDto();
//        Code wrong format
        invoiceDto.setCode("HDN00009");
        invoiceDto.setDocumentNumber("6482");
        invoiceDto.setPaid(0D);
        invoiceDto.setNote("Sản phẩm OK");
        invoiceDto.setFlagDeleted(false);
        invoiceDto.setSupplierId(new Supplier());
//        create set of invoiceDetail and add
        Set<InvoiceDetail> invoiceDetailSet = new HashSet<>();
//        create medicine
        Medicine medicine1 = new Medicine();
        medicine1.setId(1L);
        Medicine medicine2 = new Medicine();
        medicine2.setId(2L);
        invoiceDetailSet.add(new InvoiceDetail(3.4F, null, 100, "231212", false, medicine1));
        invoiceDetailSet.add(new InvoiceDetail(3.5F, null, 100, "240101", false, medicine2));
//        set invoiceDetailSet
        invoiceDto.setInvoiceDetailSet(invoiceDetailSet);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * input supplierId is null
     * Code by CuongHLT
     * @throws Exception
     */
    @Test
    public void createInvoice_supplierId_13() throws Exception {
//        create invoiceDto and set base info
        InvoiceDto invoiceDto = new InvoiceDto();
//        Code wrong format
        invoiceDto.setCode("HDN00009");
        invoiceDto.setDocumentNumber("6482");
        invoiceDto.setPaid(0D);
        invoiceDto.setNote("Sản phẩm OK");
        invoiceDto.setFlagDeleted(false);
        invoiceDto.setAppUserId(new AppUser());
//        create set of invoiceDetail and add
        Set<InvoiceDetail> invoiceDetailSet = new HashSet<>();
//        create medicine
        Medicine medicine1 = new Medicine();
        medicine1.setId(1L);
        Medicine medicine2 = new Medicine();
        medicine2.setId(2L);
        invoiceDetailSet.add(new InvoiceDetail(3.4F, null, 100, "231212", false, medicine1));
        invoiceDetailSet.add(new InvoiceDetail(3.5F, null, 100, "240101", false, medicine2));
//        set invoiceDetailSet
        invoiceDto.setInvoiceDetailSet(invoiceDetailSet);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * input invoiceDetailSet is null
     * Code by CuongHLT
     * @throws Exception
     */

    @Test
    public void createInvoice_invoiceDetailSet_14() throws Exception {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setCode("HDN00009");
        invoiceDto.setDocumentNumber("9386482");
        invoiceDto.setNote("Sản phẩm OK");
        invoiceDto.setPaid(0D);
        invoiceDto.setFlagDeleted(false);
        invoiceDto.setAppUserId(new AppUser());
        invoiceDto.setSupplierId(new Supplier());
        invoiceDto.setInvoiceDetailSet(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * input invoiceDetailSet of discount is minus
     * Code by CuongHLT
     * @throws Exception
     */

    @Test
    public void createInvoice_invoiceDetailSet_discount_15() throws Exception {
//        create invoiceDto and set base info
        InvoiceDto invoiceDto = new InvoiceDto();
//        Code wrong format
        invoiceDto.setCode("HDN00009");
        invoiceDto.setDocumentNumber("9386482");
        invoiceDto.setNote("Sản phẩm OK");
        invoiceDto.setPaid(0D);
        invoiceDto.setCreationDate(null);
        invoiceDto.setFlagDeleted(false);
        invoiceDto.setAppUserId(new AppUser());
        invoiceDto.setSupplierId(new Supplier());
//        create set of invoiceDetail and add
        Set<InvoiceDetail> invoiceDetailSet = new HashSet<>();
//        create medicine
        Medicine medicine1 = new Medicine();
        medicine1.setId(1L);
        Medicine medicine2 = new Medicine();
        medicine2.setId(2L);
        invoiceDetailSet.add(new InvoiceDetail(-3.4F, null, 100, "231212", false, medicine1));
        invoiceDetailSet.add(new InvoiceDetail(3.5F, null, 100, "240101", false, medicine2));
//        set invoiceDetailSet
        invoiceDto.setInvoiceDetailSet(invoiceDetailSet);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * input success data for create
     * Code by CuongHLT
     * @throws Exception
     */
    @Test
    public void createInvoice_18() throws Exception {
//        create invoiceDto and set base info
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setCode("HDN00009");
        invoiceDto.setDocumentNumber("9386482");
        invoiceDto.setNote("Sản phẩm OK");
        invoiceDto.setPaid(1D);
        invoiceDto.setFlagDeleted(false);
        invoiceDto.setCreationDate(new Date());

//        create and set App user
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        invoiceDto.setAppUserId(appUser);

//        create and set Supplier
        Supplier supplier = new Supplier();
        supplier.setId(1L);
        invoiceDto.setSupplierId(supplier);
//        create set of invoiceDetail and add
        Set<InvoiceDetail> invoiceDetails = new HashSet<>();
//        create medicine
        Medicine medicine1 = new Medicine();
        medicine1.setId(1L);
        Medicine medicine2 = new Medicine();
        medicine2.setId(2L);
        invoiceDetails.add(new InvoiceDetail(3.4F, new Date(), 100, "231212", false, medicine1, null));
        invoiceDetails.add(new InvoiceDetail(3.5F, new Date(), 100, "240101", false, medicine2, null));
//        set invoiceDetailSet
        invoiceDto.setInvoiceDetailSet(invoiceDetails);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/invoice/create")
                                .content(this.objectMapper.writeValueAsString(invoiceDto))
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
