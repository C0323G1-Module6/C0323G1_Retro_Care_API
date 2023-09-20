package com.example.retro_care.supplier.model;

import org.springframework.data.domain.Page;

import java.util.List;

public class SupplierDetailResponse {
    private Page<IInvoiceProjection> invoices;
    private ISupplierProjection supplier;

    public SupplierDetailResponse(Page<IInvoiceProjection> invoices, ISupplierProjection supplier) {
        this.invoices = invoices;
        this.supplier = supplier;
    }

    public SupplierDetailResponse() {
    }

    public Page<IInvoiceProjection> getInvoices() {
        return invoices;
    }

    public void setInvoices(Page<IInvoiceProjection> invoices) {
        this.invoices = invoices;
    }

    public ISupplierProjection getSupplier() {
        return supplier;
    }

    public void setSupplier(ISupplierProjection supplier) {
        this.supplier = supplier;
    }
}
