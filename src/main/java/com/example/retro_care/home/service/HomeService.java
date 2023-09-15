package com.example.retro_care.home.service;

import com.example.retro_care.home.repository.HomeRepository;
import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.medicine.repository.IMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService implements IHomeService {
    @Autowired
    private HomeRepository homeRepository;

    @Override
    public List<Medicine> findAllMedicineForHomepage() {
        return homeRepository.findAll();
    }

    @Override
    public List<Medicine> searchMedicineForHomepage(String name) {
        return null;
    }
}
