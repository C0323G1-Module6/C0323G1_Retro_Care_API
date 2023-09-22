package com.example.retro_care.invoice.repository;

import com.example.retro_care.invoice.model.IInvoiceResult;
import com.example.retro_care.invoice.model.Invoice;

import com.example.retro_care.medicine.model.Medicine;
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
    @Query(value = "SELECT i.id, i.app_user_id, i.code, i.creation_date, i.flag_deleted, i.paid, " +
            "s.name, s.address , DATE(i.creation_date) as creationDay, TIME(i.creation_date) as creationTime, " +
            "i.document_number as documentNumber, i.note, sum(m.price * ind.medicine_quantity) as total, " +
            "(sum(m.price * ind.medicine_quantity) - i.paid) as billOwed " +
            "FROM invoice i " +
            "JOIN invoice_detail ind ON i.id = ind.invoice_id " +
            "JOIN medicine m ON m.id = ind.medicine_id " +
            "JOIN supplier s ON s.id = i.supplier_id " +
            "WHERE i.flag_deleted = false " +
            "GROUP BY i.id, i.app_user_id, i.creation_date, i.flag_deleted, i.code, i.paid, " +
            "i.supplier_id, i.document_number, i.note, i.paid " +
            "ORDER BY i.code DESC",
            nativeQuery = true)
    Page<IInvoiceResult> findAllInvoiceResult(Pageable pageable);


    @Query(value = "SELECT i.code, m.id as idMedicine, m.active_element, m.code as codeMedicine, m.maker, m.name as nameMedicine,\n" +
            "       m.note as noteMedicine, m.origin, m.price, m.quantity, m.retail_profits as retailProfits,m.active_element as activeElement, m.vat,\n" +
            "       m.kind_of_medicine_id, k.code as codeKind, k.name as nameKind\n " +
            "        FROM invoice i \n" +
            "        JOIN invoice_detail ind ON i.id = ind.invoice_id\n" +
            "        JOIN medicine m ON m.id = ind.medicine_id\n" +
            "        JOIN supplier s ON s.id = i.supplier_id\n" +
            "        JOIN kind_of_medicine k ON k.id = m.kind_of_medicine_id\n" +
            "WHERE i.id = :id",nativeQuery = true)
    List<IInvoiceResult> getInvoiceDetailById(@Param("id") Long id);
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
     *
     * @return
     */
    @Query(nativeQuery = true, value = "SELECT i.id, i.app_user_id, i.code, i.creation_date, i.flag_deleted, i.paid,\n" +
            "            s.name, s.address,\n" +
            "            DATE(i.creation_date) as creationDay,\n" +
            "            TIME(i.creation_date) as creationTime,\n" +
            "            i.document_number as documentNumber, i.note,\n" +
            "       ROUND((m.price - (m.price * (((m.retail_profits + m.vat) / 100) * ind.discount)))) AS importPrice,\n" +
            "       ROUND(SUM((m.price - (m.price * (((m.retail_profits + m.vat) / 100) * ind.discount)))) * ind.medicine_quantity) AS total,\n" +
            "       ROUND((SUM((m.price - (m.price * (((m.retail_profits + m.vat) / 100) * ind.discount)))) * ind.medicine_quantity) - i.paid) AS billOwed\n" +
            "            FROM invoice i\n" +
            "            JOIN invoice_detail ind ON i.id = ind.invoice_id\n" +
            "            JOIN medicine m ON m.id = ind.medicine_id\n" +
            "            JOIN supplier s ON s.id = i.supplier_id\n" +
            "            WHERE i.flag_deleted = false\n" +
            "            AND (DATE(i.creation_date) >= :start_date OR :start_date IS NULL OR :start_date = '')\n" +
            "            AND (DATE(i.creation_date) <= :end_date OR :end_date IS NULL OR :end_date = '')\n" +
            "            AND (TIME(i.creation_date) >= :start_time OR :start_time IS NULL OR :start_time = '')\n" +
            "            AND (TIME(i.creation_date) <= :end_time OR :end_time IS NULL OR :end_time = '')\n" +
            "            GROUP BY i.id, i.app_user_id, i.creation_date, i.flag_deleted, i.code,\n" +
            "                     i.creation_date, i.paid, i.supplier_id, i.document_number, i.note, \n" +
            "            m.price, m.retail_profits, m.vat,\n" +
            "            ind.discount, ind.medicine_quantity\n" +
            "            ORDER BY i.code DESC" )
    Page<IInvoiceResult> searchInvoiceResult(Pageable pageable,
                                             @Param("start_date") String startDate,
                                             @Param("end_date") String endDate,
                                             @Param("start_time") String startTime,
                                             @Param("end_time") String endTime
                                             );



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
    @Query(value = "call edit_invoice(:#{#invoice.id},:#{#invoice.code},:#{#invoice.documentNumber}, :#{#invoice.creationDate}, :#{#invoice.paid},:#{#invoice.note},0,:#{#invoice.supplierId.id})", nativeQuery = true)
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
