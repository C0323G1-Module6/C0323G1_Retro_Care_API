package com.example.retro_care.invoice.controller;

import com.example.retro_care.invoice.model.InvoiceDetail;
import com.example.retro_care.invoice.service.IInvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/invoice-detail")
public class InvoiceDetailController {
    @Autowired
    IInvoiceDetailService invoiceDetailService;

    @GetMapping("/{invoiceId}")
    public ResponseEntity<List<InvoiceDetail>> getListInvoiceDetail(@PathVariable Long invoiceId) {
        List<InvoiceDetail> list = invoiceDetailService.getInvoiceDetails(invoiceId);
        if (list == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
