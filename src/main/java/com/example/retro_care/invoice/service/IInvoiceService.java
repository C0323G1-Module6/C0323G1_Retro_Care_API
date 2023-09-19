package com.example.retro_care.invoice.service;

import com.example.retro_care.invoice.model.IInvoiceResult;
import com.example.retro_care.invoice.model.Invoice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IInvoiceService {
    /**
     * create an Invoice
     * Code by CuongHLT
     *
     * @param invoice
     * @return Invoice instance
     */
    Invoice createInvoice(Invoice invoice);

    /**
     * Edit an Invoice
     * Code by CuongHLT
     *
     * @param invoice
     * @return void
     */
    void editInvoice(Invoice invoice);

    Invoice getInvoiceById(Long invoiceId);

    /**
     * find and create Next code for invoice
     * Code by CuongHLT
     *
     * @return Next code String
     */
    String findMaxCode();

    /**
     * Create by: HuyHD;
     * Date create: 15/09/2023
     * Function: displays a paginated list of invoice;
     * @return : paginated invoice list with limit number of molecules per page.
     */
    Page<Invoice> findAllInvoice(Pageable pageable);
    Page<IInvoiceResult> findAllInvoiceResult(Pageable pageable);

    void deleteInvoice(Long id);

    Invoice findById(Long id);

   Page<Invoice> searchInvoice(Pageable pageable,
                                     String startDate,
                                     String endDate,
                                     String startTime,
                                     String endTime,
                                     String sortColumn
                              );
}
