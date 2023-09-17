package com.example.retro_care.invoice.controller;

import com.example.retro_care.invoice.model.InvoiceDetail;
import com.example.retro_care.invoice.model.InvoiceDetailDto;
import com.example.retro_care.invoice.service.IInvoiceDetailService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@CrossOrigin("*")
//@RequestMapping("/api/invoiceDetail")
public class InvoiceDetailController {
//    @Autowired
//    IInvoiceDetailService invoiceDetailService;

//    @DeleteMapping("/{invoiceDetailId}")
//    public ResponseEntity deleteInvoiceDetail(@PathVariable Long invoiceDetailId) {
//        if (invoiceDetailService.getInvoiceDetailById(invoiceDetailId) == null)
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        invoiceDetailService.deleteInvoiceDetail(invoiceDetailId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @PostMapping("/create")
//    public ResponseEntity createInvoiceDetail(@RequestBody List<InvoiceDetailDto> invoiceDetailDtoList) {
//        try {
//            InvoiceDetail invoiceDetail = new InvoiceDetail();
//            for (InvoiceDetailDto invoiceDetailDto : invoiceDetailDtoList) {
//                BeanUtils.copyProperties(invoiceDetailDto, invoiceDetail);
//                invoiceDetailService.createInvoiceDetail(invoiceDetail);
//            }
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
