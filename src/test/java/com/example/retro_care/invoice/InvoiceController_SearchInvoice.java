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
     * Test case searches for employees with incorrect "start_date" parameters
     */


    /**
     * Create by: HuyHD;
     * Date create: 18/09/2023
     * Lỗi dữ liệu start_date nhập rỗng
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
     * Lỗi nhập liệu không đúng định dạng
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
     * lỗi nhập dữ liệu ngày bắt đầu là tương lai
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
     * Tìm kiếm với trường start_date thành công nhưng không có trong database.
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
     * Tìm kiếm với trường start_day thành công.
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
     * Lỗi dữ liệu end_date nhập rỗng
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
     * Lỗi dữ liệu end_date không đúng định dạng
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
     * lỗi nhập dữ liệu ngày đến là quá khứ
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
     * Tìm kiếm với trường end_date thành công nhưng không có trong database.
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
     * Tìm kiếm với trường start_day thành công.
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
     * Lỗi dữ liệu start_time nhập rỗng
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
     * Lỗi dữ liệu start_time không đúng định dạng
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
     * Tìm kiếm với trường start_time thành công nhưng không có trong database.
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
     * Tìm kiếm với trường start_time thành công.
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
     * Lỗi dữ liệu end_time nhập rỗng
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
     * Lỗi dữ liệu end_time không đúng định dạng
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
     * Tìm kiếm với trường end_time thành công nhưng không có trong database.
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
     * Tìm kiếm với trường end_time thành công.
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
