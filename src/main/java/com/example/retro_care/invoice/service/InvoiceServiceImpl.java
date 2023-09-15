package com.example.retro_care.invoice.service;


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

    @Override
    public Page<Invoice> findAllInvoice(Pageable pageable) {
        return invoiceRepository.findAllInvoice(pageable);
    }

    @Override
    public void deleteInvoice(Long id) {
//        Invoice invoice = invoiceRepository.findByIdInvoice(id);
//        invoice.setFlagDeleted(true);
//        invoiceRepository.save(invoice);
        invoiceRepository.deleteInvoice(id);
    }

    @Override
    public Invoice findById(Long id) {
        return invoiceRepository.findById(id).get();
    }

    @Override
    public List<Invoice> searchInvoice(String start_date, String end_date, String start_time, String end_time, String sort_column) {
        return invoiceRepository.searchInvoice(start_date,end_date,start_time,end_time,sort_column);
    }
}
