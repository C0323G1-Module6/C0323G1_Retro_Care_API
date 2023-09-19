package com.example.retro_care.medicine.repository;

import com.example.retro_care.medicine.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUnitRepository extends JpaRepository<Unit, Long> {
    /**
     * Retrieve a list of all Units-TinVV
     *
     * @return A list of all Units.
     */
    @Query(value = "SELECT u.id, u.name, u.flag_deleted FROM retro_care.unit as u", nativeQuery = true)
    List<Unit> findAll();
}
