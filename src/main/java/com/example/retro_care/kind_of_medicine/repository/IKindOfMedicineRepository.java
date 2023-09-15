package com.example.retro_care.kind_of_medicine.repository;

import com.example.retro_care.kind_of_medicine.model.KindOfMedicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IKindOfMedicineRepository extends JpaRepository<KindOfMedicine,Long> {
//    List
@Query(nativeQuery = true,value = "select k.id,k.code,k.name from kind_of_medicine as k ")
    Page<KindOfMedicine>findAllKindOfMedicine(Pageable pageable);

//Delete
@Query(nativeQuery = true,
        value = "update kind_of_medicine set flag_deleted = true where id = :id and flag_deleted = false")
void deleteKindOfMedicineById(@Param("id") Long id);
}
