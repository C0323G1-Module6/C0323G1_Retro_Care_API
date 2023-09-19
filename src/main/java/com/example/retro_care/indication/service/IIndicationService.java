package com.example.retro_care.indication.service;

import com.example.retro_care.indication.model.Indication;

import java.util.List;

public interface IIndicationService {
    List<Indication> getAllIndication(Long idPrescription);
    void createIndication(Indication indication);
    Indication indicationById(Long idIndication);
    void removeIndication(Long idIndication);
    void editIndication(Indication indication);
    List<Indication> getAll();
}
