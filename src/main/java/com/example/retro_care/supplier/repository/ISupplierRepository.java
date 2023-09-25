package com.example.retro_care.supplier.repository;

import com.example.retro_care.supplier.model.IInvoiceProjection;
import com.example.retro_care.supplier.model.ISupplierProjection;
import com.example.retro_care.supplier.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ISupplierRepository extends JpaRepository<Supplier, Long> {
    /**
     * method :getListSupplier()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Pageable pageable ,name,code,address,phoneNumber,sortBy
     * return Page<ISupplierProjection>
     */
    @Query(nativeQuery = true,
            value = "    SELECT\n" +
                    "                            s.id AS idSupplier,\n" +
                    "                            s.code AS codeSupplier,\n" +
                    "                            s.name AS nameSupplier,\n" +
                    "                            s.phone_number AS phoneNumber,\n" +
                    "                            s.address AS address,\n" +
                    "                            s.note AS note,\n" +
                    "                            CASE WHEN COALESCE(total_invoice_detail_amount , 0) < 0 THEN 0\n" +
                    "                                 ELSE COALESCE(total_invoice_detail_amount , 0)\n" +
                    "                            END AS debt\n" +
                    "                        FROM\n" +
                    "                            supplier s\n" +
                    "                                LEFT JOIN\n" +
                    "                            (\n" +
                    "                                SELECT\n" +
                    "                                    supplier_id,\n" +
                    "                                    SUM(total_amount) AS total_invoice_detail_amount\n" +
                    "                                FROM\n" +
                    "                                    (\n" +
                    "                                        SELECT\n" +
                    "                                            i.supplier_id,\n" +
                    "                                            SUM(m.quantity * m.price)/2 AS total_amount\n" +
                    "                                        FROM\n" +
                    "                                            invoice_detail id\n" +
                    "                                                JOIN\n" +
                    "                                            invoice i ON id.invoice_id = i.id\n" +
                    "                                                JOIN\n" +
                    "                                            medicine m ON id.medicine_id = m.id\n" +
                    "                                        WHERE\n" +
                    "                                                i.flag_deleted = 0\n" +
                    "                                          AND id.flag_deleted = 0\n" +
                    "                                        GROUP BY\n" +
                    "                                            i.supplier_id\n" +
                    "                                    ) AS subquery\n" +
                    "                                GROUP BY\n" +
                    "                                    supplier_id\n" +
                    "                            ) AS invoice_detail_amounts ON s.id = invoice_detail_amounts.supplier_id\n" +
                    "                        WHERE\n" +
                    "                            s.flag_deleted = 0\n" +
                    "                            AND code like concat ('%',:code ,'%')\n" +
                    "                            AND name like concat ('%',:name ,'%')\n" +
                    "                            AND phone_number like concat ('%',:phoneNumber ,'%')\n" +
                    "                            AND address like concat ('%',:address ,'%')\n" +
                    "                        GROUP BY\n" +
                    "                            s.id,\n" +
                    "                            s.code,\n" +
                    "                            s.name,\n" +
                    "                            s.phone_number,\n" +
                    "                            s.address,\n" +
                    "                            s.note,\n" +
                    "                            CASE WHEN COALESCE(total_invoice_detail_amount , 0) < 0 THEN 0\n" +
                    "                                 ELSE COALESCE(total_invoice_detail_amount , 0)\n" +
                    "                            END")
    Page<ISupplierProjection> getListSupplier(Pageable pageable,@Param("code")String code,@Param("name")String name,
                                              @Param("phoneNumber")String phoneNumber,@Param("address")String address);


    /**
     * method :createSupplier()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Supplier supplier
     * return void
     */
    @Modifying
    @Query(value = "INSERT INTO supplier (code, name, email, address, phone_number, note, flag_deleted) " +
            "VALUES (:#{#supplier.code}, :#{#supplier.name}, :#{#supplier.email}, " +
            ":#{#supplier.address}, :#{#supplier.phoneNumber}, :#{#supplier.note}, 0)", nativeQuery = true)
    void createSupplier(@Param("supplier") Supplier supplier);
    /**
     * method :updateSupplierById()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param:  Supplier supplier
     * return void
     */
    @Modifying
    @Query(nativeQuery = true,
           value = "UPDATE supplier SET code = :#{#supplier.code}," +
                   " name = :#{#supplier.name}," +
                   " email = :#{#supplier.email}," +
                   " address = :#{#supplier.address}," +
                   " phone_number = :#{#supplier.phoneNumber}," +
                   " note = :#{#supplier.note}" +
                   " WHERE (id = :#{#supplier.id});")
    void updateSupplierById(@Param("supplier") Supplier supplier);
    /**
     * method :deleteSupplierById()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Long id
     * return void
     */
    @Modifying
    @Query(nativeQuery = true,
           value = "update supplier set flag_deleted = 1 where id = :id and flag_deleted = 0")
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
                   "supplier.phone_number,supplier.note,supplier.flag_deleted" +
                   " from supplier where id = :id and flag_deleted = 0")
    Supplier getSupplierById(@Param("id") Long id);

    @Query(nativeQuery = true,
            value = "SELECT\n" +
                    "    s.id AS idSupplier,\n" +
                    "    s.code AS codeSupplier,\n" +
                    "    s.name AS nameSupplier,\n" +
                    "    s.phone_number AS phoneNumber,\n" +
                    "    s.address AS address,\n" +
                    "    s.note AS note,\n" +
                    "    CASE WHEN COALESCE(total_invoice_detail_amount - total_paid_amount, 0) < 0 THEN 0\n" +
                    "         ELSE COALESCE(total_invoice_detail_amount - total_paid_amount, 0)\n" +
                    "        END AS debt\n" +
                    "FROM\n" +
                    "    supplier s\n" +
                    "        LEFT JOIN\n" +
                    "    (\n" +
                    "        SELECT\n" +
                    "            i.supplier_id,\n" +
                    "            SUM(i.paid) OVER (PARTITION BY i.supplier_id) AS total_paid_amount\n" +
                    "        FROM\n" +
                    "            invoice i\n" +
                    "        WHERE\n" +
                    "                i.flag_deleted = 0\n" +
                    "    ) AS paid_amounts ON s.id = paid_amounts.supplier_id\n" +
                    "        LEFT JOIN\n" +
                    "    (\n" +
                    "        SELECT\n" +
                    "            i.supplier_id,\n" +
                    "            SUM(id.medicine_quantity * m.price) OVER (PARTITION BY i.supplier_id) AS total_invoice_detail_amount\n" +
                    "        FROM\n" +
                    "            invoice_detail id\n" +
                    "                JOIN\n" +
                    "            invoice i ON id.invoice_id = i.id\n" +
                    "                JOIN\n" +
                    "            medicine m ON id.medicine_id = m.id\n" +
                    "        WHERE\n" +
                    "                i.flag_deleted = 0\n" +
                    "          AND id.flag_deleted = 0\n" +
                    "    ) AS invoice_detail_amounts ON s.id = invoice_detail_amounts.supplier_id\n" +
                    "WHERE\n" +
                    "        s.flag_deleted = 0 AND s.id = :id\n" +
                    "\n" +
                    "GROUP BY\n" +
                    "    s.id,\n" +
                    "    s.code,\n" +
                    "    s.name,\n" +
                    "    s.phone_number,\n" +
                    "    s.address,\n" +
                    "    s.note,\n" +
                    "    CASE WHEN COALESCE(total_invoice_detail_amount - total_paid_amount, 0) < 0 THEN 0\n" +
                    "         ELSE COALESCE(total_invoice_detail_amount - total_paid_amount, 0)\n" +
                    "        END")
    ISupplierProjection getSupplierDetailById(@Param("id") Long id);
    /**
     * method :findAllListInvoiceByIdSupplier()
     * created by :ThanhVH
     * date create: 14/09/2023
     *
     * @param: Long id, Pageable pageable
     * return Page<IInvoiceProjection>
     */

    @Query( nativeQuery = true,
            value = "SELECT                                          invoice.id as idInvoice,\n" +
                    "                                          invoice.`code` as codeInvoice,\n" +
                    "                                          invoice.document_number as documentNumber,\n" +
                    "                                          DATE(invoice.creation_date) AS createDate,\n" +
                    "                                          TIME(invoice.creation_date) AS createTime,\n" +
                    "                                          SUM(medicine.quantity * medicine.price) AS totalAmount,\n" +
                    "                                          CASE\n" +
                    "                                            WHEN (ANY_VALUE(medicine.quantity) * ANY_VALUE(medicine.price)) < 0 THEN 0\n" +
                    "                                            ELSE (ANY_VALUE(medicine.quantity) * ANY_VALUE(medicine.price))\n" +
                    "                                          END AS amountDue\n" +
                    "                                        FROM\n" +
                    "                                          invoice\n" +
                    "                                        JOIN\n" +
                    "                                          invoice_detail ON invoice_detail.invoice_id = invoice.id\n" +
                    "                                        JOIN\n" +
                    "                                          medicine ON invoice_detail.medicine_id = medicine.id\n" +
                    "                                        JOIN\n" +
                    "                                          supplier ON invoice.supplier_id = supplier.id\n" +
                    "                                        WHERE supplier.id = :id\n" +
                    "                                        AND (DATE(invoice.creation_date) >= :startDate OR :startDate IS NULL OR :startDate = '')\n" +
                    "                                        AND (DATE(invoice.creation_date) <= :endDate OR :endDate IS NULL OR :endDate = '' )\n" +
                    "                                        GROUP BY\n" +
                    "                                          invoice.id")
    Page<IInvoiceProjection> findAllListInvoiceByIdSupplier(Long id, Pageable pageable,@Param("startDate")String startDate,
                                                            @Param("endDate") String endDate);
    /**
     * method :getListSupplier()
     * created by :ThanhVH
     * date create: 21/09/2023
     *
     * @param:
     * return List<IInvoiceProjection>
     */
    @Query(nativeQuery = true,
           value = "select s.id,s.address,s.code,s.email,s.name,s.note,s.flag_deleted,s.phone_number " +
                   "from supplier s")
    List<Supplier> getListSupplier();
    /**
     * method :getSupplierByCode()
     * created by :ThanhVH
     * date create: 21/09/2023
     *
     * @param: code
     * return Supplier
     */
    @Query(nativeQuery = true,
            value = "select s.id,s.address,s.code,s.email,s.name,s.note,s.flag_deleted,s.phone_number " +
                    "from supplier s " +
                    "where s.code = :code and s.flag_deleted = 0 ")
    Supplier getSupplierByCode(@Param("code") String code);
    /**
     * method :getSupplierByName()
     * created by :ThanhVH
     * date create: 21/09/2023
     *
     * @param: name
     * return Supplier
     */
    @Query(nativeQuery = true,
            value = "select s.id,s.address,s.code,s.email,s.name,s.note,s.flag_deleted,s.phone_number " +
                    "from supplier s " +
                    "where s.name = :name and s.flag_deleted = 0 ")
    Supplier getSupplierByName(@Param("name") String name);
    /**
     * method :getSupplierByName()
     * created by :ThanhVH
     * date create: 21/09/2023
     *
     * @param: email
     * return Supplier
     */
    @Query(nativeQuery = true,
            value = "select s.id,s.address,s.code,s.email,s.name,s.note,s.flag_deleted,s.phone_number " +
                    "from supplier s " +
                    "where s.email = :email and s.flag_deleted = 0 ")
    Supplier getSupplierByEmail(@Param("email") String email);
    /**
     * method :getSupplierByPhoneNumber()
     * created by :ThanhVH
     * date create: 21/09/2023
     *
     * @param: phoneNumber
     * return Supplier
     */
    @Query(nativeQuery = true,
            value = "select s.id,s.address,s.code,s.email,s.name,s.note,s.flag_deleted,s.phone_number " +
                    "from supplier s " +
                    "where s.phone_number = :phoneNumber and s.flag_deleted = 0 ")
    Supplier getSupplierByPhoneNumber(@Param("phoneNumber") String phoneNumber);





}
