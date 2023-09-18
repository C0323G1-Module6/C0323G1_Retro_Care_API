package com.example.retro_care.report.repository;

import com.example.retro_care.order.model.OrderDetails;
import com.example.retro_care.report.dto.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDebtRepository extends JpaRepository<OrderDetails, Long> {
    @Query(value = "SELECT s.name as company, " +
            "(SUM((1 - invd.discount) * invd.medicine_quantity * m.price * (1 + m.vat)) - SUM(inv.paid)) as total" +
            "FROM supplier s" +
            "JOIN invoice inv ON s.id = inv.supplier_id" +
            "JOIN invoice_detail invd ON inv.id = invd.invoice_id" +
            "join medicine m on invd.medicine_id = m.id" +
            "GROUP BY s.name;", nativeQuery = true)
    List<Debt> findDebt();
}
