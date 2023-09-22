package com.example.retro_care.invoice.service;

import com.example.retro_care.invoice.model.IInvoiceResult;
import com.example.retro_care.invoice.model.Invoice;
import com.example.retro_care.invoice.model.InvoiceDto;
import com.example.retro_care.medicine.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IInvoiceService {
    /**
     * create an Invoice
     * Code by CuongHLT
     *
     * @param invoice
     * @return Invoice instance
     */
    Invoice createInvoice(Invoice invoice, InvoiceDto invoiceDto);

    /**
     * Edit an Invoice
     * Code by CuongHLT
     *
     * @param invoice
     * @return void
     */
    Invoice editInvoice(Invoice invoice, InvoiceDto invoiceDto);

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
     *
     * @param : page (page number), limit(number of elements in the page);
     * @return : paginated invoice list with limit number of molecules per page.
     */
    Page<IInvoiceResult> findAllInvoiceResult(Pageable pageable);

    void deleteInvoice(Long id);

    Invoice findById(Long id);
    List<IInvoiceResult> getInvoiceDetailById(Long id);


    Page<IInvoiceResult> searchInvoiceResult(Pageable pageable,
                                String startDate,
                                String endDate,
                                String startTime,
                                String endTime

    );
}
