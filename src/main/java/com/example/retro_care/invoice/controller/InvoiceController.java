package com.example.retro_care.invoice.controller;

import com.example.retro_care.invoice.model.Invoice;
import com.example.retro_care.invoice.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/invoice")
@CrossOrigin("*")
public class InvoiceController {

    @Autowired
    private IInvoiceService invoiceService;

    /**
     * Create by: HuyHD;
     * Date create: 15/09/2023
     * Function: displays a paginated list of invoice;
     *
     * @param : page (page number), limit(number of elements in the page);
     * @return : paginated invoice list with limit number of molecules per page.
     */
    @GetMapping("")
    public ResponseEntity<Page<Invoice>> getListInvoice(@PageableDefault(size = 2) Pageable pageable, @RequestParam("page") Integer page) {
        if (invoiceService.findAllInvoice(pageable).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(invoiceService.findAllInvoice(pageable), HttpStatus.OK);
    }

    /**
     * Create by: HuyHD;
     * Date create: 15/09/2023
     * Function: delete invoice with invoice code ? ;
     *
     * @param : id (id_invoice);
     * @return : new invoice list does not exist newly deleted element.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Long id) {
        Invoice invoice = this.invoiceService.findById(id);
        if (invoice == null) {
            return new ResponseEntity<>("Không tìm thấy hóa đơn", HttpStatus.NO_CONTENT);
        }

        try {
            this.invoiceService.deleteInvoice(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Đã xảy ra lỗi! Không thể xóa hóa đơn này!", HttpStatus.NO_CONTENT);
        }
    }

    /**
     *
     * @param start_date
     * @param end_date
     * @param start_time
     * @param end_time
     * @param sort_column
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchInvoice(@RequestParam(required = false) String start_date,
                                           @RequestParam(required = false) String end_date,
                                           @RequestParam(required = false) String start_time,
                                           @RequestParam(required = false) String end_time,
                                           @RequestParam(required = false) String sort_column) {
        List<Invoice> invoices = invoiceService.searchInvoice(start_date, end_date, start_time, end_time, sort_column);
        if (invoices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(invoices, HttpStatus.OK);
        }
    }

}
