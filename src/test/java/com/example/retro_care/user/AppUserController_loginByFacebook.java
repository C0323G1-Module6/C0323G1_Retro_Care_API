package com.example.retro_care.user;

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
public class AppUserController_loginByFacebook {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * creater: NhatNhh
     * date: 18-09-2023
     * this function use to test the validation of field facebookEmail more specific is null
     */
    @Test
    public void loginByFacebook_13() throws Exception {
        FacebookMailRequest facebookMailRequest = new FacebookMailRequest();

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/login-by-facebook")
                        .content(this.objectMapper.writeValueAsString(facebookMailRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNhh
     * date: 18-09-2023
     * this function use to test the validation of field facebookEmail more specific is blank
     */
    @Test
    public void loginByFacebook_14() throws Exception {
        FacebookMailRequest facebookMailRequest = new FacebookMailRequest();
        facebookMailRequest.setFacebookMail("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/login-by-facebook")
                        .content(this.objectMapper.writeValueAsString(facebookMailRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * creater: NhatNhh
     * date: 18-09-2023
     * this function use to test the validation of field facebookEmail more specific is ok
     */
    @Test
    public void loginByFacebook_18() throws Exception {
        FacebookMailRequest facebookMailRequest = new FacebookMailRequest();
        facebookMailRequest.setFacebookMail("hoangnhat3103@gmail.com");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/login-by-facebook")
                        .content(this.objectMapper.writeValueAsString(facebookMailRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
