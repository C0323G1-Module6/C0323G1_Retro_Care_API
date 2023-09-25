package com.example.retro_care.controller.supplier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SupplierController_getListSupplier {
    @Autowired
    private MockMvc mockMvc;

    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test list is empty
     **/

//    @Test
//    public void getListStudent_5() throws Exception {
//        Page<ISupplierProjection> emptyList = new PageImpl<>(Collections.emptyList());
//        ISupplierService iSupplierService = mock(ISupplierService.class);
//        when(iSupplierService.getListSupplier(any(Pageable.class))).thenReturn(emptyList);
//
//        SupplierController supplierController = new SupplierController();
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(supplierController).build();
//        mockMvc.perform(MockMvcRequestBuilders.get("/supplier/0"))
//                .andExpect(status().is4xxClientError());
//    }
    /**
     *Create by: ThanhVH
     *Date create: 18/09/2023
     * description: test list success
     **/
    @Test
    public void getListStudent_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/supplier"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(4))
                .andExpect(jsonPath("totalElements").value(19))
                .andExpect(jsonPath("content[0].address").value("143 Hải Phòng,Đà Nẵng"))
                .andExpect(jsonPath("content[0].codeSupplier").value("NUTINE"))
                .andExpect(jsonPath("content[0].nameSupplier").value("Dược Phẩm Nutine"))
                .andExpect(jsonPath("content[0].note").value("Chưa thanh toán nợ"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0908223242"))
                .andExpect(jsonPath("content[0].debt").value("0.0"))
                .andExpect(jsonPath("content[4].address").value("40 Triệu Nữ Vương,Đà Nẵng"))
                .andExpect(jsonPath("content[4].codeSupplier").value("TRAFACO"))
                .andExpect(jsonPath("content[4].nameSupplier").value("Công Ty Traphaco"))
                .andExpect(jsonPath("content[4].note").value("Không có nợ"))
                .andExpect(jsonPath("content[4].phoneNumber").value("0978242235"))
                .andExpect(jsonPath("content[4].debt").value("0.0"));
    }

}
