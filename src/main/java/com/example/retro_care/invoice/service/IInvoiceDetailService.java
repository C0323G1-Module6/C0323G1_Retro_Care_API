package com.example.retro_care.invoice.service;


import com.example.retro_care.invoice.model.InvoiceDetail;

public interface IInvoiceDetailService {
    void createInvoiceDetail(InvoiceDetail invoiceDetail);

    void deleteInvoiceDetail(Long invoiceId);
}
