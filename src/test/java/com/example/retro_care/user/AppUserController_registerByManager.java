package com.example.retro_care.user;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class AppUserController_registerByManager {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field username more specific is null
     */
    @Test
    public void registerByManager_username_13() throws Exception {
        String userName = null;
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-manager?userName=" + userName))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field username more specific is blank
     */
    @Test
    public void registerByManager_username_14() throws Exception {
        String userName = "";
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-manager?userName=" + userName))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field username more specific is less than 3
     */
    @Test
    public void registerByManager_username_16() throws Exception {
        String userName = "minhhanh";
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-manager?userName=" + userName))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field username more specific is greater than 100
     */
    @Test
    public void registerByManager_username_17() throws Exception {
        String userName = "nananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananananana";
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-manager?userName=" + userName))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field username is exist in database
     */
    @Test
    public void registerByManager_username_99() throws Exception {
        String userName = "phucquy3";
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-manager?userName=" + userName))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test the validation of field username success
     */
    @Test
    public void registerByManager_username_18() throws Exception {
        String userName = "minhhanh";

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/register-by-manager?userName=" + userName))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
