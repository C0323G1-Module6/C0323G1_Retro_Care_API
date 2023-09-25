package com.example.retro_care.invoice.service;

import com.example.retro_care.invoice.model.InvoiceDetail;
import com.example.retro_care.invoice.repository.IInvoiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailServiceImpl implements IInvoiceDetailService {
    @Autowired
    IInvoiceDetailRepository invoiceDetailRepository;

    @Override
    public List<InvoiceDetail> getInvoiceDetails(Long invoiceId) {
        return invoiceDetailRepository.getInvoiceDetails(invoiceId);
    }
}
