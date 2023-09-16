package com.example.retro_care.invoice.controller;

import com.example.retro_care.invoice.model.Invoice;
import com.example.retro_care.invoice.model.InvoiceDetail;
import com.example.retro_care.invoice.model.InvoiceDto;
import com.example.retro_care.invoice.service.IInvoiceDetailService;
import com.example.retro_care.invoice.service.IInvoiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/invoice")
public class InvoiceController {
    @Autowired
    IInvoiceService invoiceService;
    @Autowired
    IInvoiceDetailService invoiceDetailService;

    /**
     * Create an invoice with create invoiceDetail
     * Code by CuongHLT
     *
     * @param invoiceDto
     * @return a ResponseEntity
     */
    @PostMapping("/create")
    public ResponseEntity<Invoice> createInvoice(@RequestBody InvoiceDto invoiceDto) {
        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(invoiceDto, invoice);
        invoice.setCreationDate(new Date());
        Invoice selectedInvoice = invoiceService.createInvoice(invoice);
        if (invoice.getInvoiceDetailSet() != null)
            for (InvoiceDetail invoiceDetail : invoice.getInvoiceDetailSet()) {
                invoiceDetail.setInvoiceId(selectedInvoice);
                invoiceDetailService.createInvoiceDetail(invoiceDetail);
            }
        return new ResponseEntity<>(selectedInvoice, HttpStatus.CREATED);
    }

    /**
     * get an invoice for edit
     * Code by CuongHLT
     *
     * @param invoiceId
     * @return an invoice
     */
    @GetMapping("/{invoiceId}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long invoiceId) {
        Invoice invoice = invoiceService.getInvoiceById(invoiceId);
        if (invoice == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    /**
     * Edit an invoice with id
     * Code by CuongHLT
     *
     * @param invoiceDto
     * @return an ResponseEntity
     */
    @PutMapping("/edit")
    public ResponseEntity<Invoice> editInvoice(@RequestBody InvoiceDto invoiceDto) {
        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(invoiceDto, invoice);
        if (invoice.getInvoiceDetailSet() == null) {
            invoice.setFlagDeleted(true);
            invoiceService.editInvoice(invoice);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (InvoiceDetail invoiceDetail : invoice.getInvoiceDetailSet()) {
            if (invoiceDetail.getId() == null)
                invoiceDetailService.createInvoiceDetail(invoiceDetail);
            else if (!invoiceDetailService.getInvoiceDetailById(invoiceDetail.getId()).equals(invoiceDetail))
                invoiceDetailService.editInvoiceDetail(invoiceDetail);
            else
                invoiceDetailService.createInvoiceDetail(invoiceDetail);
        }
        invoiceService.editInvoice(invoice);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * @return
     */
    @GetMapping("/code")
    public ResponseEntity<String> getCodeInvoice() {
        String maxCode = invoiceService.findMaxCode();
        if (maxCode == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<String>(maxCode, HttpStatus.OK);
    }
}
