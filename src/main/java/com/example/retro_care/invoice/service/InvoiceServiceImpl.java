package com.example.retro_care.invoice.service;

import com.example.retro_care.invoice.model.IInvoiceResult;
import com.example.retro_care.invoice.model.Invoice;
import com.example.retro_care.invoice.model.InvoiceDetail;
import com.example.retro_care.invoice.repository.IInvoiceDetailRepository;
import com.example.retro_care.invoice.repository.IInvoiceRepository;
import com.example.retro_care.user.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InvoiceServiceImpl implements IInvoiceService {
    @Autowired
    IInvoiceRepository invoiceRepository;
    @Autowired
    IInvoiceDetailRepository invoiceDetailRepository;

    /**
     * create an Invoice and call method for create InvoiceDetail
     * Code by CuongHLT
     *
     * @param invoice
     * @return Invoice
     */
    @Override
    public Invoice createInvoice(Invoice invoice) {
        invoice.setCreationDate(new Date());
        invoice.setFlagDeleted(false);
        invoice.setAppUserId(new AppUser());
        for (InvoiceDetail invoiceDetail : invoice.getInvoiceDetailSet()) {
            invoiceDetail.setInvoiceId(invoice);
            invoiceDetailRepository.createInvoiceDetail(invoiceDetail);
        }
        return invoiceRepository.createInvoice(invoice);
    }

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

    /**
     * find and create Next code for invoice
     * Code by CuongHLT
     *
     * @return Next code String
     */
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

    /**
     * Create by: HuyHD;
     * Date create: 15/09/2023;
     *
     * @param pageable
     * @return
     */

    @Override
    public Page<Invoice> findAllInvoice(Pageable pageable) {
        return invoiceRepository.findAllInvoice(pageable);
    }

    @Override
    public Page<IInvoiceResult> findAllInvoiceResult(Pageable pageable) {
        return invoiceRepository.findAllInvoiceResult(pageable);
    }

    /**
     * Create by: HuyHD;
     * Date create: 15/09/2023
     * Function: delete invoice with invoice code ? ;
     *
     * @param : id (id_invoice);
     * @return : new invoice list does not exist newly deleted element.
     */
    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteInvoice(id);
    }

    @Override
    public Invoice findById(Long id) {
        return invoiceRepository.findById(id).get();
    }

    /**
     * Create by: HuyHD;
     * Date create: 15/09/2023
     * Function: Search by invoice creation time, and sort by column;
     *
     * @param pageable
     * @param startDate
     * @param endDate
     * @param startTime
     * @param endTime
     * @param sortColumn
     * @return
     */

    @Override
    public Page<Invoice> searchInvoice(Pageable pageable, String startDate, String endDate, String startTime, String
            endTime, String sortColumn) {
        return invoiceRepository.searchInvoice(pageable, startDate, endDate, startTime, endTime, sortColumn);
    }

}
