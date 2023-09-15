package com.example.retro_care.medicine.service;

import com.example.retro_care.medicine.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMedicineService {
    Page<Medicine> findAll(Pageable pageable);
}
