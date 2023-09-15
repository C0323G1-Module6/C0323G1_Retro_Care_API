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
    }
}
