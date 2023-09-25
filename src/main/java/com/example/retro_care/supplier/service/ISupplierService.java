package com.example.retro_care.supplier.service;

import com.example.retro_care.supplier.model.IInvoiceProjection;
import com.example.retro_care.supplier.model.ISupplierProjection;
import com.example.retro_care.supplier.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ISupplierService {
    /**
     * method :getListSupplier()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Pageable pageable
     * return Page<ISupplierProjection>
     */
    Page<ISupplierProjection> getListSupplier(Pageable pageable, String code,String name, String phoneNumber,String address);
    /**
     * method :createSupplier()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Supplier supplier
     * return void
     */
    void createSupplier(Supplier supplier);
    /**
     * method :updateSupplierById()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param:  Supplier supplier
     * return void
     */
    void updateSupplierById( Supplier supplier);
    /**
     * method :deleteSupplierById()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Long id
     * return void
     */
    void deleteSupplierById (Long id);
    /**
     * method :getSupplierById()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Long id
     * return Supplier
     */
    Supplier getSupplierById(Long id);
    /**
     * method :findAllListInvoiceByIdSupplier()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Long id, Pageable pageable
     * return Page<IInvoiceProjection>
     */
    Page<IInvoiceProjection> findAllListInvoiceByIdSupplier(Long id, Pageable pageable,String startDate,String endDate);
    /**
     * method :getSupplierDetailById()
     * created by :ThanhVH
     * date create: 19/09/2023
     *
     * @param: Long id
     * return ISupplierProjection
     */
    ISupplierProjection getSupplierDetailById(@Param("id") Long id);
    /**
     * method :getListSupplier()
     * created by :ThanhVH
     * date create: 21/09/2023
     *
     * @param:
     * return List<Supplier>
     */
    List<Supplier> getListSupplier();
    Supplier getSupplierByCode(String code);
    Supplier getSupplierByName(String name);
    Supplier getSupplierByEmail(String email);
    Supplier getSupplierByPhoneNumber(String phoneNumber);
}
