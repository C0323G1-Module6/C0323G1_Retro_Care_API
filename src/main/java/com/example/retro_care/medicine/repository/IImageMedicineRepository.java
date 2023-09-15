package com.example.retro_care.medicine.repository;

import com.example.retro_care.medicine.model.ImageMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IImageMedicineRepository extends JpaRepository<ImageMedicine,Long> {
    @Modifying
    @Query(value = "INSERT INTO image_medicine (image_path, flag_deleted, medicine_id) VALUES " +
            "(:imagePath, 0, :medicineId)", nativeQuery = true)
    void addImageMedicine(@Param("imagePath") String imagePath, @Param("medicineId") Long medicineId);
    @Modifying
    @Query(value = "UPDATE image_medicine SET image_path = :imagePath WHERE medicine_id = :medicineId", nativeQuery = true)
    void updateImageMedicine(@Param("imagePath") String imagePath, @Param("medicineId") Long medicineId);
    @Query(value = "SELECT i.id, i.image_path FROM image_medicine as i WHERE medicine_id = :medicineId", nativeQuery = true)
    List<ImageMedicine> findImageMedicineByMedicineId(@Param("medicineId") Long medicineId);
}
