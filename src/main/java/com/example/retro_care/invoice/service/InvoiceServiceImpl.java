package com.example.retro_care.invoice.service;

import com.example.retro_care.invoice.model.*;
import com.example.retro_care.invoice.repository.IInvoiceDetailRepository;
import com.example.retro_care.invoice.repository.IInvoiceRepository;
import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.medicine.model.UnitDetail;
import com.example.retro_care.medicine.repository.IMedicineRepository;
import com.example.retro_care.medicine.repository.IUnitDetailRepository;
import com.example.retro_care.supplier.model.Supplier;
import com.example.retro_care.user.model.AppUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InvoiceServiceImpl implements IInvoiceService {
    @Autowired
    IInvoiceRepository invoiceRepository;
    @Autowired
    IInvoiceDetailRepository invoiceDetailRepository;
    @Autowired
    IMedicineRepository medicineRepository;
    @Autowired
    IUnitDetailRepository unitDetailRepository;

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
        AppUser appUser = new AppUser();
        appUser.setId(invoiceDto.getAppUserId());
        invoice.setAppUserId(appUser);
        // Set CreationDate
        invoice.setCreationDate(new Date());
//        Set Supplier
        Supplier supplier = new Supplier();
        supplier.setId(invoiceDto.getSupplierId());
        invoice.setSupplierId(supplier);
        //Set Max code
        invoice.setCode(findMaxCode());
        //Create invoice
        Invoice selectedInvoice = invoiceRepository.createInvoice(invoice);
        //Create invoiceDetail
        for (InvoiceDetailDto invoiceDetailDto : invoiceDto.getInvoiceDetailDtoSet()) {

            InvoiceDetail invoiceDetail = new InvoiceDetail();
            Medicine medicine = new Medicine();
            medicine.setId(invoiceDetailDto.getMedicineId());
            BeanUtils.copyProperties(invoiceDetailDto, invoiceDetail);
            //Set medicineID
            invoiceDetail.setMedicineId(medicine);
            //Set invoiceID
            invoiceDetail.setInvoiceId(selectedInvoice);
            //Create InvoiceDetail
            invoiceDetailRepository.createInvoiceDetail(invoiceDetail);
            //Get quantity medicine
            Long currentQuantity = medicineRepository.getMedicineQuantity(invoiceDetail.getMedicineId().getId());
//            //Update quantity medicine
            medicineRepository.updateQuantity(invoiceDetail.getMedicineId().getId(), currentQuantity + invoiceDetail.getMedicineQuantity());

        }
        return selectedInvoice;
    }

    public Invoice editInvoice(Invoice invoice, InvoiceDto invoiceDto) {
//        Set AppUserId
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
    public InvoiceEditDto getInvoiceById(Long invoiceId) {
        Invoice invoice = invoiceRepository.getInvoiceById(invoiceId);
        InvoiceEditDto invoiceEditDto = new InvoiceEditDto();
        BeanUtils.copyProperties(invoice, invoiceEditDto);
        Set<InvoiceDetail> invoiceDetailSet = invoice.getInvoiceDetailSet();
        List<InvoiceDetailEditDto> invoiceDetailEditDtoList = new ArrayList<>();
        for (InvoiceDetail invoiceDetail : invoiceDetailSet) {
            UnitDetail unitDetail = unitDetailRepository.findUnitDetailByMedicineId(invoiceDetail.getMedicineId().getId());
            InvoiceDetailEditDto invoiceDetailEditDto = new InvoiceDetailEditDto();
            BeanUtils.copyProperties(invoiceDetail,invoiceDetailEditDto);
            invoiceDetailEditDto.setUnit(unitDetail.getUnit().getName());
            invoiceDetailEditDtoList.add(invoiceDetailEditDto);
        }
        invoiceEditDto.setInvoiceDetailEditDtoList(invoiceDetailEditDtoList);
        return invoiceEditDto;
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
        if (maxCode.equals(""))
            return "HDN0001"; // Hoặc giá trị mặc định khác cho code đầu tiên
        // Tách phần số từ code lớn nhất hiện tại
        String numericPart = maxCode.substring(3);
        int numericValue = Integer.parseInt(numericPart);

        // Tăng giá trị số lên 1
        numericValue++;

        // Định dạng lại giá trị số thành chuỗi có độ dài 4 và thêm vào tiền tố "HDN"
        String newNumericPart = String.format("%04d", numericValue);
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

    @Override
    public List<IInvoiceResult> getInvoiceDetailById(Long id) {
        return invoiceRepository.getInvoiceDetailById(id);
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
     * @return
     */

    @Override
    public Page<IInvoiceResult> searchInvoiceResult(Pageable pageable, String startDate, String endDate, String startTime, String endTime, String sortColumn) {
        return invoiceRepository.searchInvoiceResult(pageable, startDate, endDate, startTime, endTime, sortColumn);
    }

}
