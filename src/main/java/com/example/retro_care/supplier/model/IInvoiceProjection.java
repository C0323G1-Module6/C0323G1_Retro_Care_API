package com.example.retro_care.supplier.model;

import java.util.Date;

public interface IInvoiceProjection {
    Integer getIdInvoice();
    String getCodeInvoice();
    String getDocumentNumber();

    Date getCreateDate();
    String getCreateTime();
    Double getTotalAmount();
    Double getAmountDue();
}
