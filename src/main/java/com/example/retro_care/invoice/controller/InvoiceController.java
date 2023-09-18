package com.example.retro_care.invoice.controller;

import com.example.retro_care.invoice.model.Invoice;
import com.example.retro_care.invoice.model.InvoiceDto;
import com.example.retro_care.invoice.service.IInvoiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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
        } else if (page < 0 ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
        try {
            Invoice invoice = this.invoiceService.findById(id);
            if (invoice == null) {
                return new ResponseEntity<>("Không tìm thấy hóa đơn", HttpStatus.NO_CONTENT);
            }
            this.invoiceService.deleteInvoice(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Đã xảy ra lỗi! Không thể xóa hóa đơn này!", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Đã xảy ra lỗi khi xử lý yêu cầu!", HttpStatus.NOT_FOUND);
        }
    }
    public static boolean isValidDateFormat(String inputDate, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(inputDate);
            return true;
        } catch (ParseException e) {
            return false;
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
    public ResponseEntity<?> searchInvoice(@RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) Integer size,
                                           @RequestParam(required = false) String start_date,
                                           @RequestParam(required = false) String end_date,
                                           @RequestParam(required = false) String start_time,
                                           @RequestParam(required = false) String end_time,
                                           @RequestParam(required = false) String sort_column) {
        if (start_date != null && !isValidDateFormat(start_date, "yyyy-MM-dd")) {
            return new ResponseEntity<>("Invalid start_date format", HttpStatus.BAD_REQUEST);
        }

        if (end_date != null && !isValidDateFormat(end_date, "yyyy-MM-dd")) {
            return new ResponseEntity<>("Invalid end_date format", HttpStatus.BAD_REQUEST);
        }

        if (start_time != null && !isValidDateFormat(start_time, "HH:mm:ss")) {
            return new ResponseEntity<>("Invalid start_time format", HttpStatus.BAD_REQUEST);
        }

        if (end_time != null && !isValidDateFormat(end_time, "HH:mm:ss")) {
            return new ResponseEntity<>("Invalid end_time format", HttpStatus.BAD_REQUEST);
        }

        Pageable pageable;
        if (page != null && size != null) {
            pageable = PageRequest.of(page, size);
        } else {
            pageable = Pageable.unpaged();
        }

        Page<Invoice> invoices = invoiceService.searchInvoice(pageable, start_date, end_date, start_time, end_time, sort_column);

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
        if (invoice.getInvoiceDetailSet() != null) {
            Invoice selectedInvoice = invoiceService.createInvoice(invoice);
            return new ResponseEntity<>(selectedInvoice, HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

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
    public ResponseEntity<?> editInvoice(@Valid @RequestBody InvoiceDto invoiceDto, BindingResult bindingResult) {
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
        if (invoiceService.getInvoiceById(invoice.getId()) != null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        else
            invoiceService.editInvoice(invoice);
        return new ResponseEntity<>(HttpStatus.OK);
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
        if (maxCode == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(maxCode, HttpStatus.OK);
    }
}
