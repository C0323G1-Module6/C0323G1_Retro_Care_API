package com.example.retro_care.report.service;

import com.example.retro_care.report.dto.*;


import java.util.List;

public interface IReportService {
    List<Revenue> findRevenue(String startDate, String endDate);

    List<Profit> findProfit(String startDate, String endDate);

    List<Debt> findDebt();

    List<ExpireMedicine> findExpireMedicine();

    List<BestSellerMedicine> findBestSellerMedicine();

    List<SaleDiary> findSaleDiary();

    List<MedicineNeedMore> findMedicineNeedMore();

}
