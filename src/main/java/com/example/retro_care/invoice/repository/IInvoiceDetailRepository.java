package com.example.retro_care.invoice.repository;

import com.example.retro_care.invoice.model.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {
    /**
     * Create an invoiceDetail
     * Code by CuongHLT
     *
     * @param invoiceDetail
     * Return void
     */
    @Query(value = "INSERT INTO `invoice_detail` (`discount`, `medicine_quantity`, `lot`, `flag_deleted`, `medicine_id`, `invoice_id`) VALUES (:#{#invoiceDetail.discount},:#{#invoiceDetail.medicineQuantity}, :#{#invoiceDetail.lot},0, :#{#invoiceDetail.medicineId}, :#{#invoiceDetail.invoiceId});", nativeQuery = true)
    void createInvoiceDetail(@Param("invoiceDetail") InvoiceDetail invoiceDetail);

    /**
     * Delete a invoiceDetail
     * code by CuongHLT
     *
     * @param invoiceId
     * return void
     */
    @Query(value = "DELETE FROM invoice_detail WHERE invoid_id = :invoiceId", nativeQuery = true)
    void deleteInvoiceDetail(@Param("invoiceId") Long invoiceId);

}
