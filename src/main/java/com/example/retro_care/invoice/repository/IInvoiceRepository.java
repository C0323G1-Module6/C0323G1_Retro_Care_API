package com.example.retro_care.invoice.repository;

import com.example.retro_care.invoice.model.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {
    /**
     * Create by: HuyHD;
     * Date create: 15/09/2023
     * Function: Retrieves a page of invoice where are the flag_deleted is false.
     *
     * @param pageable the pageable to request a paged result, can be {@link Pageable#unpaged()}, must not be
     *                 {@literal null}.
     * @return
     */
    @Query(value = "select * from invoice where flag_deleted = false", nativeQuery = true)
    Page<Invoice> findAllInvoice(Pageable pageable);

    /**
     * Create by: HuyHD;
     * Date create: 15/09/2023
     * Function: Delete an invoice by setting the flag_deleted to true based on the provided employee id.
     *
     * @param id the id of the employee to be  deleted.
     */
    @Transactional
    @Modifying
    @Query(value = "update invoice set flag_deleted = true where id = :id", nativeQuery = true)
    void deleteInvoice(@Param("id") Long id);

    @Query(nativeQuery = true, value = "select * from ivoice where id = :id")
    Invoice findByIdInvoice(@Param("id") Long id);

//    @Transactional
//    @Modifying

    /**
     * Create by: HuyHD;
     * Date create: 15/09/2023;
     * Function: Search by invoice creation time, and sort by column;
     *
     * @param start_date
     * @param end_date
     * @param start_time
     * @param end_time
     * @param sort_column
     * @return
     */
    @Query(nativeQuery = true, value = "SELECT *\n" +
            "FROM invoice \n" +
            "WHERE \n" +
            "  (DATE(creation_date) >= :start_date OR :start_date IS NULL)\n" +
            "  AND (DATE(creation_date) <= :end_date OR :end_date IS NULL)\n" +
            "  AND (TIME(creation_date) >= :start_time OR :start_time IS NULL)\n" +
            "  AND (TIME(creation_date) <= :end_time OR :end_time IS NULL)\n" +
            "ORDER BY CASE\n" +
            "  WHEN :sort_column = 'code' THEN code\n" +
            "  WHEN :sort_column = 'creation_date' THEN creation_date\n" +
            "  WHEN :sort_column = 'paid' THEN paid\n" +
            "END ASC;")
    List<Invoice> searchInvoice(
            @Param("start_date") String start_date,
            @Param("end_date") String end_date,
            @Param("start_time") String start_time,
            @Param("end_time") String end_time,
            @Param("sort_column") String sort_column);

    /**
     * create an Invoice
     * Code by CuongHLT
     *
     * @param invoice
     * @return Invoice
     */
    @Query(value = "Call create_invoice (:#{#invoice.code},:#{#invoice.documentNumber},:#{#invoice.creationDate},:#{#invoice.paid},:#{#invoice.note},0,:#{#invoice.supplierId.id},:#{#invoice.appUserId.id}) ", nativeQuery = true)
    @Transactional
    Invoice createInvoice(@Param("invoice") Invoice invoice);


    /**
     * get an Invoice
     * Code by CuongHLT
     *
     * @param invoiceId a number
     * @return Invoice
     */
    @Query(value = "select id,code,document_number,creation_date,paid,note,flag_deleted,supplier_id,app_user_id from invoice where id = :invoiceId and flag_deleted = 0", nativeQuery = true)
    Invoice getInvoiceById(@Param("invoiceId") Long invoiceId);

    @Transactional
    @Query(value = "call edit_invoice(:#{#invoice.id},:#{#invoice.documentNumber}, :#{#invoice.paid},:#{#invoice.note},:#{#invoice.supplierId.id})", nativeQuery = true)
    Invoice editInvoice(@Param("invoice") Invoice invoice);

    /**
     * find Max code in DB
     * Code by CuongHLT
     *
     * @return Next code String
     */
    @Query(value = "SELECT MAX(code) FROM invoice where flag_deleted = 0", nativeQuery = true)
    String findMaxCode();

}
