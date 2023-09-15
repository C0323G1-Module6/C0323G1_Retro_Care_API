package com.example.retro_care.medicine.service;

import com.example.retro_care.medicine.model.Unit;
import com.example.retro_care.medicine.repository.IUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UnitService implements IUnitService{
    @Autowired
    private IUnitRepository iUnitRepository;
    @Override
    public List<Unit> findAll() {
        return iUnitRepository.findAll();
    }
}
