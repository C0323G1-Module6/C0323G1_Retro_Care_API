package com.example.retro_care.supplier.model;

public interface IInvoiceProjection {
    Integer getIdInvoice();
    String getCodeInvoice();
    String getDocumentNumber();

    String getCreateDate();
    String getCreateTime();
    Double getTotalAmount();
    Double getAmountDue();
}
