package com.example.retro_care.invoice.service;

import com.example.retro_care.invoice.model.InvoiceDetail;
import com.example.retro_care.invoice.repository.IInvoiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailServiceImpl implements IInvoiceDetailService {
    @Autowired
    IInvoiceDetailRepository invoiceDetailRepository;

    /**
     * Create an invoiceDetail
     * Code by CuongHLT
     *
     * @param invoiceDetail Return void
     */
    @Override
    public void createInvoiceDetail(InvoiceDetail invoiceDetail) {
        invoiceDetailRepository.createInvoiceDetail(invoiceDetail);
    }

    /**
     * Delete a invoiceDetail
     * code by CuongHLT
     *
     * @param invoiceId return void
     */
    @Override
    public void deleteInvoiceDetail(Long invoiceId) {
        invoiceDetailRepository.deleteInvoiceDetail(invoiceId);
    }

    @Override
    public List<InvoiceDetail> getInvoiceDetailByInvoiceId(Long invoiceDetailId) {
        return invoiceDetailRepository.getInvoiceDetailByInvoiceId(invoiceDetailId);
    }

}
