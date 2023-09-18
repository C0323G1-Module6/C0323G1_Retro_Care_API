package com.example.retro_care;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicineController_searchMedicine {
    @Autowired
    private MockMvc mockMvc;

    /**
     * List of seaweed, search searchByName(null)
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByName_07() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/medicine/search?searchByName=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List of seaweed, search searchByCode(null)
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByCode_07() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/medicine/search?searchByCode=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List of seaweed, search searchByActiveElement(null)
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByActiveElement_07() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/medicine/search?searchByActiveElement=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List of seaweed, search searchByNameKindOf(null)
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByKindOfMedicine_07() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/medicine/search?searchByNameKindOf=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List of seaweed, search searchByName()
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByName_08() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/medicine/search?searchByName=''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List of seaweed, search searchByCode()
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByCode_08() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/medicine/search?searchByCode=''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List of seaweed, search searchByActiveElement()
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByActiveElement_08() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/medicine/search?searchByActiveElement=''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List of seaweed, search searchByNameKindOf()
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByKindOfMedicine_08() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/medicine/search?searchByNameKindOf=''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List of seaweed, search searchByName(anhdao)
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByName_09() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/medicine/search?searchByName=anhdao"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List of seaweed, search searchByCode(B00001)
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByCode_09() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/medicine/search?searchByCode=B00001"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List of seaweed, search searchByActiveElement(anhdao)
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByActiveElement_09() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/medicine/search?searchByActiveElement=anhdao"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List of seaweed, search searchByNameKindOf(anhdao)
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByKindOfMedicine_09() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/medicine/search?searchByNameKindOf=anhdao"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List of seaweed, search searchByNameKindOf(Pandol)
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByName_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/medicine/search?searchByName=Pandol"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].activeElement").value("ok"))
                .andExpect(jsonPath("content[0].code").value("T00001"))
                .andExpect(jsonPath("content[0].maker").value("Anh Dao"))
                .andExpect(jsonPath("content[0].name").value("Pandol"))
                .andExpect(jsonPath("content[0].note").value("Ngon"))
                .andExpect(jsonPath("content[0].origin").value("VietNam"))
                .andExpect(jsonPath("content[0].price").value("15000.1"))
                .andExpect(jsonPath("content[0].quantity").value("100"))
                .andExpect(jsonPath("content[0].retailProfits").value("5.1"))
                .andExpect(jsonPath("content[0].vat").value("5.1"))
                .andExpect(jsonPath("content[0].kindOfMedicine.id").value(2));
    }

    /**
     * List of seaweed, search searchByCode(T00001)
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByCode_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/medicine/search?searchByCode=T00001"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].activeElement").value("ok"))
                .andExpect(jsonPath("content[0].code").value("T00001"))
                .andExpect(jsonPath("content[0].maker").value("Anh Dao"))
                .andExpect(jsonPath("content[0].name").value("Pandol"))
                .andExpect(jsonPath("content[0].note").value("Ngon"))
                .andExpect(jsonPath("content[0].origin").value("VietNam"))
                .andExpect(jsonPath("content[0].price").value("15000.1"))
                .andExpect(jsonPath("content[0].quantity").value("100"))
                .andExpect(jsonPath("content[0].retailProfits").value("5.1"))
                .andExpect(jsonPath("content[0].vat").value("5.1"))
                .andExpect(jsonPath("content[0].kindOfMedicine.id").value("2"));
    }

    /**
     * List of seaweed, search searchByActiveElement(Anh Dao)
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByActiveElement_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/medicine/search?searchByActiveElement=Anh Dao"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].activeElement").value("ok"))
                .andExpect(jsonPath("content[0].code").value("T00001"))
                .andExpect(jsonPath("content[0].maker").value("Anh Dao"))
                .andExpect(jsonPath("content[0].name").value("Pandol"))
                .andExpect(jsonPath("content[0].note").value("Ngon"))
                .andExpect(jsonPath("content[0].origin").value("VietNam"))
                .andExpect(jsonPath("content[0].price").value("15000.1"))
                .andExpect(jsonPath("content[0].quantity").value("100"))
                .andExpect(jsonPath("content[0].retailProfits").value("5.1"))
                .andExpect(jsonPath("content[0].vat").value("5.1"))
                .andExpect(jsonPath("content[0].kindOfMedicine.id").value("2"));
    }
    /**
     * List of seaweed, search searchByActiveElement(Anh Dao)
     * author: DaoPTA
     * workday: 18/09/2023
     *
     * @throws Exception
     */
    @Test
    public void searchMedicineByKindOfMedicine_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/medicine/search?searchByNameKindOf=Bo"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].activeElement").value("ok"))
                .andExpect(jsonPath("content[0].code").value("T00001"))
                .andExpect(jsonPath("content[0].maker").value("Anh Dao"))
                .andExpect(jsonPath("content[0].name").value("Pandol"))
                .andExpect(jsonPath("content[0].note").value("Ngon"))
                .andExpect(jsonPath("content[0].origin").value("VietNam"))
                .andExpect(jsonPath("content[0].price").value("15000.1"))
                .andExpect(jsonPath("content[0].quantity").value("100"))
                .andExpect(jsonPath("content[0].retailProfits").value("5.1"))
                .andExpect(jsonPath("content[0].vat").value("5.1"))
                .andExpect(jsonPath("content[0].kindOfMedicine.id").value("2"));
    }
}
