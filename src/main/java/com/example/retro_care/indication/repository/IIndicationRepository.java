package com.example.retro_care.indication.repository;

import com.example.retro_care.indication.model.Indication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IIndicationRepository extends JpaRepository<Indication, Long> {
    /**
     * Author: ThanhKN
     * Goal:get all indication
     * Return List indication
     * Date:17/09/2023
     */
    @Modifying
    @Transactional
    @Query(value = "select i.id,i.dosage,i.frequency,i.prescription_id,i.flag_deleted, i.medicine_id " +
            "from indication i where i.prescription_id = :#{#idPrescription} and i.flag_deleted = 0 ;", nativeQuery = true)
    List<Indication> getAllIndication(Long idPrescription);

    /**
     * Author: ThanhKN
     * Goal:Create indication
     * Date:17/09/2023
     * @param indication
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO indication (dosage, frequency, flag_deleted, prescription_id) " +
            "values (:#{#indication.dosage},:#{#indication.frequency},:#{#indication.flagDeleted},:#{#indication.prescription},:#{#indication.medicine})", nativeQuery = true)
    void createIndication(Indication indication);

    /**
     * Author: ThanhKN
     * Goal:Get indication by id
     * Date:17/09/2023
     * @param idIndication
     */
    @Modifying
    @Transactional
    @Query(value = "select i.id,i.dosage,i.frequency,i.prescription_id,i.flag_deleted " +
            "from indication i where i.id = :#{#idIndication} and i.flag_deleted = 0 ;", nativeQuery = true)
    Indication indicationById(Long idIndication);

    /**
     * Author: ThanhKN
     * Goal:edit indication by id
     * Date:17/09/2023
     * @param indication
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE indication set dosage = :#{#indication.dosage}, frequency = :#{#indication.frequency} where id = :#{#indication.id}",nativeQuery = true)
    void editIndication(Indication indication);

    /**
     * Author: ThanhKN
     * Goal:remove indication by id
     * Date:17/09/2023
     * @param idIndication
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE indication SET flag_deleted = 1 WHERE id = :idIndication",nativeQuery = true)
    void removePrescription(Long idIndication);
}