package com.example.retro_care.invoice.service;

import com.example.retro_care.invoice.model.Invoice;
import com.example.retro_care.invoice.model.InvoiceDetail;
import com.example.retro_care.invoice.model.InvoiceDetailDto;
import com.example.retro_care.invoice.model.InvoiceDto;
import com.example.retro_care.invoice.repository.IInvoiceDetailRepository;
import com.example.retro_care.invoice.repository.IInvoiceRepository;
import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.supplier.model.Supplier;
import com.example.retro_care.user.model.AppUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public Invoice createInvoice(Invoice invoice, InvoiceDto invoiceDto) {
        invoice.setCreationDate(new Date());
//        Set AppUserId
        invoice.setAppUserId(new AppUser());

        Supplier supplier = new Supplier();
        supplier.setId(invoiceDto.getSupplierId());
        invoice.setSupplierId(supplier);
        Invoice selectedInvoice = invoiceRepository.createInvoice(invoice);
        System.out.println(selectedInvoice);
        for (InvoiceDetailDto invoiceDetailDto : invoiceDto.getInvoiceDetailDtoSet()) {
            InvoiceDetail invoiceDetail = new InvoiceDetail();
            Medicine medicine = new Medicine();
            medicine.setId(invoiceDetailDto.getMedicineId());
            BeanUtils.copyProperties(invoiceDetailDto, invoiceDetail);
            invoiceDetail.setMedicineId(medicine);
            invoiceDetail.setInvoiceId(selectedInvoice);
            invoiceDetailRepository.createInvoiceDetail(invoiceDetail);
        }
        return selectedInvoice;
    }

    public Invoice editInvoice(Invoice invoice, InvoiceDto invoiceDto) {
//        invoice.setCreationDate(new Date());
//        Set AppUserId
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        invoice.setAppUserId(appUser);
        Supplier supplier = new Supplier();
        supplier.setId(invoiceDto.getSupplierId());
        invoice.setSupplierId(supplier);
        return invoiceRepository.editInvoice(invoice);
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
     * @param start_date
     * @param end_date
     * @param start_time
     * @param end_time
     * @param sort_column
     * @return
     */
    @Override
    public List<Invoice> searchInvoice(String start_date, String end_date, String start_time, String
            end_time, String sort_column) {
        return invoiceRepository.searchInvoice(start_date, end_date, start_time, end_time, sort_column);
    }
}
