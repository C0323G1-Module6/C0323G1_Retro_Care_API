package com.example.retro_care.user;

import com.example.retro_care.user.dto.AppUserDto;
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
public class AppUserController_loginByAccount {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    //Test user name
    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field userName more specific is null
     */
    @Test
    public void loginByAccount_userName_13() throws Exception {
        AppUserDto appUserDto = new AppUserDto();

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/login-by-username")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field userName more specific is blank
     */
    @Test
    public void loginByAccount_userName_14() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUserName("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/login-by-username")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field userName less than 3
     */
    @Test
    public void loginByAccount_userName_16() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUserName("na");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/login-by-username")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field userName greater than 100
     */
    @Test
    public void loginByAccount_userName_17() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUserName("nananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananana");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/login-by-username")
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
    public void loginByAccount_password_13() throws Exception {
        AppUserDto appUserDto = new AppUserDto();

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/login-by-username")
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
    public void loginByAccount_password_14() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setPassword("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/login-by-username")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field password less than 3
     */
    @Test
    public void loginByAccount_password_16() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setPassword("na");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/login-by-username")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field password greater than 100
     */
    @Test
    public void loginByAccount_password_user_17() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setPassword("nananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananana");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/login-by-username")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * creater: NhatNhh
     * date: 18-09-2023
     * this function use to test the validation of field userName is not exist in database
     */
    @Test
    public void loginByAccount_98() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUserName("phucquy");
        appUserDto.setPassword("phucquy");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/login-by-username")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNhh
     * date: 18-09-2023
     * this function use to test the validation of field userName is correct and password incorrect
     */
    @Test
    public void loginByAccount_99() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUserName("phucquy3");
        appUserDto.setUserName("13244");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/login-by-username")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field userName and password ok
     */
    @Test
    public void loginByAccount_18() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUserName("phucquy3");
        appUserDto.setPassword("123");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/login-by-username")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
