package com.example.retro_care.invoice.model;

import com.example.retro_care.supplier.model.Supplier;
import com.example.retro_care.user.model.AppUser;

import javax.persistence.Column;
import java.sql.Time;
import java.util.Date;

public interface IInvoiceResult {
    String getCode();

    Long getId();

    String getDocumentNumber();

    Date getCreationDay();

    Date getCreationDate();

    Time getCreationTime();

    String getNote();

    Double getTotal();

    Double getBillOwed();

    Supplier getSupplier();

    String getName();

    String getAddress();

    AppUser getAppUser();

    Long getIdMedicine();

    String getCodeMedicine();

    String getNameMedicine();

    Double getPrice();

    Long getQuantity();

    Float getVat();

    String getNoteMedicine();

    String getMaker();

    String getActiveElement();

    String getOrigin();

    Float getRetailProfits();

    String getCodeKind();

    String getNameKind();
}
