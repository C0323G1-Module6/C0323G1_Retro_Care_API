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
public class SupplierController_createSupplier {
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
    public void createSupplier_name_13() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BlUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_name_14() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BlUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_name_15() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("adadad");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BlUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_name_16() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("a");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BlUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_name_17() throws Exception {

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
                        .post("/supplier/create-supplier")
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
    public void createSupplier_code_13() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_code_14() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_code_15() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("blue");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_code_16() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("bl");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_code_17() throws Exception {

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
                        .post("/supplier/create-supplier")
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
    public void createSupplier_email_13() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_email_14() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_email_15() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_email_16() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê , Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("a@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_email_17() throws Exception {

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
                        .post("/supplier/create-supplier")
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
    public void createSupplier_address_13() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_address_14() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_address_16() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("A");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0908222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_address_17() throws Exception {

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
                        .post("/supplier/create-supplier")
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
    public void createSupplier_phoneNumber_13() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê 2,Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_phoneNumber_14() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê 2,Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_phoneNumber_15() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê 2,Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("1111111111");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_phoneNumber_16() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công ty BlueGreen");
        supplierDto.setAddress("33 Yên Khê 2,Đà Nẵng");
        supplierDto.setCode("BLUE");
        supplierDto.setEmail("bluegreen@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("00");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
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
    public void createSupplier_phoneNumber_17() throws Exception {

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
                        .post("/supplier/create-supplier")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
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
    public void createSupplier_18() throws Exception {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setName("Công Ty Pharma");
        supplierDto.setAddress("150 Nguyễn Tri Phương, Đà Nẵng");
        supplierDto.setCode("PHAR");
        supplierDto.setEmail("pharma@gmail.com");
        supplierDto.setNote("Đã thanh toán");
        supplierDto.setPhoneNumber("0786222425");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/supplier/create-supplier")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
 }
