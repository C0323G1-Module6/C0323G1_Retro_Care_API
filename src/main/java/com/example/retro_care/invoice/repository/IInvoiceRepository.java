package com.example.retro_care.invoice.repository;

import com.example.retro_care.invoice.model.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
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
    @Query(value = "SELECT i.id,i.app_user_id, i.code,i.creation_date,i.flag_deleted,i.paid,i.supplier_id," +
            " DATE(i.creation_date) as creation_day, TIME(i.creation_date) as creation_time,\n" +
            "       i.document_number, i.note, sum(m.price * ind.medicine_quantity) as total,\n" +
            "       (sum(m.price * ind.medicine_quantity) - i.paid) as bill_owed\n" +
            "FROM invoice i\n" +
            "         JOIN invoice_detail ind ON i.id = ind.invoice_id_id\n" +
            "         JOIN medicine m ON m.id = ind.medicine_id_id\n" +
            "WHERE i.flag_deleted = false\n" +
            "GROUP BY i.id,i.app_user_id,i.creation_date,i.flag_deleted, i.code, i.creation_date,i.paid," +
            " i.supplier_id,i.document_number, i.note, i.paid", nativeQuery = true)
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
    @Query(nativeQuery = true, value = "SELECT i.id,i.app_user_id, i.code,i.creation_date,i.flag_deleted,i.paid,i.supplier_id," +
            " DATE(i.creation_date) as creation_day, TIME(i.creation_date) as creation_time,\n" +
            "       i.document_number, i.note, sum(m.price * ind.medicine_quantity) as total,\n" +
            "       (sum(m.price * ind.medicine_quantity) - i.paid) as bill_owed\n" +
            "FROM invoice i\n" +
            "         JOIN invoice_detail ind ON i.id = ind.invoice_id_id\n" +
            "         JOIN medicine m ON m.id = ind.medicine_id_id\n" +
            "WHERE i.flag_deleted = false\n" +

            "  AND (DATE(i.creation_date) >= :start_date OR :start_date IS NULL)\n" +
            "  AND (DATE(i.creation_date) <= :end_date OR :end_date IS NULL)\n" +
            "  AND (TIME(i.creation_date) >= :start_time OR :start_time IS NULL)\n" +
            "  AND (TIME(i.creation_date) <= :end_time OR :end_time IS NULL)\n" +
            "GROUP BY i.id, i.app_user_id, i.creation_date, i.flag_deleted, i.code, i.creation_date, i.paid," +
            " i.supplier_id, i.document_number, i.note, i.paid\n" +
            "ORDER BY CASE\n" +
            "  WHEN :sort_column = '1' THEN i.code\n" +
            "  WHEN :sort_column = '2' THEN i.document_number\n" +
            "  WHEN :sort_column = '3' THEN creation_time\n" +
            "  WHEN :sort_column = '4' THEN creation_day\n" +
            "  WHEN :sort_column = '5' THEN total\n" +
            "  WHEN :sort_column = '6' THEN bill_owed\n" +
            "  WHEN :sort_column = '7' THEN i.supplier_id_id\n" +
            "END DESC")
    Page<Invoice> searchInvoice(Pageable pageable,
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
    @Query(value = "Call create_invoice (:#{#invoice.code},:#{#invoice.documentNumber},:#{#invoice.creationDate},:#{#invoice.paid},:#{#invoice.note},:#{#invoice.flagDeleted},:#{#invoice.supplierId.id},:#{#invoice.appUserId.id}) ", nativeQuery = true)
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

    @Query(value = "UPDATE invoice SET document_number = :#{#invoice.documentNumber},creation_date = :#{#invoice.creationDate},paid = :#{#invoice.paid},note = :#{#invoice.note},supplier_id =:#{#invoice.supplierId.id} ,app_user_id= :#{#invoice.appUserId.id} where id = :#{#invoice.id}", nativeQuery = true)
    Invoice editInvoice(@Param("invoice") Invoice invoice);

    /**
     * find Max code in DB
     * Code by CuongHLT
     *
     * @return Next code String
     */
    @Query(value = "SELECT MAX(code) FROM invoice", nativeQuery = true)
    String findMaxCode();

}
