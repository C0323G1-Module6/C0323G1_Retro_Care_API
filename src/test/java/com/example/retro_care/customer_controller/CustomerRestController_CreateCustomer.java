package com.example.retro_care.customer_controller;

import com.example.retro_care.customer.dto.CustomerDto;
import com.example.retro_care.user.model.AppUser;
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
public class CustomerRestController_CreateCustomer {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    /**
     * this function is success
     * Author: TinDT
     */
    @Test
    public void create_Customer_12() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-112");
        customerDto.setName("Nguyễn Văn Tình");
        customerDto.setBirthday("2002-10-03");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339779768");
        customerDto.setEmail("thoaitin@gmail.com");
        customerDto.setNote("Khách vip");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * this function use to test the validation of field name more specific is null
     * Author: TinDT
     */
    @Test
    public void create_Customer_name_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-999");
        customerDto.setName(null);
        customerDto.setBirthday("2019-04-01");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339774756");
        customerDto.setEmail("TanTre@gmail.com");
        customerDto.setNote("Khách vip");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field name more specific is empty
     * Author: TinDT
     */
    @Test
    public void create_Customer_name_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-999");
        customerDto.setName("");
        customerDto.setBirthday("2002-04-01");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339774756");
        customerDto.setEmail("TanTre@gmail.com");
        customerDto.setNote("Khách vip");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the authenticity of a specific field name that is malformed
     * * Author: TinDT
     */
    @Test
    public void create_Customer_name_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-789");
        customerDto.setName("ffgnv1");
        customerDto.setBirthday("2002-04-02");
        customerDto.setAddress("16 Bạch đằng 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0913422887");
        customerDto.setEmail("thoaijtin@gmail.com");
        customerDto.setNote("Khách cực giàu");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                    .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the authenticity of a specific field name that is longer than 100 characters
     * * * Author: TinDT
     */
    @Test
    public void create_Customer_name_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-789");
        customerDto.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        customerDto.setBirthday("2002-04-02");
        customerDto.setAddress("16 Bạch đằng 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0913422887");
        customerDto.setEmail("thoaijtin@gmail.com");
        customerDto.setNote("Khách cực giàu");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field address more specific is null
     * * Author: TinDT
     */
    @Test
    public void create_Customer_address_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-789");
        customerDto.setName("Đàm Thoại Tin");
        customerDto.setBirthday("2002-04-02");
        customerDto.setPhoneNumber("0913422887");
        customerDto.setEmail("thoaijtin@gmail.com");
        customerDto.setAddress(null);
        customerDto.setNote("Khách cực giàu");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field address more specific is empty
     * * Author: TinDT
     */
    @Test
    public void create_Customer_address_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-789");
        customerDto.setName("Đàm Thoại Tin");
        customerDto.setBirthday("2002-04-02");
        customerDto.setAddress("");
        customerDto.setPhoneNumber("0913422887");
        customerDto.setEmail("thoaijtin@gmail.com");
        customerDto.setNote("Khách cực giàu");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the authenticity of a specific field address that is longer than 100 characters
     * * * Author: TinDT
     */
    @Test
    public void create_Customer_address_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-789");
        customerDto.setName("Đàm Thoại Tin");
        customerDto.setBirthday("2002-04-02");
        customerDto.setAddress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        customerDto.setPhoneNumber("0913422887");
        customerDto.setEmail("thoaijtin@gmail.com");
        customerDto.setNote("Khách cực giàu");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field birthDay more specific is null
     * * * Author: TinDT
     */
    @Test
    public void create_Customer_birthDay_20() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-789");
        customerDto.setName("Đàm Thoại Tin");
        customerDto.setAddress("Trần Việt Duy");
        customerDto.setBirthday(null);
        customerDto.setPhoneNumber("0913422887");
        customerDto.setEmail("thoaijtin@gmail.com");
        customerDto.setNote("Khách cực giàu");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field birthDay more specific is empty
     * * * Author: TinDT
     */
    @Test
    public void create_Customer_birthDay_21() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-789");
        customerDto.setName("Trần Việt Duy");
        customerDto.setAddress("20 Võ Nguyên Giáp");
        customerDto.setBirthday("");
        customerDto.setPhoneNumber("0913422887");
        customerDto.setEmail("duyTran@gmail.com");
        customerDto.setNote("Khách cực giàu");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
//    /**
//     * This function is used to check the validity of a more specific date of birth field that is greater than 18 years old
//     * * Author: TinDT
//     */
//    @Test
//    public void create_Customer_birthDay_22() throws Exception {
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setCode("KH-789");
//        customerDto.setName("Trần Việt Duy");
//        customerDto.setAddress("20 Võ Nguyên Giáp");
//        customerDto.setBirthday("2019-04-02");
//        customerDto.setPhoneNumber("0913422887");
//        customerDto.setEmail("duyTran@gmail.com");
//        customerDto.setNote("Khách cực giàu");
//        AppUser appUser = new AppUser();
//        appUser.setId(1L);
//        customerDto.setAppUser(appUser);
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/customers/api/create")
//                                .content(this.objectMapper.writeValueAsString(customerDto))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
        /**
     * This function is used to check the validity of a more specific phone number field that is empty
     * * Author: TinDT
     */
    @Test
    public void create_Customer_phoneNumber_22() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-789");
        customerDto.setName("Trần Việt Duy");
        customerDto.setAddress("20 Võ Nguyên Giáp");
        customerDto.setBirthday("1997-4-2");
        customerDto.setPhoneNumber("");
        customerDto.setEmail("duyTran@gmail.com");
        customerDto.setNote("Khách cực giàu");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validity of a more specific phone number field that is null
     * * Author: TinDT
     */
    @Test
    public void create_Customer_phoneNumber_23() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-789");
        customerDto.setName("Trần Việt Duy");
        customerDto.setAddress("20 Võ Nguyên Giáp");
        customerDto.setBirthday("1997-4-2");
        customerDto.setPhoneNumber(null);
        customerDto.setEmail("duyTran@gmail.com");
        customerDto.setNote("Khách cực giàu");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validity of a specific phone number field rather than malformation
     * * * Author: TinDT
     */
    @Test
    public void create_Customer_phoneNumber_24() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-789");
        customerDto.setName("Trần Việt Duy");
        customerDto.setAddress("20 Võ Nguyên Giáp");
        customerDto.setBirthday("1997-4-2");
        customerDto.setPhoneNumber("aaaaa");
        customerDto.setEmail("duyTran@gmail.com");
        customerDto.setNote("Khách cực giàu");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validity of a specific phone number field rather than a specified character
     * * Author: TinDT
     */
    @Test
    public void create_Customer_phoneNumber_25() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-789");
        customerDto.setName("Trần Việt Duy");
        customerDto.setAddress("20 Võ Nguyên Giáp");
        customerDto.setBirthday("1997-4-2");
        customerDto.setPhoneNumber("033977876899");
        customerDto.setEmail("duyTran@gmail.com");
        customerDto.setNote("Khách cực giàu");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the validity of a more specific email field that is null
     * * Author: TinDT
     */
    @Test
    public void create_Customer_email_26() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-789");
        customerDto.setName("Trần Việt Duy");
        customerDto.setAddress("20 Võ Nguyên Giáp");
        customerDto.setBirthday("1997-4-2");
        customerDto.setPhoneNumber("0339778768");
        customerDto.setEmail(null);
        customerDto.setNote("Khách cực giàu");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validity of a more specific email field that is empty
     * * Author: TinDT
     */
    @Test
    public void create_Customer_email_27() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-789");
        customerDto.setName("Trần Việt Duy");
        customerDto.setAddress("20 Võ Nguyên Giáp");
        customerDto.setBirthday("1997-4-2");
        customerDto.setPhoneNumber("0339778768");
        customerDto.setEmail("");
        customerDto.setNote("Khách cực giàu");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validity of a specific email field rather than a specified character
     * * Author: TinDT
     */
    @Test
    public void create_Customer_email_28() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-789");
        customerDto.setName("Trần Việt Duy");
        customerDto.setAddress("20 Võ Nguyên Giáp");
        customerDto.setBirthday("1997-4-2");
        customerDto.setPhoneNumber("0339778768");
        customerDto.setEmail("damthoaitinmananananaahahaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com");
        customerDto.setNote("Khách cực giàu");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the validity of a specific email field rather than malformation
     * * Author: TinDT
     */
    @Test
    public void create_Customer_email_29() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-789");
        customerDto.setName("Trần Việt Duy");
        customerDto.setAddress("20 Võ Nguyên Giáp");
        customerDto.setBirthday("1997-4-2");
        customerDto.setPhoneNumber("0339778768");
        customerDto.setEmail("damthoait1gmail.com");
        customerDto.setNote("Khách cực giàu");
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        customerDto.setAppUser(appUser);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/customers/api/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
