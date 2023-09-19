package com.example.retro_care.prescription.repository;

import com.example.retro_care.prescription.model.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.List;

public interface IPrescriptionRepository extends JpaRepository<Prescription, Long> {

    /**
     * Author: ThanhKN
     * Goal:get all prescription
     * Return page prescription
     * Date:17/09/2023
     * @param pageable
     */
    @Query(value = "select p.id, p.code,p.duration, p.flag_deleted,p.name,p.note,p.symptoms,p.patient_id\n " +
            "from prescription p " +
            "where p.flag_deleted = 0 ", nativeQuery = true)
    Page<Prescription> getAllPrescription(Pageable pageable);

    /**
     * Author: ThanhKN
     * Goal:get all prescription
     * Return list prescription
     * Date:17/09/2023
     */
    @Query(value = "select p.id, p.code,p.duration, p.flag_deleted,p.name,p.note,p.symptoms,p.patient_id\n" +
            "from prescription p;", nativeQuery = true)
    List<Prescription> getAll();

    /**
     * Author: ThanhKN
     * Goal:get all prescription
     * Return void
     * Date:17/09/2023
     * @param prescription
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prescription ( code, duration, flag_deleted, name, note, symptoms, patient_id) " +
            "                     VALUES (:#{#prescription.code}, :#{#prescription.duration}, :#{#prescription.flagDeleted}" +
            ", :#{#prescription.name}, :#{#prescription.note}, :#{#prescription.symptoms}, :#{#prescription.patient})", nativeQuery = true)
    void createPrescription(Prescription prescription);

    /**
     * Author: ThanhKN
     * Goal:get prescription by id
     * Return prescription
     * Date:17/09/2023
     * @param idPrescription
     */
    @Query(value = "SELECT p.id, p.code,p.duration, p.flag_deleted,p.name,p.note,p.symptoms,p.patient_id\n" +
            " FROM prescription p WHERE id = :#{#idPrescription}", nativeQuery = true)
    Prescription getPrescriptionById(Long idPrescription);


    /**
     * Author: ThanhKN
     * Goal:edi prescription by id
     * Return void
     * Date:17/09/2023
     * @param prescription
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE prescription SET code = :#{#prescription.code}, duration = :#{#prescription.duration}, " +
            "name = :#{#prescription.name}, note = :#{#prescription.note}, symptoms = :#{#prescription.symptoms}, " +
            "patient_id = :#{#prescription.patient.id} WHERE id = :#{#prescription.id}", nativeQuery = true)
    Integer editPrescription(@Param("prescription") Prescription prescription);

    /**
     * Author: ThanhKN
     * Goal:remove prescription by id
     * Return void
     * Date:17/09/2023
     * @param idPrescription
     */
    @Transactional
    @Modifying
    @Query("UPDATE Prescription SET flagDeleted = 1 WHERE id = :idPrescription")
    void removePrescription(Long idPrescription);

}
