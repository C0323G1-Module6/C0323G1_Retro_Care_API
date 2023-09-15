package com.example.retro_care.medicine.repository;

import com.example.retro_care.medicine.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicineRepository extends JpaRepository<Medicine, Long> {

    Page<Medicine> findAll(Pageable pageable);

}
