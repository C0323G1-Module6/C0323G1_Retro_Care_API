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
public class CustomerRestController_UpdateCustomer {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    /**
     * This function is used to check the id parameter is empty
     * Author: TinDT
     */
    @Test
    public void update_Customer_9() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("Nguyễn Văn Hoàng");
        customerDto.setBirthday("2001-10-03");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339774756");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
    /**
     * This function is used to check that the id parameter does not exist
     * Author: TinDT
     */
    @Test
    public void update_Customer_10() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("Nguyễn Văn Hoàng");
        customerDto.setBirthday("2001-10-03");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339774756");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/79")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * this function is success
     * Author: TinDT
     */
    @Test
    public void update_Customer_11() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("Nguyễn Văn Hoàng");
        customerDto.setBirthday("2001-10-03");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339774756");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
                                 .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
    /**
     * this function use to test the validation of field name more specific is null
     * Author: TinDT
     */
    @Test
    public void update_Customer_name_12() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setBirthday("2001-10-03");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339774756");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
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
    public void update_Customer_name_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("");
        customerDto.setBirthday("2001-10-03");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339774756");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
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
    public void update_Customer_name_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("132434");
        customerDto.setBirthday("2001-10-03");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339774756");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
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
    public void update_Customer_name_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        customerDto.setBirthday("2001-10-03");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339774756");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
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
    public void update_Customer_address_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("Nguyễn Hoàng Nhật");
        customerDto.setBirthday("2001-10-03");
        customerDto.setPhoneNumber("0339774756");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
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
    public void update_Customer_address_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("Nguyễn Hoàng Nhật");
        customerDto.setBirthday("2001-10-03");
        customerDto.setAddress("");
        customerDto.setPhoneNumber("0339774756");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
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
    public void update_Customer_address_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("Nguyễn Hoàng Nhật");
        customerDto.setBirthday("2001-10-03");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        customerDto.setPhoneNumber("0339774756");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
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
    public void update_Customer_birthDay_20() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("Nguyễn Hoàng Nhật");
//        customerDto.setBirthday("2001-10-03");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339774756");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
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
    public void update_Customer_birthDay_21() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("Nguyễn Hoàng Nhật");
        customerDto.setBirthday("");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339774756");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
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
//    public void update_Customer_birthDay_22() throws Exception {
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
//                        MockMvcRequestBuilders.patch("/customers/api/update/{id}","1")
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
    public void update_Customer_phoneNumber_22() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("Nguyễn Hoàng Nhật");
        customerDto.setBirthday("2019-04-02");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
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
    public void update_Customer_phoneNumber_23() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("Nguyễn Hoàng Nhật");
        customerDto.setBirthday("2001-04-02");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339779768");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
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
    public void update_Customer_phoneNumber_24() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("Nguyễn Hoàng Nhật");
        customerDto.setBirthday("2019-04-02");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("jhjkh6666666");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
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
    public void update_Customer_phoneNumber_25() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("Nguyễn Hoàng Nhật");
        customerDto.setBirthday("2019-04-02");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("033977976899");
        customerDto.setEmail("hoangnguyen@gmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
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
    public void update_Customer_email_26() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("Nguyễn Hoàng Nhật");
        customerDto.setBirthday("2019-04-02");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339779768");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
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
    public void update_Customer_email_27() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("Nguyễn Hoàng Nhật");
        customerDto.setBirthday("2019-04-02");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339779768");
        customerDto.setEmail("");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
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
    public void update_Customer_email_28() throws Exception {
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
                        MockMvcRequestBuilders.patch("/customers/api/update/{id}","1")
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
    public void update_Customer_email_29() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode("KH-01");
        customerDto.setName("Nguyễn Hoàng Nhật");
        customerDto.setBirthday("2019-04-02");
        customerDto.setAddress("16 Mỹ khê 6 Sơn trà tp Đà Nẵng");
        customerDto.setPhoneNumber("0339779768");
        customerDto.setEmail("hoangnguyengmail.com");
        customerDto.setNote("Khách vip");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/customers/api/update/1")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
