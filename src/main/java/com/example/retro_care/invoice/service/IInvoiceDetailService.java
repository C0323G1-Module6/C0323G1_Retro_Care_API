package com.example.retro_care.invoice.service;


import com.example.retro_care.invoice.model.InvoiceDetail;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IInvoiceDetailService {
    void createInvoiceDetail(InvoiceDetail invoiceDetail);

    void deleteInvoiceDetail(Long invoiceId);

    List<InvoiceDetail> getInvoiceDetailByInvoiceId(Long invoiceId);
}
