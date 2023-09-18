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
public class ReportController_findReport {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;



    /**
     * Author: DuyTV
     * Goal: Test field reportName
     * Date created: 18/09/2023
     * @param:validateDto
     * @param:reportName = null
     * @throws Exception
     */
    @Test
    public void findReport_reportName_1() throws Exception {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setStartDate("2023-03-10");
        validateDto.setEndDate("2023-03-13");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/report/general?reportName=null")
                        .content(this.objectMapper.writeValueAsString(validateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * Author: DuyTV
     * Goal: Test field reportName
     * Date created: 18/09/2023
     * @param:validateDto ( with valid data )
     * @param: reportName = ""
     * @throws Exception
     */
    @Test
    public void findReport_reportName_2() throws Exception {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setStartDate("2023-03-10");
        validateDto.setEndDate("2023-03-13");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/report/general?reportName=")
                        .content(this.objectMapper.writeValueAsString(validateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Author: DuyTV
     * Goal: Test field reportName
     * Date created: 18/09/2023
     * @param:validateDto ( with valid data )
     * @param: reportName = "revenue"
     * @throws Exception
     */
    @Test
    public void findReport_reportName_4() throws Exception {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setStartDate("2023-03-10");
        validateDto.setEndDate("2023-03-13");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/report/general?reportName=revenue")
                        .content(this.objectMapper.writeValueAsString(validateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /**
     * Author: DuyTV
     * Goal: Test field startDate of validateDto
     * Date created: 18/09/2023
     * @param: reportName = "revenue"
     * @param:validateDto with startDate = "" and endDate = "2023-03-13"
     * @throws Exception
     */
    @Test
    public void findReport_validateDto_startDate() throws Exception {
        ValidateDto validateDto = new ValidateDto();
        validateDto.setStartDate("");
        validateDto.setEndDate("2023-03-13");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/report/general?reportName=revenue")
                        .content(this.objectMapper.writeValueAsString(validateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }








}
