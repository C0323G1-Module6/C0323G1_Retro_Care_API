package com.example.retro_care.supplier.service;

import com.example.retro_care.supplier.model.IInvoiceProjection;
import com.example.retro_care.supplier.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface ISupplierService {
    Page<Supplier> getListSupplier(Pageable pageable);
    void createSupplier(@Param("supplier") Supplier supplier);
    void updateSupplierById(@Param("supplier") Supplier supplier);
    void deleteSupplierById(@Param("id") Long id);
    Supplier getSupplierById(@Param("id") Long id);
    Page<IInvoiceProjection> findAllListInvoiceByIdSupplier(Long id, Pageable pageable);
}
