package com.example.retro_care.medicine.repository;

import com.example.retro_care.medicine.model.ImageMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IImageMedicineRepository extends JpaRepository<ImageMedicine, Long> {
    /**
     * Adds an ImageMedicine to the database for a given medicine-TinVV
     *
     * @param imageMedicine The ImageMedicine object to be added.
     * @param medicineId    The ID of the medicine associated with the ImageMedicine.
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO image_medicine (image_path, flag_deleted, medicine_id) VALUES " +
            "(:#{#imageMedicine.imagePath}, false, :medicineId)", nativeQuery = true)
    void addImageMedicine(@Param("imageMedicine") ImageMedicine imageMedicine, Long medicineId);

    /**
     * Updates the image path of an ImageMedicine associated with a specific medicine in the database-TinVV
     *
     * @param imageMedicine The updated ImageMedicine object containing the new image path.
     * @param medicineId    The ID of the medicine associated with the ImageMedicine.
     */

    @Transactional
    @Modifying
    @Query(value = "UPDATE image_medicine SET image_path = :#{#imageMedicine.imagePath} WHERE medicine_id = :medicineId", nativeQuery = true)
    void updateImageMedicine(@Param("imageMedicine") ImageMedicine imageMedicine, Long medicineId);

    /**
     * Retrieve a list of ImageMedicine objects associated with a specific medicine ID-TinVV
     *
     * @param medicineId The ID of the medicine.
     * @return A list of ImageMedicine objects associated with the given medicine ID.
     */
    @Query(value = "SELECT i.id, i.image_path, i.medicine_id, i.flag_deleted FROM image_medicine as i WHERE medicine_id = :medicineId", nativeQuery = true)
    ImageMedicine findImageMedicineByMedicineId(@Param("medicineId") Long medicineId);
}
