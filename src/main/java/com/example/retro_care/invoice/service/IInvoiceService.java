package com.example.retro_care.invoice.service;

import com.example.retro_care.invoice.model.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface IInvoiceService {
    Page<Invoice> findAllInvoice(Pageable pageable);

    void deleteInvoice(Long id);

    Invoice findById(Long id);
    List<Invoice> searchInvoice(String start_date,
                                String end_date,
                                String start_time,
                                String end_time,
                                String sort_column);
}
