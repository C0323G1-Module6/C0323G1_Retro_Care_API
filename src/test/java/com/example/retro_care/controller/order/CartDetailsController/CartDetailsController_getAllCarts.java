package com.example.retro_care.controller.order.CartDetailsController;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
public class CartDetailsController_getAllCarts {

    @Autowired
    private MockMvc mockMvc;

    /**
     * This function is used to test the case when
     *  request param (appUserId) is provided with null value
     * during the show-cart-detail process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getAllCarts_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-all?appUserId=null"))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$[0].address").value("ha"))
                .andExpect(jsonPath("$[0].customerName").value("Hannah Luu NG"))
                .andExpect(jsonPath("$[0].medicineName").value("med2"))
                .andExpect(jsonPath("$[0].medicinePrice").value("100000.0"))
                .andExpect(jsonPath("$[0].medicineId").value(2))
                .andExpect(jsonPath("$[0].medicineImage").value("https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-core/products/P01392_112.jpg"))
                .andExpect(jsonPath("$[0].loyaltyPoint").value(1000))
                .andExpect(jsonPath("$[0].quantityInCart").value(2))
                .andExpect(jsonPath("$[0].customerEmail").value("hannah@gmail.com"))
                .andExpect(jsonPath("$[0].cartId").value(2));

    }

    /**
     * This function is used to test the case when
     *  request param (appUserId) is provided with no value
     * during the show-cart-detail process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getAllCarts_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-all?appUserId="))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$[0].address").value("ha"))
                .andExpect(jsonPath("$[0].customerName").value("Hannah Luu NG"))
                .andExpect(jsonPath("$[0].medicineName").value("med2"))
                .andExpect(jsonPath("$[0].medicinePrice").value("100000.0"))
                .andExpect(jsonPath("$[0].medicineId").value(2))
                .andExpect(jsonPath("$[0].medicineImage").value("https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-core/products/P01392_112.jpg"))
                .andExpect(jsonPath("$[0].loyaltyPoint").value(1000))
                .andExpect(jsonPath("$[0].quantityInCart").value(2))
                .andExpect(jsonPath("$[0].customerEmail").value("hannah@gmail.com"))
                .andExpect(jsonPath("$[0].cartId").value(2));

    }

    /**
     * This function is used to test the case when
     *  request param (appUserId) is provided with no equivalent value in DB
     * during the show-cart-detail process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getAllCarts_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-all?appUserId=222"))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$[0].address").value("ha"))
                .andExpect(jsonPath("$[0].customerName").value("Hannah Luu NG"))
                .andExpect(jsonPath("$[0].medicineName").value("med2"))
                .andExpect(jsonPath("$[0].medicinePrice").value("100000.0"))
                .andExpect(jsonPath("$[0].medicineId").value(2))
                .andExpect(jsonPath("$[0].medicineImage").value("https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-core/products/P01392_112.jpg"))
                .andExpect(jsonPath("$[0].loyaltyPoint").value(1000))
                .andExpect(jsonPath("$[0].quantityInCart").value(2))
                .andExpect(jsonPath("$[0].customerEmail").value("hannah@gmail.com"))
                .andExpect(jsonPath("$[0].cartId").value(2));

    }

    /**
     * This function is used to test the case when
     *  request param (appUserId) is provided with valid value
     * during the show-cart-detail process
     * @author HanhNLM
     * @Time 18/09/2023
     */
    @Test
    public void getAllCarts_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/carts/get-all?appUserId=2"))
                .andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].address").value("ha"))
                .andExpect(jsonPath("$[0].customerName").value("Hannah Luu NG"))
                .andExpect(jsonPath("$[0].medicineName").value("med2"))
                .andExpect(jsonPath("$[0].medicinePrice").value("100000.0"))
                .andExpect(jsonPath("$[0].medicineId").value(2))
                .andExpect(jsonPath("$[0].medicineImage").value("https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-core/products/P01392_112.jpg"))
                .andExpect(jsonPath("$[0].loyaltyPoint").value(1000))
                .andExpect(jsonPath("$[0].quantityInCart").value(2))
                .andExpect(jsonPath("$[0].customerEmail").value("hannah@gmail.com"))
                .andExpect(jsonPath("$[0].cartId").value(2));

    }
}
