package com.example.retro_care.invoice.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

public class InvoiceDto implements Validator {
    private Long id;
    private String documentNumber;
    private Double paid;
    private String note;

    private Long appUserId;


    private Long supplierId;


    Set<InvoiceDetailDto> invoiceDetailDtoSet;

    public InvoiceDto() {
    }


    public InvoiceDto(Long id, String documentNumber, Double paid, String note, Long appUserId, Long supplierId, Set<InvoiceDetailDto> invoiceDetailDtoSet) {

        this.id = id;
        this.documentNumber = documentNumber;
        this.paid = paid;
        this.note = note;

        this.appUserId = appUserId;

        this.supplierId = supplierId;
        this.invoiceDetailDtoSet = invoiceDetailDtoSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Set<InvoiceDetailDto> getInvoiceDetailDtoSet() {
        return invoiceDetailDtoSet;
    }

    public void setInvoiceDetailDtoSet(Set<InvoiceDetailDto> invoiceDetailDtoSet) {
        this.invoiceDetailDtoSet = invoiceDetailDtoSet;
    }

    public Long getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Long appUserId) {
        this.appUserId = appUserId;
    }

    @Override

    public String toString() {
        return "InvoiceDto{" +
                "id=" + id +
                ", documentNumber='" + documentNumber + '\'' +
                ", paid=" + paid +
                ", note='" + note + '\'' +
                ", appUserId=" + appUserId +
                ", supplierId=" + supplierId +
                ", invoiceDetailDtoSet=" + invoiceDetailDtoSet +
                '}';
    }

    @Override

    public boolean supports(Class<?> clazz) {
        return false;
    }
    @Override
    public void validate(Object target, Errors errors) {
        InvoiceDto invoiceDto = (InvoiceDto) target;

        if (invoiceDto.getDocumentNumber() == null) {
            errors.rejectValue("documentNumber", null, "Không được để trống trường này");
        } else if (invoiceDto.getDocumentNumber().equals("")) {
            errors.rejectValue("documentNumber", null, "Không được để trống trường này");
        } else if (invoiceDto.getDocumentNumber().length() > 50) {
            errors.rejectValue("documentNumber", null, "Nhập nội dung quá dài");
        } else if (invoiceDto.getDocumentNumber().length() < 5) {
            errors.rejectValue("documentNumber", null, "Nhập nội dung quá ngắn");
        }

        if (invoiceDto.getPaid() == null) {
            errors.rejectValue("paid", null, "Không được để trống trường này");
        } else if (invoiceDto.getPaid().isNaN()) {
            errors.rejectValue("paid", null, "Không phải là số");
        } else if (invoiceDto.getPaid() < 0) {
            errors.rejectValue("paid", null, "Giá trị phải lớn hơn hoặc bằng 0");
        } else if (invoiceDto.getPaid() >= Double.MAX_VALUE) {
            errors.rejectValue("paid", null, "Giá trị quá lớn");
        }
        if (invoiceDto.getSupplierId() == null) {
            errors.rejectValue("supplierId", null, "Không được để trống trường này");
        }
        if (invoiceDto.getInvoiceDetailDtoSet() == null)
            return;
        for (InvoiceDetailDto invoiceDetailDto : invoiceDto.getInvoiceDetailDtoSet()) {
            if (invoiceDetailDto.getDiscount() == null) {
                errors.rejectValue("invoiceDetailSet", null, "Không được để trống trường này");
            } else if (invoiceDetailDto.getDiscount().isNaN()) {
                errors.rejectValue("invoiceDetailSet", null, "Không phải là số");
            } else if (invoiceDetailDto.getDiscount() < 0) {
                errors.rejectValue("invoiceDetailSet", null, "Giá trị phải lớn hơn hoặc bằng 0");
            } else if (invoiceDetailDto.getDiscount() >= Float.MAX_VALUE) {
                errors.rejectValue("invoiceDetailSet", null, "Giá trị quá lớn");
            }
            if (invoiceDetailDto.getMedicineQuantity() == null) {
                errors.rejectValue("invoiceDetailSet", null, "Không được để trống trường này");
            } else if (invoiceDetailDto.getMedicineQuantity() < 0) {
                errors.rejectValue("invoiceDetailSet", null, "Giá trị phải lớn hơn hoặc bằng 0");
            } else if (invoiceDetailDto.getMedicineQuantity() >= Integer.MAX_VALUE) {
                errors.rejectValue("invoiceDetailSet", null, "Giá trị quá lớn");
            }
        }

    }
}
