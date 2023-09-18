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

    /**
     * Author: ThanhKN
     * Goal:get list indication by id prescription
     * Date:17/09/2023
     * return list of indication
     * @param idPrescription
     */
    @Override
    public List<Indication> getAllIndication(Long idPrescription) {
        return indicationRepository.getAllIndication(idPrescription);
    }
    /**
     * Author: ThanhKN
     * Goal:get id max of prescription
     * Date:17/09/2023
     * return id max of prescription
     */
    Long maxId(){
        List<Prescription> prescriptionList = prescriptionService.getAll();
        Long idMax = prescriptionList.get(0).getId();
        for (Prescription p : prescriptionList) {
            if (p.getId() > idMax) {
                idMax= p.getId();
            }
        }return idMax;
    }
    /**
     * Author: ThanhKN
     * Goal:Create indication
     * Date:17/09/2023
     * @param indication
     * return void
     */
    @Override
    public void createIndication(Indication indication) {
        indication.setId(maxId()+1);
        indicationRepository.createIndication(indication);
    }

    /**
     * Author: ThanhKN
     * Goal:get indication by id
     * Date:17/09/2023
     * @param idIndication
     * return indication
     */
    @Override
    public Indication indicationById(Long idIndication) {
        return indicationRepository.indicationById(idIndication);
    }

    /**
     * Author: ThanhKN
     * Goal:remove indication by id
     * Date:17/09/2023
     * @param idIndication
     * return void
     */
    @Override
    public void removeIndication(Long idIndication) {
        Indication indication = indicationRepository.indicationById(idIndication);
        indication.setFlagDeleted(true);
    }

    /**
     * Author: ThanhKN
     * Goal:edit indication
     * Date:17/09/2023
     * @param indication
     * return void
     */
    @Override
    public void editIndication(Indication indication) {
        indicationRepository.editIndication(indication);
    }

}
