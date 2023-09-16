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
    public void editInvoice(Invoice invoice) {
        invoiceRepository.editInvoice(invoice);
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

    @Override
    public String findMaxCode() {
        String maxCode = invoiceRepository.findMaxCode();
        if (maxCode == null) {
            return "HDN0001"; // Hoặc giá trị mặc định khác cho code đầu tiên
        }

        // Tách phần số từ code lớn nhất hiện tại
        String numericPart = maxCode.substring(2);
        int numericValue = Integer.parseInt(numericPart);

        // Tăng giá trị số lên 1
        numericValue++;

        // Định dạng lại giá trị số thành chuỗi có độ dài 4 và thêm vào tiền tố "HD"
        String newNumericPart = String.format("%05d", numericValue);
        String newCode = "HDN" + newNumericPart;

        return newCode;
    }
}
