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
public class AppUserController_logout {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    /**
     * creater: NhatNHH
     * date: 18-09-2023
     * this function use to test logout
     */
    @Test
    public void logout() throws Exception {
        String userName = null;
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/user/logout", userName))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }
}
