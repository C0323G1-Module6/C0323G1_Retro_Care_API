package com.example.retro_care.invoice.controller;

import com.example.retro_care.invoice.model.Invoice;
import com.example.retro_care.invoice.model.InvoiceDetail;
import com.example.retro_care.invoice.model.InvoiceDetailDto;
import com.example.retro_care.invoice.model.InvoiceDto;
import com.example.retro_care.invoice.service.IInvoiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    IInvoiceService invoiceService;

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
    @GetMapping("/search")
    public ResponseEntity<List<Invoice>> searchInvoice(@RequestParam(required = false) String start_date,
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


    /**
     * Create an invoice with create invoiceDetail
     * Code by CuongHLT
     *
     * @param invoiceDto
     * @return a ResponseEntity
     */
    @PostMapping("/create")
    public ResponseEntity<?> createInvoice(@Valid @RequestBody InvoiceDto invoiceDto, BindingResult bindingResult) {
        System.out.println(invoiceDto);
        if (invoiceDto.getInvoiceDetailDtoSet() == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        new InvoiceDto().validate(invoiceDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> err = new HashMap<>();
            for (FieldError e : bindingResult.getFieldErrors()) {
                err.put(e.getField(), e.getDefaultMessage());
            }
            return new ResponseEntity<>(err, HttpStatus.NOT_ACCEPTABLE);
        }
        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(invoiceDto, invoice);
        Invoice selectedInvoice = invoiceService.createInvoice(invoice, invoiceDto);
        if (selectedInvoice == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
    @PatchMapping("/edit")
    public ResponseEntity<?> editInvoice(@Valid @RequestBody InvoiceDto invoiceDto, BindingResult bindingResult) {
        if (invoiceService.getInvoiceById(invoiceDto.getId()) == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        new InvoiceDto().validate(invoiceDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> err = new HashMap<>();
            for (FieldError e : bindingResult.getFieldErrors()) {
                err.put(e.getField(), e.getDefaultMessage());
            }
            return new ResponseEntity<>(err, HttpStatus.NOT_ACCEPTABLE);
        }
        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(invoiceDto, invoice);
        Invoice selectedInvoice = invoiceService.editInvoice(invoice, invoiceDto);

        return new ResponseEntity<>(selectedInvoice, HttpStatus.OK);
    }

    /**
     * Get a next code for invoice
     * Code by CuongHLT
     *
     * @return an ResponseEntity
     */
    @GetMapping("/code")
    public ResponseEntity<String> getCodeInvoice() {
        String maxCode = invoiceService.findMaxCode();
        System.out.println(maxCode);
        if (maxCode == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(maxCode, HttpStatus.OK);
    }
}

