package com.example.retro_care.supplier.service;

import com.example.retro_care.supplier.model.IInvoiceProjection;
import com.example.retro_care.supplier.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ISupplierService {
    Page<Supplier> getListSupplier(Pageable pageable);
    void createSupplier(Supplier supplier);
    void updateSupplierById( Supplier supplier);
    void deleteSupplierById (Long id);
    Supplier getSupplierById(Long id);
    Page<IInvoiceProjection> findAllListInvoiceByIdSupplier(Long id, Pageable pageable);
}
