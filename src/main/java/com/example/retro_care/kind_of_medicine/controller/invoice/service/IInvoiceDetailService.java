package com.example.retro_care.kind_of_medicine.controller.invoice.service;

import com.example.retro_care.kind_of_medicine.controller.invoice.model.InvoiceDetail;

import java.util.List;

public interface IInvoiceDetailService {
    List<InvoiceDetail> getInvoiceDetails(Long invoiceId);
}
