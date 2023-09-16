package com.example.retro_care.prescription.repository;

import com.example.retro_care.prescription.model.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPrescriptionRepository extends JpaRepository<Prescription,Long> {
    @Query(value = "select p.id, p.code,p.duration, p.flag_deleted,p.name,p.note,p.symptoms,p.patient_id\n" +
            "from prescription p " +
            "where p.flag_deleted = 0;",nativeQuery = true)
    Page<Prescription> getAllPrescription(Pageable pageable);
    @Query(value = "select p.id, p.code,p.duration, p.flag_deleted,p.name,p.note,p.symptoms,p.patient_id\n" +
            "from prescription p;",nativeQuery = true)
    List<Prescription> getAll();
    @Modifying
    @Query(value = "INSERT INTO prescription ( code, duration, flag_deleted, name, note, symptoms, patient_id) " +
            "                     VALUES (:#{#prescription.code}, :#{#prescription.duration}, :#{#prescription.flagDeleted}" +
            ", :#{#prescription.name}, :#{#prescription.name}, :#{#prescription.note}, :#{#prescription.symptoms}, :#{#prescription.patient})",nativeQuery = true)
    void createPrescription(Prescription prescription);

    @Modifying
    @Query(value = "SELECT * FROM indication WHERE id = :#{#idPrescription}",nativeQuery = true)
    Prescription getPrescriptionById(Long idPrescription);

    @Modifying
    @Query(value = "UPDATE prescription set code = :#{#prescription.code}, duration = :#{#prescription.flagDeleted}, " +
            ":#{#prescription.name}, :#{#prescription.note}, :#{#prescription.symptoms}, :#{#prescription.patient} where id = :#{#prescription.id}",nativeQuery = true)
    void editPrescription(Prescription prescription);

}
