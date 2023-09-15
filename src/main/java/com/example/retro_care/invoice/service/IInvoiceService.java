package com.example.retro_care.invoice.service;

import com.example.retro_care.invoice.model.Invoice;

public interface IInvoiceService {
    Invoice createInvoice(Invoice invoice);

    Invoice editInvoice(Invoice invoice);

    Invoice getInvoiceById(Long invoiceId);

}
