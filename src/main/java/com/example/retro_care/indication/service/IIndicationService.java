package com.example.retro_care.indication.service;

import com.example.retro_care.indication.model.Indication;

import java.util.List;

public interface IIndicationService {
    List<Indication> getAllIndication(int idPrescription);
    void createIndication(Indication indication);
}
