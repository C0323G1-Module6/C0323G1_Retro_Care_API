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
            "from prescription p;",nativeQuery = true)
    Page<Prescription> getAllPrescription(Pageable pageable);
    @Query(value = "select p.id, p.code,p.duration, p.flag_deleted,p.name,p.note,p.symptoms,p.patient_id\n" +
            "from prescription p;",nativeQuery = true)
    List<Prescription> getAll();
    @Modifying
    @Query(value = "INSERT INTO prescription ( code, duration, flag_deleted, name, note, symptoms, patient_id) " +
            "                     VALUES (:#{#prescription.code}, :#{#prescription.duration}, :#{#prescription.flagDeleted}" +
            ", :#{#prescription.name}, :#{#prescription.name}, :#{#prescription.note}, :#{#prescription.symptoms}, :#{#prescription.patient})",nativeQuery = true)
    void createPrescription(Prescription prescription);

}
