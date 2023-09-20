package com.example.retro_care.controller.supplier;
import com.example.retro_care.supplier.dto.SupplierDto;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class SupplierController_updateSupplierById {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    /**
     * this function use to test the validation of field name more specific is null
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_name_19() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setAddress("33 Yên Khê,Đà Nẵng");
        supplierDto.setCode("BlUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field name more specific is empty
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_name_20() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BlUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field name more specific is wrong format
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_name_21() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("adadad");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BlUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field name more specific is minlength
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_name_22() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("a");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BlUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field name more specific is max length
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_name_23() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("adadadadvadadadadadadadadadadadadadadadadadadadadadadadadadadadadadadadadadad" +
                "adadadadadadadadadadadadadadadadadadadadadadadadadad");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BlUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field code more specific is null
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_code_19() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field code more specific is empty
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_code_20() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field code more specific is wrong format
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_code_21() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("blue");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field code more specific is minlength
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_code_22() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("bl");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field code more specific is max length
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_code_23() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("adadadaadaadaadaadaadaadaadaadaadaadaadaadaadaadaada" +
                "adaadaadaadaadaadaadaadaadaadaadaadaadaadaadaadaadaadaadaadaada" +
                "adaadaadaadaadaadaadaadaadaadaadaada");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field email more specific is null
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_email_19() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field email more specific is empty
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_email_20() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field email more specific is wrong format
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_email_21() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/create-supplier")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field email more specific is minlength
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_email_22() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("a@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field email more specific is max length
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_email_23() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluaaaegreen@gmail.combluaaaegreen@gmail.combluaaaegreen@gmail.combluaaaegreen@gmai" +
                "l.combluaaaegreen@gmail.combluaaaegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field address more specific is null
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_address_19() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field address more specific is empty
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_address_20() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field address more specific is minlength
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_address_22() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("A");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field address more specific is max length
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_address_23() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng33 Yên Khê , Đà Nẵng33 Yên Khê , Đà Nẵng33 Yên Khê , Đà Nẵng33 Yê" +
                "n Khê , Đà Nẵng33 Yên Khê , Đà Nẵng33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field phone number more specific is null
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_phoneNumber_19() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê 2,Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field phone number more specific is empty
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_phoneNumber_20() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê 2,Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field phone number more specific is wrong format
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_phoneNumber_21() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê 2,Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("1111111111");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field phone number more specific is minlength
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_phoneNumber_22() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê 2,Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("00");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field phone number more specific is max length
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_phoneNumber_23() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công Ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê 2,Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222330908222333090822233309082223330908222333" +
                "090822233309082223330908222333090822233309082223333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/2")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateSupplierById_id_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/supplier/update-supplier/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateSupplierById_id_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/supplier/update-supplier/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id not exits
     **/
    @Test
    public void updateSupplierById_id_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/supplier/update-supplier/{id}", "100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id is negative
     **/
    @Test
    public void updateSupplierById_id_99() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/supplier/update-supplier/{id}", "-1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create:18/09/2023
     * description: test id is not a number
     **/
    @Test
    public void updateSupplierById_id_98() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/supplier/update-supplier/{id}", "a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test id is 0
     **/
    @Test
    public void updateSupplierById_id_97() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/supplier/update-supplier/{id}", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test success
     *
     * @author ThanhVH
     * @Time 18/09/2023
     */
    @Test
    public void updateSupplierById_24() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công Ty Dana");
        supplierDto.setAddress("253 Dũng Sĩ Thanh Khê,Đà Nẵng");
        supplierDto.setCode("DANAA");
        supplierDto.setEmail("danapha@gmail.com");
        supplierDto.setNote("Không có nợ");
        supplierDto.setPhoneNumber("0987232424");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/supplier/update-supplier/11")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
