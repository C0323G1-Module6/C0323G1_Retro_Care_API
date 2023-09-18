package com.example.retro_care.prescription;

import com.example.retro_care.patient.model.Patient;
import com.example.retro_care.prescription.dto.PrescriptionDto;
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
public class PrescriptionController_createPrescription {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createPrescription_13() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/prescription/create"))
                .andDo(print())
                .andExpect(status().is4xxClientError()
                );
    }

    @Test
    public void createPrescription_code_14() throws Exception {
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        prescriptionDto.setCode("");
        prescriptionDto.setName("Cảm");
        prescriptionDto.setDuration(4);
        prescriptionDto.setSymptoms("Ho,sốt");
        prescriptionDto.setNote("Không có");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/prescription/create")
                                .content(this.objectMapper.writeValueAsString(prescriptionDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError()
                );
    }

    @Test
    public void createPrescription_name_14() throws Exception {
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        prescriptionDto.setCode("001");
        prescriptionDto.setName("");
        prescriptionDto.setDuration(4);
        prescriptionDto.setSymptoms("Ho,sốt");
        prescriptionDto.setNote("Không có");
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/prescription/create")
                                .content(this.objectMapper.writeValueAsString(prescriptionDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError()
                );
    }

    @Test
    public void createPrescription_symptoms_14() throws Exception {
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        prescriptionDto.setCode("001");
        prescriptionDto.setName("Cảm");
        prescriptionDto.setDuration(4);
        prescriptionDto.setSymptoms("");
        prescriptionDto.setNote("Không có");
        prescriptionDto.setFlagDeleted(false);

        Patient patient = new Patient();
        patient.setId(1L);
        prescriptionDto.setPatient(patient);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/prescription/create")
                                .content(this.objectMapper.writeValueAsString(prescriptionDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError()
                );
    }

    @Test
    public void createPrescription_symptoms_16() throws Exception {
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        prescriptionDto.setCode("001");
        prescriptionDto.setName("Cảm");
        prescriptionDto.setDuration(4);
        prescriptionDto.setSymptoms("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        prescriptionDto.setNote("Không có");
        prescriptionDto.setFlagDeleted(false);

        Patient patient = new Patient();
        patient.setId(1L);
        prescriptionDto.setPatient(patient);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/prescription/create")
                                .content(this.objectMapper.writeValueAsString(prescriptionDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError()
                );
    }

    @Test
    public void createPrescription_note_16() throws Exception {
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        prescriptionDto.setCode("001");
        prescriptionDto.setName("Cảm");
        prescriptionDto.setDuration(4);
        prescriptionDto.setSymptoms("Ho,sốt");
        prescriptionDto.setNote("Không cómmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        prescriptionDto.setFlagDeleted(false);

        Patient patient = new Patient();
        patient.setId(1L);
        prescriptionDto.setPatient(patient);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/prescription/create")
                                .content(this.objectMapper.writeValueAsString(prescriptionDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError()
                );
    }

    @Test
    public void createPrescription_name_16() throws Exception {
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        prescriptionDto.setCode("001");
        prescriptionDto.setName("Cảmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        prescriptionDto.setDuration(4);
        prescriptionDto.setSymptoms("Ho,cảm");
        prescriptionDto.setNote("Không có");
        prescriptionDto.setFlagDeleted(false);

        Patient patient = new Patient();
        patient.setId(1L);
        prescriptionDto.setPatient(patient);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/prescription/create")
                                .content(this.objectMapper.writeValueAsString(prescriptionDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError()
                );
    }

    @Test
    public void createPrescription_code_16() throws Exception {
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        prescriptionDto.setCode("00100000000");
        prescriptionDto.setName("Cảm");
        prescriptionDto.setDuration(4);
        prescriptionDto.setSymptoms("Ho, cảm");
        prescriptionDto.setNote("Không có");
        prescriptionDto.setFlagDeleted(false);

        Patient patient = new Patient();
        patient.setId(1L);
        prescriptionDto.setPatient(patient);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/prescription/create")
                                .content(this.objectMapper.writeValueAsString(prescriptionDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError()
                );
    }

    @Test
    public void createPrescription_duration_17() throws Exception {
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        prescriptionDto.setCode("001");
        prescriptionDto.setName("Cảm");
        prescriptionDto.setDuration(-3);
        prescriptionDto.setSymptoms("Ho,cảm");
        prescriptionDto.setNote("Không có");
        prescriptionDto.setFlagDeleted(false);

        Patient patient = new Patient();
        patient.setId(1L);
        prescriptionDto.setPatient(patient);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/prescription/create")
                                .content(this.objectMapper.writeValueAsString(prescriptionDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError()
                );
    }

    @Test
    public void createPrescription_18() throws Exception {
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        prescriptionDto.setCode("001");
        prescriptionDto.setName("Cảm");
        prescriptionDto.setDuration(4);
        prescriptionDto.setSymptoms("Ho,cảm");
        prescriptionDto.setNote("Không có");
        prescriptionDto.setFlagDeleted(false);

        Patient patient = new Patient();
        patient.setId(1L);
        prescriptionDto.setPatient(patient);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/prescription/create")
                                .content(this.objectMapper.writeValueAsString(prescriptionDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()
                );
    }
}
