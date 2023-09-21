package com.example.retro_care.invoice.controller;

import com.example.retro_care.invoice.model.IInvoiceResult;
import com.example.retro_care.invoice.model.Invoice;
import com.example.retro_care.invoice.model.InvoiceDetail;
import com.example.retro_care.invoice.model.InvoiceDetailDto;
import com.example.retro_care.invoice.model.InvoiceDto;
import com.example.retro_care.invoice.service.IInvoiceService;
import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.supplier.model.Supplier;
import com.example.retro_care.user.model.AppUser;
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
import java.util.*;

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


    @GetMapping("/result")
    public ResponseEntity<Page<IInvoiceResult>> getListInvoiceResult(@PageableDefault(size = 2) Pageable pageable, @RequestParam("page") Integer page) {
        Page<IInvoiceResult> invoicePage = invoiceService.findAllInvoiceResult(pageable);

        if (invoicePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (page < 0 || page >= invoicePage.getTotalPages()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(invoicePage, HttpStatus.OK);
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
    private boolean isValidSortColumn(String sort_column) {
        List<String> validSortColumns = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
        return validSortColumns.contains(sort_column);
    }
    /**
     * Create by: HuyHD;
     * Date create: 15/09/2023
     * Function: Search by invoice creation time, and sort by column;
     * @param page page number
     * @param size number record in page
     * @param startDate
     * @param endDate
     * @param startTime
     * @param endTime
     * @param sortColumn
     * @return
     */
    @GetMapping("/search/result")
    public ResponseEntity<?> searchInvoiceResult(@RequestParam(required = false) Integer page,
                                                 @RequestParam(required = false) Integer size,
                                                 @RequestParam(required = false) String startDate,
                                                 @RequestParam(required = false) String endDate,
                                                 @RequestParam(required = false) String startTime,
                                                 @RequestParam(required = false) String endTime,
                                                 @RequestParam(required = false) String sortColumn) {
        if (startDate != null && startDate.isEmpty()) {
            startDate = null;
        }

        if (endDate != null && endDate.isEmpty()) {
            endDate = null;
        }

        if (startTime != null && startTime.isEmpty()) {
            startTime = null;
        }

        if (endTime != null && endTime.isEmpty()) {
            endTime = null;
        }

        if (startDate != null && !isValidDateFormat(startDate, "yyyy-MM-dd")) {
            return new ResponseEntity<>("Invalid start_date format", HttpStatus.BAD_REQUEST);
        }

        if (endDate != null && !isValidDateFormat(endDate, "yyyy-MM-dd")) {
            return new ResponseEntity<>("Invalid end_date format", HttpStatus.BAD_REQUEST);
        }

        if (startTime != null && !isValidDateFormat(startTime, "HH:mm:ss")) {
            return new ResponseEntity<>("Invalid start_time format", HttpStatus.BAD_REQUEST);
        }

        if (endTime != null && !isValidDateFormat(endTime, "HH:mm:ss")) {
            return new ResponseEntity<>("Invalid end_time format", HttpStatus.BAD_REQUEST);
        }

        Pageable pageable;
        if (page != null && size != null) {
            pageable = PageRequest.of(page, size);
        } else {
            pageable = Pageable.unpaged();
        }
        if (sortColumn != null && !isValidSortColumn(sortColumn)) {
            return new ResponseEntity<>("Invalid sort_column value", HttpStatus.BAD_REQUEST);
        }

        // Check for empty string ("") and set to null

        Page<IInvoiceResult> invoices = invoiceService.searchInvoiceResult(pageable, startDate, endDate, startTime, endTime, sortColumn);

        if (invoices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(invoices, HttpStatus.OK);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id ){
        List<IInvoiceResult> medicine = invoiceService.getInvoiceDetailById(id);
        if(medicine==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicine, HttpStatus.OK);
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
        if (invoiceService.getInvoiceById(invoice.getId()) == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        Invoice selectedInvoice = invoiceService.editInvoice(invoice, invoiceDto);
        System.out.println(selectedInvoice);
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
        if (maxCode == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(maxCode, HttpStatus.OK);
    }
}
