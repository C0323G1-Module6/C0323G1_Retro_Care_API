package com.example.retro_care.supplier.service.impl;

import com.example.retro_care.supplier.model.IInvoiceProjection;
import com.example.retro_care.supplier.model.ISupplierProjection;
import com.example.retro_care.supplier.model.Supplier;
import com.example.retro_care.supplier.repository.ISupplierRepository;
import com.example.retro_care.supplier.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service

public class SupplierServiceImpl implements ISupplierService {
    @Autowired
    private ISupplierRepository iSupplierRepository;

    @Override
    public Page<ISupplierProjection> getListSupplier(Pageable pageable,String code,String name,String phoneNumber,String address,String sortBy) {
        return iSupplierRepository.getListSupplier(pageable,code,name,phoneNumber,address,sortBy);
    }

    @Override
    public void createSupplier(Supplier supplier) {
        iSupplierRepository.createSupplier(supplier);
    }

    @Override
    public void updateSupplierById(Supplier supplier) {
        iSupplierRepository.updateSupplierById(supplier);
    }

    @Override
    public void deleteSupplierById(Long id) {
        iSupplierRepository.deleteSupplierById(id);
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return iSupplierRepository.getSupplierById(id);
    }

    @Override
    public Page<IInvoiceProjection> findAllListInvoiceByIdSupplier(Long id, Pageable pageable) {
        return iSupplierRepository.findAllListInvoiceByIdSupplier(id,pageable);
    }

    @Override
    public ISupplierProjection getSupplierDetailById(Long id) {
        return iSupplierRepository.getSupplierDetailById(id);
    }
}
