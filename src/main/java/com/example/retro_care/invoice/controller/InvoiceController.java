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
//        Invoice invoice = new Invoice();
//        BeanUtils.copyProperties(invoiceDto, invoice);
//        Invoice selectedInvoice = invoiceService.createInvoice(invoice);
//        for (InvoiceDetail invoiceDetail : invoice.getInvoiceDetailSet()) {
//            invoiceDetail.setInvoiceId(selectedInvoice);
//            invoiceDetailService.createInvoiceDetail(invoiceDetail);
//        }
        System.out.println(invoiceDto);
//        return new ResponseEntity<>(selectedInvoice, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.OK);
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
        for (InvoiceDetail invoiceDetail : invoice.getInvoiceDetailSet()) {
            if (invoiceDetail.getId() == null)
                invoiceDetailService.createInvoiceDetail(invoiceDetail);
            else if (!invoiceDetailService.getInvoiceDetailById(invoiceDetail.getId()).equals(invoiceDetail))
                invoiceDetailService.editInvoiceDetail(invoiceDetail);
        }
        Invoice selectedInvoice = invoiceService.editInvoice(invoice);
        return new ResponseEntity<>(selectedInvoice, HttpStatus.OK);
    }
}
