package com.example.retro_care.invoice.repository;

import com.example.retro_care.invoice.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {
    /**
     * create an Invoice
     * Code by CuongHLT
     *
     * @param invoice
     * @return Invoice
     */
    @Query(value = "Call create_invoice (:#{#invoice.code},:#{#invoice.documentNumber},:#{#invoice.creationDate},:#{#invoice.paid},:#{#invoice.note},:#{#invoice.flagDeleted},:#{#invoice.supplierId.id},:#{#invoice.appUserId.id}) ", nativeQuery = true)
    @Transactional
    Invoice createInvoice(@Param("invoice") Invoice invoice);

    /**
     * edit an Invoice
     * Code by CuongHLT
     *
     * @param invoice
     * @return Invoice
     */
    @Query(value = "Call create_invoice (:#{#invoice.id},:#{#invoice.code},:#{#invoice.documentNumber},:#{#invoice.creationDate},:#{#invoice.paid},:#{#invoice.note},:#{#invoice.flagDeleted},:#{#invoice.supplierId},:#{#invoice.appUserId})", nativeQuery = true)
    @Transactional
    @Modifying
    Invoice editInvoice(@Param("invoice") Invoice invoice);

    /**
     * get an Invoice
     * Code by CuongHLT
     *
     * @param invoiceId a number
     * @return Invoice
     */
    @Query(value = "select id,code,document_number,creation_date,paid,note,flag_deleted,supplier_id,app_user_id from invoice where id = :invoiceId", nativeQuery = true)
    Invoice getInvoiceById(@Param("invoiceId") Long invoiceId);

}
