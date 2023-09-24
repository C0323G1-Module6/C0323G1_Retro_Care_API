package com.example.retro_care.patient.repository;

import com.example.retro_care.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPatientRepository extends JpaRepository<Patient,Long> {
    /**
     * Author: ThanhKN
     * Goal:get all patient
     * Return void
     * Date:17/09/2023
     */
    @Query(value = "select p.id,p.name ,p.flag_deleted from patient p",nativeQuery = true)
    List<Patient> getAllPatient();
}
