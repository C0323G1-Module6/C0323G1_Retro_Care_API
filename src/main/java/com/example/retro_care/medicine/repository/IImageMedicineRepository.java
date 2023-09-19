package com.example.retro_care.medicine.repository;

import com.example.retro_care.medicine.model.ImageMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface IImageMedicineRepository extends JpaRepository<ImageMedicine, Long> {
    /**
     * Add an ImageMedicine to the database-TinVV
     *
     * @param imagePath  The path of the image to be added.
     * @param medicineId The ID of the associated medicine.
     */
    @Modifying
    @Query(value = "INSERT INTO image_medicine (image_path, flag_deleted, medicine_id) VALUES " +
            "(:imagePath, 0, :medicineId)", nativeQuery = true)
    void addImageMedicine(@Param("imagePath") String imagePath, @Param("medicineId") Long medicineId);

    /**
     * Update the image path of an existing ImageMedicine in the database-TinVV
     *
     * @param imagePath  The updated image path.
     * @param medicineId The ID of the associated medicine.
     */
    @Modifying
    @Query(value = "UPDATE image_medicine SET image_path = :imagePath WHERE medicine_id = :medicineId", nativeQuery = true)
    void updateImageMedicine(@Param("imagePath") String imagePath, @Param("medicineId") Long medicineId);

    /**
     * Retrieve a list of ImageMedicine objects associated with a specific medicine ID-TinVV
     *
     * @param medicineId The ID of the medicine.
     * @return A list of ImageMedicine objects associated with the given medicine ID.
     */
    @Query(value = "SELECT i.id, i.image_path FROM image_medicine as i WHERE medicine_id = :medicineId", nativeQuery = true)
    Set<ImageMedicine> findImageMedicineByMedicineId(@Param("medicineId") Long medicineId);
}
