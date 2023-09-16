package com.example.retro_care.invoice.service;

import com.example.retro_care.invoice.model.Invoice;
import com.example.retro_care.invoice.repository.IInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements IInvoiceService {
    @Autowired
    IInvoiceRepository invoiceRepository;

    /**
     * create an Invoice
     * Code by CuongHLT
     *
     * @param invoice
     * @return Invoice
     */
    @Override
    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.createInvoice(invoice);
    }

    /**
     * edit an Invoice
     * Code by CuongHLT
     *
     * @param invoice
     * @return Invoice
     */
    @Override
    public Invoice editInvoice(Invoice invoice) {
        return invoiceRepository.editInvoice(invoice);
    }

    /**
     * get an Invoice
     * Code by CuongHLT
     *
     * @param invoiceId a number
     * @return Invoice
     */
    @Override
    public Invoice getInvoiceById(Long invoiceId) {
        return invoiceRepository.getInvoiceById(invoiceId);

import com.example.retro_care.invoice.model.Invoice;
import com.example.retro_care.invoice.repository.IInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class InvoiceServiceImpl implements IInvoiceService {
  @Autowired
  private IInvoiceRepository invoiceRepository;

    /**
     * Create by: HuyHD;
     * Date create: 15/09/2023;
     * @param pageable
     * @return
     */

    @Override
    public Page<Invoice> findAllInvoice(Pageable pageable) {
        return invoiceRepository.findAllInvoice(pageable);
    }

    /**
     * Create by: HuyHD;
     * Date create: 15/09/2023
     * Function: delete invoice with invoice code ? ;
     *
     * @param : id (id_invoice);
     * @return : new invoice list does not exist newly deleted element.
     */
    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteInvoice(id);
    }

    @Override
    public Invoice findById(Long id) {
        return invoiceRepository.findById(id).get();
    }
    /**
     *Create by: HuyHD;
     * Date create: 15/09/2023
     * Function: Search by invoice creation time, and sort by column;
     * @param start_date
     * @param end_date
     * @param start_time
     * @param end_time
     * @param sort_column
     * @return
     */
    @Override
    public List<Invoice> searchInvoice(String start_date, String end_date, String start_time, String end_time, String sort_column) {
        return invoiceRepository.searchInvoice(start_date,end_date,start_time,end_time,sort_column);
    }
}
