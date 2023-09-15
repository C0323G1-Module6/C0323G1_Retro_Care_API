package com.example.retro_care.indication.repository;

import com.example.retro_care.indication.model.Indication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IIndicationRepository extends JpaRepository<Indication, Long> {
    @Query(value = "select i.id,i.dosage,i.frequency,i.prescription_id,i.flag_deleted " +
            "from indication i where i.id = :#{idPrescription};", nativeQuery = true)
    List<Indication> getAllIndication(int idPrescription);

    @Modifying
    @Query(value = "INSERT INTO indication (dosage, frequency, flag_deleted, prescription_id, medicine_id) " +
            "values (:#{#indication.dosage},:#{#indication.frequency},:#{#indication.flagDeleted},:#{#indication.prescription},:#{indication.medicine})", nativeQuery = true)
    void createIndication(Indication indication);
}
