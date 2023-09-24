package com.example.retro_care.kind_of_medicine.repository;

import com.example.retro_care.kind_of_medicine.dto.IKindOfMedicineDto;
import com.example.retro_care.kind_of_medicine.model.KindOfMedicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface IKindOfMedicineRepository extends JpaRepository<KindOfMedicine, Long> {
    /**
     * method :findAllKindOfMedicine()
     * created by :CaoNv
     * date create: 14/09/2023
     *
     * @param: Long id
     * return KndOfMedicine
     */
    //    List
    @Query(nativeQuery = true, value =
            "select k.id,k.code,k.name " +
                    "from kind_of_medicine as k " +
                    "where k.flag_deleted = 0 " +
                    "AND k.code like :searchCode " +
                    "AND k.name like :searchName ")
    Page<IKindOfMedicineDto> findAllKindOfMedicine(Pageable pageable,
                                                   @Param("searchCode") String searchCode,
                                                   @Param("searchName") String searchName);
    /**
     * method :deleteKindOfMedicineById()
     * created by :CaoNv
     * date create: 14/09/2023
     *
     * @param: Long id
     * return void
     */
    //Delete
    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "update kind_of_medicine k set k.flag_deleted = 1 where k.id = :id ")
    void deleteKindOfMedicineById(@Param("id") Long id);

// get by id

    /**
     * method :getKindOfMedicineById()
     * created by :CaoNv
     * date create: 14/09/2023
     *
     * @param: Long id
     * return KindOfMedicine
     */

    @Query(nativeQuery = true,
            value = "select kind_of_medicine.id,kind_of_medicine.code,kind_of_medicine.name from kind_of_medicine where id = :id and flag_deleted = false")
    KindOfMedicine getKindOfMedicineById(@Param("id") Long id);

    // get id max

    @Query(nativeQuery = true, value = "select max(id) from kind_of_medicine")
    int getMaxId();

}