package com.example.retro_care.indication.service;

import com.example.retro_care.indication.model.Indication;
import com.example.retro_care.indication.repository.IIndicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndicationService implements IIndicationService{
    @Autowired
    private IIndicationRepository indicationRepository;
    @Override
    public List<Indication> getAllIndication(int idPrescription) {
        return indicationRepository.getAllIndication(idPrescription);
    }

    @Override
    public void createIndication(Indication indication) {
        indicationRepository.createIndication(indication);
    }
}
