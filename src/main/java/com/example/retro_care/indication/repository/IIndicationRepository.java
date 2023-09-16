package com.example.retro_care.indication.repository;

import com.example.retro_care.indication.model.Indication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IIndicationRepository extends JpaRepository<Indication, Long> {
    @Query(value = "select i.id,i.dosage,i.frequency,i.prescription_id,i.flag_deleted " +
            "from indication i where i.prescription_id = :#{#idPrescription} and i.flag_deleted = 0 ;", nativeQuery = true)
    List<Indication> getAllIndication(Long idPrescription);

    @Modifying
    @Query(value = "INSERT INTO indication (dosage, frequency, flag_deleted, prescription_id, medicine_id) " +
            "values (:#{#indication.dosage},:#{#indication.frequency},:#{#indication.flagDeleted},:#{#indication.prescription},:#{#indication.medicine})", nativeQuery = true)
    void createIndication(Indication indication);

    @Query(value = "select i.id,i.dosage,i.frequency,i.prescription_id,i.flag_deleted " +
            "from indication i where i.id = :#{#idIndication} and i.flag_deleted = 0 ;", nativeQuery = true)
    Indication indicationById(Long idIndication);

    @Modifying
    @Query(value = "UPDATE indication set dosage = :#{#indication.dosage}, frequency = :#{#indication.frequency} where id = :#{#indication.id}",nativeQuery = true)
    void editIndication(Indication indication);
}
