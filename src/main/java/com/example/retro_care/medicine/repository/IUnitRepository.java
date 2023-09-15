package com.example.retro_care.medicine.repository;

import com.example.retro_care.medicine.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUnitRepository extends JpaRepository<Unit,Long> {
    @Query(value = "SELECT u.id, u.name FROM retro_care.unit as u;",nativeQuery = true)
    List<Unit> findAll();
}
