package com.example.retro_care.controller.order.CartDetailsController;


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
public class CartDetailsController_getMedicineDetailsForDisplay {

    @Autowired
    private MockMvc mockMvc;

    /**
     * This function is used to test the case when
     *  request param (medicineId) is provided with null value
     * during the show-medicine-detail process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getMedicineDetailsForDisplay_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-details?medicineId=null"))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("quantity").value(35))
                .andExpect(jsonPath("conversion_Rate").value(5))
                .andExpect(jsonPath("medicine_Name").value("med1"))
                .andExpect(jsonPath("medicine_Code").value("TH1"))
                .andExpect(jsonPath("medicine_Images").value("https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-core/products/P05403_7.jpg,https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-core/products/P05403_2.jpg"))
                .andExpect(jsonPath("unit_Name").value("Hop"))
                .andExpect(jsonPath("conversion_Unit").value("Hop"))
                .andExpect(jsonPath("medicine_Note").value("this is the description for medicine 1"))
                .andExpect(jsonPath("kind_Of_Medicine_Name").value("type1"))
                .andExpect(jsonPath("price").value("50000.0"));
    }

    /**
     * This function is used to test the case when
     *  request param (medicineId) is provided with no value
     * during the show-medicine-detail process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getMedicineDetailsForDisplay_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-details?medicineId="))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("quantity").value(35))
                .andExpect(jsonPath("conversion_Rate").value(5))
                .andExpect(jsonPath("medicine_Name").value("med1"))
                .andExpect(jsonPath("medicine_Code").value("TH1"))
                .andExpect(jsonPath("medicine_Images").value("https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-core/products/P05403_7.jpg,https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-core/products/P05403_2.jpg"))
                .andExpect(jsonPath("unit_Name").value("Hop"))
                .andExpect(jsonPath("conversion_Unit").value("Hop"))
                .andExpect(jsonPath("medicine_Note").value("this is the description for medicine 1"))
                .andExpect(jsonPath("kind_Of_Medicine_Name").value("type1"))
                .andExpect(jsonPath("price").value("50000.0"));
    }

    /**
     * This function is used to test the case when
     *  request param (medicineId) is provided with null value
     * during the show-medicine-detail process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getMedicineDetailsForDisplay_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-details?medicineId=777"))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("quantity").value(35))
                .andExpect(jsonPath("conversion_Rate").value(5))
                .andExpect(jsonPath("medicine_Name").value("med1"))
                .andExpect(jsonPath("medicine_Code").value("TH1"))
                .andExpect(jsonPath("medicine_Images").value("https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-core/products/P05403_7.jpg,https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-core/products/P05403_2.jpg"))
                .andExpect(jsonPath("unit_Name").value("Hop"))
                .andExpect(jsonPath("conversion_Unit").value("Hop"))
                .andExpect(jsonPath("medicine_Note").value("this is the description for medicine 1"))
                .andExpect(jsonPath("kind_Of_Medicine_Name").value("type1"))
                .andExpect(jsonPath("price").value("50000.0"));
    }

    /**
     * This function is used to test the case when
     *  request param (medicineId) is provided with null value
     * during the show-medicine-detail process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getMedicineDetailsForDisplay_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-details?medicineId=1"))
                .andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("quantity").value(35))
                .andExpect(jsonPath("conversion_Rate").value(5))
                .andExpect(jsonPath("medicine_Name").value("med1"))
                .andExpect(jsonPath("medicine_Code").value("TH1"))
                .andExpect(jsonPath("medicine_Images").value("https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-core/products/P05403_7.jpg,https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-core/products/P05403_2.jpg"))
                .andExpect(jsonPath("unit_Name").value("Hop"))
                .andExpect(jsonPath("conversion_Unit").value("Hop"))
                .andExpect(jsonPath("medicine_Note").value("this is the description for medicine 1"))
                .andExpect(jsonPath("kind_Of_Medicine_Name").value("type1"))
                .andExpect(jsonPath("price").value("50000.0"));
    }
}
