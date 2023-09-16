package com.example.retro_care.indication.service;

import com.example.retro_care.indication.model.Indication;
import com.example.retro_care.indication.repository.IIndicationRepository;
import com.example.retro_care.prescription.model.Prescription;
import com.example.retro_care.prescription.service.IPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndicationService implements IIndicationService {
    @Autowired
    private IIndicationRepository indicationRepository;
    @Autowired
    private IPrescriptionService prescriptionService;

    @Override
    public List<Indication> getAllIndication(Long idPrescription) {
        return indicationRepository.getAllIndication(idPrescription);
    }
    Long maxId(){
        List<Prescription> prescriptionList = prescriptionService.getAll();
        Long idMax = prescriptionList.get(0).getId();
        for (Prescription p : prescriptionList) {
            if (p.getId() > idMax) {
                idMax= p.getId();
            }
        }return idMax;
    }
    @Override
    public void createIndication(Indication indication) {
        indication.setId(maxId()+1);
        indicationRepository.createIndication(indication);
    }
}
