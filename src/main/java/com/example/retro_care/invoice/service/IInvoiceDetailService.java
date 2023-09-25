package com.example.retro_care.invoice.service;

import com.example.retro_care.invoice.model.InvoiceDetail;

import java.util.List;

public interface IInvoiceDetailService {
    List<InvoiceDetail> getInvoiceDetails(Long invoiceId);
}
