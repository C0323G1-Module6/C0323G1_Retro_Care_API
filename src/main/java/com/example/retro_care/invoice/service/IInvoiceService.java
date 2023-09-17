package com.example.retro_care.invoice.service;

import com.example.retro_care.invoice.model.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;


import com.example.retro_care.invoice.model.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface IInvoiceService {
    /**
     * create an Invoice
     * Code by CuongHLT
     * @param invoice
     * @return Invoice instance
     */
    Invoice createInvoice(Invoice invoice);

    Invoice getInvoiceById(Long invoiceId);
    /**
     * find and create Next code for invoice
     * Code by CuongHLT
     * @return Next code String
     */
    String findMaxCode();

    /**
     * Create by: HuyHD;
     * Date create: 15/09/2023
     * Function: displays a paginated list of invoice;
     *
     * @param : page (page number), limit(number of elements in the page);
     * @return : paginated invoice list with limit number of molecules per page.
     */
    Page<Invoice> findAllInvoice(Pageable pageable);
    void deleteInvoice(Long id);
    Invoice findById(Long id);
    List<Invoice> searchInvoice(String start_date,
                                String end_date,
                                String start_time,
                                String end_time,
                                String sort_column);
}
