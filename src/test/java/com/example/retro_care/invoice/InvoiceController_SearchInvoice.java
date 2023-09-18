package com.example.retro_care.invoice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceController_SearchInvoice {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Error entering empty start_date data
     * @throws Exception
     */
    @Test
    public void searchInvoice_8_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("start_date", "")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Error entering data in incorrect format
     * @throws Exception
     */
    @Test
    public void searchInvoice_7_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("start_date", "aaaa")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * error entering data start date is future
     * @throws Exception
     */
    @Test
    public void searchInvoice_204_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("start_date", "2024-09-09")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * The search with the start_date field was successful but not in the database.
     * @throws Exception
     */
    @Test
    public void searchInvoice_10_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("start_date", "2022-09-10")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Search with start_day field succeeds.
     * @throws Exception
     */
    @Test
    public void searchInvoice_11_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("start_date", "2023-09-09")
                )
                .andDo(print())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].code").value("HD001"))
                .andExpect(jsonPath("content[0].documentNumber").value(369852))
                .andExpect(jsonPath("content[4].id").value(5))
                .andExpect(jsonPath("content[4].code").value("HD005"))
                .andExpect(jsonPath("content[4].documentNumber").value(369855))
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Error entering empty end_date data
     * @throws Exception
     */
    @Test
    public void searchInvoice_8_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("end_date", "")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * End_date data malformed error
     * @throws Exception
     */
    @Test
    public void searchInvoice_9_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("end_date", "aaaa")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Arrival date data entry errors are a thing of the past
     * @throws Exception
     */
    @Test
    public void searchInvoice_204_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("end_date", "2022-09-09")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * The search with the end_date field was successful but not in the database.
     * @throws Exception
     */
    @Test
    public void searchInvoice_10_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("end_date", "2022-09-10")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Search with start_day field succeeds.
     * @throws Exception
     */
    @Test
    public void searchInvoice_11_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("end_date", "2023-09-20")
                )
                .andDo(print())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].code").value("HD001"))
                .andExpect(jsonPath("content[0].documentNumber").value(369852))
                .andExpect(jsonPath("content[4].id").value(5))
                .andExpect(jsonPath("content[4].code").value("HD005"))
                .andExpect(jsonPath("content[4].documentNumber").value(369855))
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Error entering empty start_time data
     * @throws Exception
     */
    @Test
    public void searchInvoice_8_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("start_time", "")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Error start_time data is not in correct format
     * @throws Exception
     */
    @Test
    public void searchInvoice_9_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("start_time", "aaaa")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * The search with the start_time field was successful but not in the database.
     * @throws Exception
     */
    @Test
    public void searchInvoice_10_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("start_time", "20:00:00")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Search with start_time field succeeds.
     * @throws Exception
     */
    @Test
    public void searchInvoice_11_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("start_time", "08:00:00")
                )
                .andDo(print())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].code").value("HD001"))
                .andExpect(jsonPath("content[0].documentNumber").value(369852))
                .andExpect(jsonPath("content[2].id").value(4))
                .andExpect(jsonPath("content[2].code").value("HD004"))
                .andExpect(jsonPath("content[2].documentNumber").value(369847))
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Error entering empty end_time data
     * @throws Exception
     */
    @Test
    public void searchInvoice_8_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("end_time", "")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * End_time data malformed error
     * @throws Exception
     */
    @Test
    public void searchInvoice_9_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("end_time", "aaaa")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * The search with the end_time field was successful but not in the database.
     * @throws Exception
     */
    @Test
    public void searchInvoice_10_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("end_time", "01:00:00")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     *
     * Search with end_time field succeeds.
     * @throws Exception
     */
    @Test
    public void searchInvoice_11_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("end_time", "16:00:00")
                )
                .andDo(print())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].code").value("HD001"))
                .andExpect(jsonPath("content[0].documentNumber").value(369852))
                .andExpect(jsonPath("content[4].id").value(5))
                .andExpect(jsonPath("content[4].code").value("HD005"))
                .andExpect(jsonPath("content[4].documentNumber").value(369855))
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Successful invoice search from date "2023-09-09" to date "2023-09-20"
     * @throws Exception
     */
    @Test
    public void searchInvoice_11_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("strar_date", "2023-09-09")
                                .param("end_date", "2023-09-20")

                )
                .andDo(print())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].code").value("HD001"))
                .andExpect(jsonPath("content[0].documentNumber").value(369852))
                .andExpect(jsonPath("content[4].id").value(5))
                .andExpect(jsonPath("content[4].code").value("HD005"))
                .andExpect(jsonPath("content[4].documentNumber").value(369855))
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Successful invoice search from date "2023-09-09" to date "2023-09-20" and
     * created from the hour "08:00:00"
     * @throws Exception
     */
    @Test
    public void searchInvoice_11_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("strar_date", "2023-09-09")
                                .param("end_date", "2023-09-20")
                                .param("start_time", "08:00:00")

                )
                .andDo(print())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].code").value("HD001"))
                .andExpect(jsonPath("content[0].documentNumber").value(369852))
                .andExpect(jsonPath("content[2].id").value(4))
                .andExpect(jsonPath("content[2].code").value("HD004"))
                .andExpect(jsonPath("content[2].documentNumber").value(369847))
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Successful invoice search from date "2023-09-09" to date "2023-09-20" and
     * created before "16:00:00"
     * @throws Exception
     */
    @Test
    public void searchInvoice_11_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("strar_date", "2023-09-09")
                                .param("end_date", "2023-09-20")
                                .param("end_time", "16:00:00")

                )
                .andDo(print())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].code").value("HD001"))
                .andExpect(jsonPath("content[0].documentNumber").value(369852))
                .andExpect(jsonPath("content[4].id").value(5))
                .andExpect(jsonPath("content[4].code").value("HD005"))
                .andExpect(jsonPath("content[4].documentNumber").value(369855))
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Successful invoice search from date "2023-09-09" to date "2023-09-20" and
     * created from time "08:00:00" to time "16:00:00"
     * @throws Exception
     */
    @Test
    public void searchInvoice_11_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("strar_date", "2023-09-09")
                                .param("end_date", "2023-09-20")
                                .param("start_time", "08:00:00")
                                .param("end_time", "16:00:00")

                )
                .andDo(print())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].code").value("HD001"))
                .andExpect(jsonPath("content[0].documentNumber").value(369852))
                .andExpect(jsonPath("content[2].id").value(4))
                .andExpect(jsonPath("content[2].code").value("HD004"))
                .andExpect(jsonPath("content[2].documentNumber").value(369847))
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Error Input data is empty
     * @throws Exception
     */
    @Test
    public void searchInvoice_96() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("sort_column", "")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Error Input data is incorrect
     * @throws Exception
     */
    @Test
    public void searchInvoice_97() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("sort_column", "zxc")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Sort by documentNumber
     * @throws Exception
     */
    @Test
    public void searchInvoice_98() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("sort_column", "2")
                )
                .andDo(print())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].id").value(5))
                .andExpect(jsonPath("content[0].code").value("HD005"))
                .andExpect(jsonPath("content[0].documentNumber").value(369855))
                .andExpect(jsonPath("content[4].id").value(3))
                .andExpect(jsonPath("content[4].code").value("HD003"))
                .andExpect(jsonPath("content[4].documentNumber").value(369844))
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Search with complete information
     * @throws Exception
     */
    @Test
    public void searchInvoice_11_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                                .param("strar_date", "2023-09-09")
                                .param("end_date", "2023-09-20")
                                .param("start_time", "08:00:00")
                                .param("end_time", "16:00:00")
                                .param("sort_column", "2")

                )
                .andDo(print())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].id").value(2))
                .andExpect(jsonPath("content[0].code").value("HD002"))
                .andExpect(jsonPath("content[0].documentNumber").value(369853))
                .andExpect(jsonPath("content[2].id").value(4))
                .andExpect(jsonPath("content[2].code").value("HD004"))
                .andExpect(jsonPath("content[2].documentNumber").value(369847))
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Search when there is no input data
     * @throws Exception
     */
    @Test
    public void searchInvoice_99() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/search")
                )
                .andDo(print())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].code").value("HD001"))
                .andExpect(jsonPath("content[0].documentNumber").value(369852))
                .andExpect(jsonPath("content[4].id").value(5))
                .andExpect(jsonPath("content[4].code").value("HD005"))
                .andExpect(jsonPath("content[4].documentNumber").value(369855))
                .andExpect(status().is2xxSuccessful());
    }
}
