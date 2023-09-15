package com.example.retro_care.report.service;

import com.example.retro_care.report.dto.*;
import com.example.retro_care.report.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService implements IReportService {
    @Autowired
    private IRevenueRepository revenueRepository;
    @Autowired
    private IProfitRepository profitRepository;
    @Autowired
    private IDebtRepository debtRepository;
    @Autowired
    private IExpireMedicine expireMedicine;
    @Autowired
    private IBestSellerRepository bestSellerRepository;
    @Autowired
    private ISaleDiaryRepository saleDiaryRepository;
    @Autowired
    private IMedicineNeedMoreRepository medicineNeedMoreRepository;

    @Override
    public List<Revenue> findRevenue(String startDate, String endDate) {
        return revenueRepository.findRevenue(startDate, endDate);
    }

    @Override
    public List<Profit> findProfit(String startDate, String endDate) {
        return profitRepository.findProfit(startDate, endDate);
    }

    @Override
    public List<Debt> findDebt() {
        return debtRepository.findDebt();
    }

    @Override
    public List<ExpireMedicine> findExpireMedicine() {
        return expireMedicine.findExpireMedicine();
    }

    @Override
    public List<BestSellerMedicine> findBestSellerMedicine() {
        return bestSellerRepository.findBestSellerMedicine();
    }

    @Override
    public List<SaleDiary> findSaleDiary() {
        return saleDiaryRepository.findSaleDiary();
    }

    @Override
    public List<MedicineNeedMore> findMedicineNeedMore() {
        return medicineNeedMoreRepository.findMedicineNeedMore();
    }
}
