package com.example.retro_care.ReportController;

import com.example.retro_care.report.dto.ValidateDto;
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
public class ReportController_findRevenue {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Author: DuyTV
     * Goal: Test field startDate of validateDto
     * Date created: 18/09/2023
     *
     * @throws Exception
     * @param:validateDto with startDate = null and endDate = "2023-03-13"
     */
    @Test
    public void findRevenue_validateDto_startDate_1() throws Exception {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setStartDate(null);
        validateDto.setEndDate("2023-03-13");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/report/chart/revenue")
                        .content(this.objectMapper.writeValueAsString(validateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Author: DuyTV
     * Goal: Test field startDate of validateDto
     * Date created: 18/09/2023
     *
     * @throws Exception
     * @param:validateDto with startDate = "" and endDate = "2023-03-13"
     */
    @Test
    public void findRevenue_validateDto_startDate_2() throws Exception {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setStartDate("");
        validateDto.setEndDate("2023-03-13");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/report/chart/revenue")
                        .content(this.objectMapper.writeValueAsString(validateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Author: DuyTV
     * Goal: Test field startDate of validateDto in case startDate has wrong format
     * Date created: 18/09/2023
     *
     * @throws Exception
     * @param:validateDto with startDate = "aaaaa" and endDate = "2023-03-13"
     */
    @Test
    public void findRevenue_validateDto_startDate_3() throws Exception {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setStartDate("aaaaa");
        validateDto.setEndDate("2023-03-13");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/report/chart/revenue")
                        .content(this.objectMapper.writeValueAsString(validateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: DuyTV
     * Goal: Test field startDate of validateDto in case success
     * Date created: 18/09/2023
     *
     * @throws Exception
     * @param:validateDto with startDate = "2023-03-10" and endDate = "2023-03-13"
     */
    @Test
    public void findRevenue_validateDto_startDate_4() throws Exception {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setStartDate("2023-03-10");
        validateDto.setEndDate("2023-03-13");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/report/chart/revenue")
                        .content(this.objectMapper.writeValueAsString(validateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /**
     * Author: DuyTV
     * Goal: Test field startDate of validateDto in case: startDate after current date.
     * Date created: 18/09/2023
     *
     * @throws Exception
     * @param:validateDto with startDate = "2023-09-19" and endDate = "2023-03-13"
     */
    @Test
    public void findRevenue_validateDto_startDate_99() throws Exception {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setStartDate("2023-09-19");
        validateDto.setEndDate("2023-03-13");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/report/chart/revenue")
                        .content(this.objectMapper.writeValueAsString(validateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: DuyTV
     * Goal: Test field endDate of validateDto
     * Date created: 18/09/2023
     *
     * @throws Exception
     * @param:validateDto with startDate = "2023-03-10" and endDate = null
     */
    @Test
    public void findRevenue_validateDto_endDate_1() throws Exception {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setStartDate("2023-03-10");
        validateDto.setEndDate(null);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/report/chart/revenue")
                        .content(this.objectMapper.writeValueAsString(validateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Author: DuyTV
     * Goal: Test field endDate of validateDto
     * Date created: 18/09/2023
     *
     * @throws Exception
     * @param:validateDto with startDate = "2023-03-10" and endDate = ""
     */
    @Test
    public void findRevenue_validateDto_endDate_2() throws Exception {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setStartDate("2023-03-10");
        validateDto.setEndDate("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/report/chart/revenue")
                        .content(this.objectMapper.writeValueAsString(validateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Author: DuyTV
     * Goal: Test field endDate of validateDto in case endDate has wrong format
     * Date created: 18/09/2023
     *
     * @throws Exception
     * @param:validateDto with startDate = "2023-03-10" and endDate = "aaaaa"
     */
    @Test
    public void findRevenue_validateDto_endDate_3() throws Exception {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setStartDate("2023-03-10");
        validateDto.setEndDate("aaaaa");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/report/chart/revenue")
                        .content(this.objectMapper.writeValueAsString(validateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Author: DuyTV
     * Goal: Test field endDate of validateDto in case success
     * Date created: 18/09/2023
     *
     * @throws Exception
     * @param:validateDto with startDate = "2023-03-10" and endDate = "2023-03-13"
     */
    @Test
    public void findRevenue_validateDto_endDate_4() throws Exception {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setStartDate("2023-03-10");
        validateDto.setEndDate("2023-03-13");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/report/chart/revenue")
                        .content(this.objectMapper.writeValueAsString(validateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



    /**
     * Author: DuyTV
     * Goal: Test field endDate of validateDto in case: endDate after current date.
     * Date created: 18/09/2023
     *
     * @throws Exception
     * @param:validateDto with startDate = "2023-03-10" and endDate = "2023-09-19"
     */
    @Test
    public void findRevenue_validateDto_endDate_99() throws Exception {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setStartDate("2023-03-10");
        validateDto.setEndDate("2023-09-19");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/report/chart/revenue")
                        .content(this.objectMapper.writeValueAsString(validateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Author: DuyTV
     * Goal: Test field endDate of validateDto in case: endDate before startDate.
     * Date created: 18/09/2023
     *
     * @throws Exception
     * @param:validateDto with startDate = "2023-03-13" and endDate = "2023-03-10"
     */
    @Test
    public void findRevenue_validateDto_endDate_98() throws Exception {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setStartDate("2023-03-13");
        validateDto.setEndDate("2023-03-10");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/report/chart/revenue")
                        .content(this.objectMapper.writeValueAsString(validateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
