package com.example.retro_care.kind_of_medicine.repository;

import com.example.retro_care.kind_of_medicine.model.KindOfMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IKindOfMedicineRepository extends JpaRepository<KindOfMedicine,Integer> {
//    @Query(value = "select code,name from kind_of_medicine where code like :searchCode && name like :searchName")
}
