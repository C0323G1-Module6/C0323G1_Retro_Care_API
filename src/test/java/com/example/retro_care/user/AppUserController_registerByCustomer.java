package com.example.retro_care.user;

import com.example.retro_care.user.dto.AppUserDto;
import com.example.retro_care.user.dto.FacebookMailRequest;
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
public class AppUserController_registerByCustomer {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    //Test username
    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field username more specific is null
     */
    @Test
    public void registerByCustomer_username_13() throws Exception {
        AppUserDto appUserDto = new AppUserDto();

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-customer")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field username more specific is blank
     */
    @Test
    public void registerByCustomer_username_14() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUserName("");
        appUserDto.setConfirmPassword("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-customer")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field username more specific less than 100
     */
    @Test
    public void registerByCustomer_username_16() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUserName("na");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-customer")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field username more specific greter than 100
     */
    @Test
    public void registerByCustomer_username_17() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUserName("nananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananana");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-customer")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test password
    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field password more specific is null
     */
    @Test
    public void registerByCustomer_password_13() throws Exception {
        AppUserDto appUserDto = new AppUserDto();

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-customer")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field password more specific is blank
     */
    @Test
    public void registerByCustomer_password_14() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setPassword("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-customer")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field password more specific less than 100
     */
    @Test
    public void registerByCustomer_password_16() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setPassword("na");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-customer")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field password more specific greter than 100
     */
    @Test
    public void registerByCustomer_password_17() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setPassword("nananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananana");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-customer")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test confirm password
    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field confirm password more specific is null
     */
    @Test
    public void registerByCustomer_confirmPassword_13() throws Exception {
        AppUserDto appUserDto = new AppUserDto();

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-customer")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field confirm password more specific is blank
     */
    @Test
    public void registerByCustomer_confirmPassword_14() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setConfirmPassword("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-customer")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field confirm password more specific less than 100
     */
    @Test
    public void registerByCustomer_confirmPassword_16() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setConfirmPassword("na");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-customer")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field confirm password more specific greater than 100
     */
    @Test
    public void registerByCustomer_confirmPassword_17() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setConfirmPassword("nananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananana");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-customer")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNhh
     * date: 18-09-2023
     * this function use to test the validation of field password not equal confirm password
     */
    @Test
    public void registerByCustomer_password_and_confirmPassword_98() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUserName("phucquy5");
        appUserDto.setPassword("aaaaaa");
        appUserDto.setConfirmPassword("123123");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-customer")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNhh
     * date: 18-09-2023
     * this function use to test the validation of field userName is exist in database
     */
    @Test
    public void registerByCustomer_userName_99() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUserName("phucquy3");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-customer")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of register success
     */
    @Test
    public void registerByCustomer_18() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUserName("phucquy123");
        appUserDto.setPassword("phucquy123");
        appUserDto.setConfirmPassword("phucquy123");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-customer")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}