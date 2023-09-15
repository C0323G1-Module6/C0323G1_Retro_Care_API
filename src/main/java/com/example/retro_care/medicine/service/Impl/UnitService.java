package com.example.retro_care.medicine.service.Impl;

import com.example.retro_care.medicine.model.Unit;
import com.example.retro_care.medicine.repository.IUnitRepository;
import com.example.retro_care.medicine.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService implements IUnitService {
    @Autowired
    private IUnitRepository iUnitRepository;

    /**
     * Retrieve all units from the system-TinVV
     *
     * @return A list of all units in the system.
     */
    @Override
    public List<Unit> findAll() {
        return iUnitRepository.findAll();
    }
}
