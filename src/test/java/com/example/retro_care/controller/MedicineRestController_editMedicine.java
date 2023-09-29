//package com.example.retro_care.controller;
//
//import com.example.retro_care.kind_of_medicine.model.KindOfMedicine;
//import com.example.retro_care.medicine.dto.MedicineDto;
//import com.example.retro_care.medicine.dto.UnitDetailDto;
//import com.example.retro_care.medicine.model.ImageMedicine;
//import com.example.retro_care.medicine.model.Unit;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//@SpringBootTest
//@AutoConfigureMockMvc
//public class MedicineRestController_editMedicine {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    /**
//     * this function use to test the validation of field name more specific is null
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_name_19() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field name more specific is empty
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_name_20() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field name more specific is containing special character
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_name_21() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat%$");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field name more specific is min length
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_name_22() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Th");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field name more specific is max length
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_name_23() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field code more specific is null
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_code_19() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field code more specific is empty
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_code_20() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field code more specific is containing special character
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_code_21() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("0034$#%4");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field code more specific is min length
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_code_22() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("34");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field code more specific is max length
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_code_23() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343sdsd834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field price more specific is null
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_price_19() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field price more specific is containing special character
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_price_21() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(Double.valueOf("500b&*%.0"));
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field vat more specific is not negative
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_vat_21() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(-2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field vat more specific is null
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_vate_19() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field note more specific is null
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_note_19() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field quantity more specific is null
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_quantity_19() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field maker more specific is null
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_maker_19() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field maker more specific is min length
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_maker_22() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field maker more specific is maximum
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_maker_23() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tinaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field activeElement more specific is null
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_activeElement_19() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field activeElement more specific is empty
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_activeElement_20() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field origin more specific is null
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_origin_19() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field origin more specific is empty
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_origin_20() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field origin more specific is not special
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_origin_21() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam$%^&");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field origin more specific is maximum
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_origin_23() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Namaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field RetailProfits more specific is null
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_retailProfits_19() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field retailProfits more specific is empty
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_retailProfits_20() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(null);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field retailProfits more specific is not positive
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_retailProfits_21() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(-10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field kindOfMedicine more specific is null
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_kindOfMedicine_19() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field kinOFMedicine more specific is empty
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_kindOfMedicine_20() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field kindOfMedicine more specific is containing special character
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_kindOfMedicine_21() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(Long.valueOf("3*^$L"));
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field ConversionRate more specific is null
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_conversionRate_19() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field ConversionRate more specific is empty
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_conversionRate_20() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(null);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field ConversionRate more specific is containing special character
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_conversionRate_21() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(Long.valueOf("&*%&10L"));
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field ConversionUnit more specific is null
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_conversionUnit_19() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field ConversionUnit more specific is empty
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_conversionUnit_20() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field ConversionUnit more specific is containing special character
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_conversionUnit_21() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("@$^VGC");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field ConversionUnit more specific is max length
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_conversionUnit_23() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function success
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_success_24() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * this function use to test the validation of field unit more specific is null
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_unit_19() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field unit more specific is empty
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_unit_20() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field unit more specific is containing special character
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_unit_22() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(Long.valueOf("%&*91L"));
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setImagePath("https://tse2.mm.bing.net/th?id=OIP.55xrJdT3ckz5UX55xcVb7QHaLH&pid=Api&P=0&h=180");
//        imageMedicine.setFlagDeleted(false);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field ImagePath more specific is null
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_imagePath_19() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        imageMedicine.setFlagDeleted(false);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field imagePath more specific is empty
//     *
//     * @author TinVV
//     * @Date 18/09/2023
//     */
//    @Test
//    public void editMedicine_imagePath_20() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        UnitDetailDto unitDetailDto = new UnitDetailDto();
//        ImageMedicine imageMedicine = new ImageMedicine();
//        KindOfMedicine kindOfMedicine = new KindOfMedicine();
//        Unit unit = new Unit();
//        medicineDto.setCode("00343834");
//        medicineDto.setName("Thuoc bo mat");
//        medicineDto.setPrice(500.0);
//        medicineDto.setQuantity(30L);
//        medicineDto.setVat(2F);
//        medicineDto.setNote("Oke");
//        medicineDto.setMaker("Vo Van Tin");
//        medicineDto.setActiveElement("vitaminC");
//        medicineDto.setOrigin("Viet Nam");
//        medicineDto.setRetailProfits(10F);
//        medicineDto.setFlagDeleted(false);
//        kindOfMedicine.setId(3L);
//        medicineDto.setKindOfMedicine(kindOfMedicine);
//        unitDetailDto.setFlagDeleted(false);
//        unitDetailDto.setConversionRate(10L);
//        unitDetailDto.setConversionUnit("vỉ");
//        unit.setId(1L);
//        unitDetailDto.setUnit(unit);
//        medicineDto.setUnitDetailDto(unitDetailDto);
//        medicineDto.setImageMedicine(imageMedicine);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/medicine/{id}", "4")
//                        .content(this.objectMapper.writeValueAsString(medicineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//}
