package com.example.retro_care.invoice.controller;

import com.example.retro_care.invoice.service.IInvoiceDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/invoiceDetail")
public class InvoiceDetailController {
    @Autowired
    IInvoiceDetailService invoiceDetailService;

    @DeleteMapping("/{invoiceDetailId}")
    public ResponseEntity deleteInvoiceDetail(@PathVariable Long invoiceDetailId) {
        if (invoiceDetailService.getInvoiceDetailById(invoiceDetailId) == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        invoiceDetailService.deleteInvoiceDetail(invoiceDetailId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
