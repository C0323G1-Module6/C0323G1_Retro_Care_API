package com.example.retro_care.medicine.service;

import com.example.retro_care.medicine.model.Unit;

import java.util.List;

public interface IUnitService {
    /**
     * Retrieve a list of all Units-TinVV
     *
     * @return A list of all Units.
     */
    List<Unit> findAll();
}
