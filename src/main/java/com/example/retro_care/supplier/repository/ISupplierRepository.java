package com.example.retro_care.supplier.repository;

import com.example.retro_care.supplier.model.IInvoiceProjection;
import com.example.retro_care.supplier.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ISupplierRepository extends JpaRepository<Supplier, Long> {
    /**
     * method :getListSupplier()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Pageable pageable
     * return Page<Supplier>
     */
    @Query(nativeQuery = true,
            value = "SELECT\n" +
                    "    s.id,\n" +
                    "    s.code,\n" +
                    "    s.name,\n" +
                    "    s.phone_number,\n" +
                    "    s.address,\n" +
                    "    s.note,\n" +
                    "    IFNULL(total_invoice_detail_amount - total_paid_amount, 0) AS debt\n" +
                    "FROM\n" +
                    "    supplier s\n" +
                    "LEFT JOIN\n" +
                    "    (\n" +
                    "        SELECT\n" +
                    "            i.supplier_id,\n" +
                    "            SUM(i.paid) AS total_paid_amount\n" +
                    "        FROM\n" +
                    "            invoice i\n" +
                    "        WHERE\n" +
                    "            i.flag_deleted = 0\n" +
                    "        GROUP BY\n" +
                    "            i.supplier_id\n" +
                    "    ) AS paid_amounts ON s.id = paid_amounts.supplier_id\n" +
                    "LEFT JOIN\n" +
                    "    (\n" +
                    "        SELECT\n" +
                    "            supplier_id,\n" +
                    "            SUM(id.medicine_quantity * m.price) AS total_invoice_detail_amount\n" +
                    "        FROM\n" +
                    "            invoice_detail id\n" +
                    "        JOIN\n" +
                    "            invoice i ON id.invoice_id = i.id\n" +
                    "        JOIN\n" +
                    "            medicine m ON id.medicine_id = m.id\n" +
                    "        WHERE\n" +
                    "            i.flag_deleted = 0\n" +
                    "            AND id.flag_deleted = 0\n" +
                    "        GROUP BY\n" +
                    "            supplier_id\n" +
                    "    ) AS invoice_detail_amounts ON s.id = invoice_detail_amounts.supplier_id\n" +
                    "WHERE\n" +
                    "    s.flag_deleted = 0;")
    Page<Supplier> getListSupplier(Pageable pageable);
    /**
     * method :createSupplier()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Supplier supplier
     * return void
     */
    @Query(nativeQuery = true,
            value = "INSERT INTO supplier(code, name, email, address, phone_number, note, flag_deleted)" +
                    "VALUES (:#{#supplier.codeSupplier},#{#supplier.nameSupplier},#{#supplier.emailSupplier},#{#supplier.addressSupplier}," +
                    "#{#supplier.telSupplier},#{#supplier.noteSupplier},false);")
    void createSupplier(@Param("supplier") Supplier supplier);
    /**
     * method :updateSupplierById()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param:  Supplier supplier
     * return void
     */
    @Query(nativeQuery = true,
           value = "UPDATE supplier SET code = #{#supplier.codeSupplier}," +
                   " name = #{#supplier.nameSupplier}," +
                   " email = #{#supplier.emailSupplier}," +
                   " address = #{#supplier.addressSupplier}," +
                   " phone_number = #{#supplier.telSupplier}," +
                   " note = #{#supplier.noteSupplier}," +
                   " WHERE (id = #{#supplier.idSupplier});")
    void updateSupplierById(@Param("supplier") Supplier supplier);
    /**
     * method :deleteSupplierById()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Long id
     * return void
     */
    @Query(nativeQuery = true,
           value = "update supplier set flag_deleted = true where id = :id and flag_deleted = false")
    void deleteSupplierById(@Param("id") Long id);
    /**
     * method :getSupplierById()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Long id
     * return Supplier
     */

    @Query(nativeQuery = true,
           value = "select supplier.id,supplier.code,supplier.name,supplier.email, supplier.address," +
                   "supplier.tel,supplier.note,supplier.flag_deleted" +
                   " from supplier where id_supplier = :id and flag_deleted = false")
    Supplier getSupplierById(@Param("id") Long id);
    /**
     * method :findAllListInvoiceByIdSupplier()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Long id, Pageable pageable
     * return Page<IInvoiceProjection>
     */

    @Query( nativeQuery = true,
            value = "SELECT \n" +
                    "invoice.id as idInvoice ,\n" +
                    "  invoice.`code` as codeInvoice,\n" +
                    "  invoice.document_number as documentNumber,\n" +
                    "  DATE(invoice.creation_date) AS createDate,\n" +
                    "  TIME(invoice.creation_date) AS createTime,\n" +
                    "  SUM(invoice_detail.medicine_quantity * medicine.price) AS totalAmount,\n" +
                    "  (ANY_VALUE(invoice_detail.medicine_quantity) * ANY_VALUE(medicine.price)) - invoice.paid AS amountDue\n" +
                    "FROM \n" +
                    "  invoice \n" +
                    "JOIN \n" +
                    "  invoice_detail ON invoice_detail.invoice_id = invoice.id\n" +
                    "JOIN \n" +
                    "  medicine ON invoice_detail.medicine_id = medicine.id\n" +
                    "JOIN \n" +
                    "  supplier ON invoice.supplier_id = supplier.id\n" +
                    "WHERE supplier.id = :id\n" +
                    "GROUP BY \n" +
                    "  invoice.id;")
    Page<IInvoiceProjection> findAllListInvoiceByIdSupplier(Long id, Pageable pageable);


}
