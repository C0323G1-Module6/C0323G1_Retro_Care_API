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


    /**
     * Author: DuyTV
     * Goal: Get data of revenue report
     * Date created: 15/09/2023
     * @param startDate
     * @param endDate
     * @return List of Revenue
     */
    @Override
    public List<Revenue> findRevenue(String startDate, String endDate) {
        return revenueRepository.findRevenue(startDate, endDate);
    }



    /**
     * Author: DuyTV
     * Goal: Get data of profit report
     * Date created: 15/09/2023
     * @param startDate
     * @param endDate
     * @return List of Profit
     */
    @Override
    public List<Profit> findProfit(String startDate, String endDate) {
        return profitRepository.findProfit(startDate, endDate);
    }



    /**
     * Author: DuyTV
     * Goal: Get list of supplier that retro care pharmacy has debt
     * Date created: 15/09/2023
     * @return List of Debt
     */
    @Override
    public List<Debt> findDebt() {
        return debtRepository.findDebt();
    }



    /**
     * Author: DuyTV
     * Goal: Get list of medicine that will expire after 10 days
     * Date created: 15/09/2023
     * @return List of Medicine
     */
    @Override
    public List<ExpireMedicine> findExpireMedicine() {
        return expireMedicine.findExpireMedicine();
    }


    /**
     * Author: DuyTV
     * Goal: Get list of 100 bestseller medicines
     * Date created: 15/09/2023
     * @return List of BestSellerMedicine
     */
    @Override
    public List<BestSellerMedicine> findBestSellerMedicine() {
        return bestSellerRepository.findBestSellerMedicine();
    }



    /**
     * Author: DuyTV
     * Goal: Get data of sale diary report
     * Date created: 15/09/2023
     * @param startDate
     * @param endDate
     * @return List of SaleDiary
     */
    @Override
    public List<SaleDiary> findSaleDiary(String startDate, String endDate) {
        return saleDiaryRepository.findSaleDiary(startDate,endDate);
    }




    /**
     * Author: DuyTV
     * Goal: Get list of medicine that need buy more from suppliers ( shows medicines have quantity on stock less than 5)
     * Date created: 15/09/2023
     * @return List of Medicine
     */
    @Override
    public List<MedicineNeedMore> findMedicineNeedMore() {
        return medicineNeedMoreRepository.findMedicineNeedMore();
    }
}
