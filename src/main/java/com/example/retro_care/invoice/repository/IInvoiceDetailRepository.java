package com.example.retro_care.invoice.repository;

import com.example.retro_care.invoice.model.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {
    /**
     * Create an invoiceDetail
     * Code by CuongHLT
     * @param invoiceDetail Return void
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `invoice_detail` (`discount`, `medicine_quantity`,`expiry`, `lot`, `flag_deleted`, `medicine_id`, `invoice_id`)" +
            " VALUES (:#{#invoiceDetail.discount},:#{#invoiceDetail.medicineQuantity},:#{#invoiceDetail.expiry},:#{#invoiceDetail.lot},0,:#{#invoiceDetail.medicineId.id},:#{#invoiceDetail.invoiceId.id})", nativeQuery = true)
    void createInvoiceDetail(@Param("invoiceDetail") InvoiceDetail invoiceDetail);
}
