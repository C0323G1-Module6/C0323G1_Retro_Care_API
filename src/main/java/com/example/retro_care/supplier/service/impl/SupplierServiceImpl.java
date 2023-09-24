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

import java.util.List;

@Service

public class SupplierServiceImpl implements ISupplierService {
    @Autowired
    private ISupplierRepository iSupplierRepository;

    @Override
    public Page<ISupplierProjection> getListSupplier(Pageable pageable,String code,String name,String phoneNumber,String address) {
        return iSupplierRepository.getListSupplier(pageable,code,name,phoneNumber,address);
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
    public Page<IInvoiceProjection> findAllListInvoiceByIdSupplier(Long id, Pageable pageable,String startDate,String endDate) {
        return iSupplierRepository.findAllListInvoiceByIdSupplier(id,pageable,startDate,endDate);
    }

    @Override
    public ISupplierProjection getSupplierDetailById(Long id) {
        return iSupplierRepository.getSupplierDetailById(id);
    }

    @Override
    public List<Supplier> getListSupplier() {
        return iSupplierRepository.getListSupplier();
    }

    @Override
    public Supplier getSupplierByCode(String code) {
        return iSupplierRepository.getSupplierByCode(code);
    }

    @Override
    public Supplier getSupplierByName(String name) {
        return iSupplierRepository.getSupplierByName(name);
    }

    @Override
    public Supplier getSupplierByEmail(String email) {
        return iSupplierRepository.getSupplierByEmail(email);
    }

    @Override
    public Supplier getSupplierByPhoneNumber(String phoneNumber) {
        return iSupplierRepository.getSupplierByPhoneNumber(phoneNumber);
    }
}
