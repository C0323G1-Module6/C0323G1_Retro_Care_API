package com.example.retro_care.report.service;

import com.example.retro_care.report.dto.*;
import com.example.retro_care.report.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
     * @param startDate
     * @param endDate
     * @return List of SaleDiary
     */
    @Override
    public List<SaleDiary> findSaleDiary(String startDate, String endDate) {
        return saleDiaryRepository.findSaleDiary(startDate, endDate);
    }


    /**
     * Author: DuyTV
     * Goal: Get list of medicine that need buy more from suppliers ( shows medicines have quantity on stock less than 5)
     * Date created: 15/09/2023
     *
     * @return List of Medicine
     */
    @Override
    public List<MedicineNeedMore> findMedicineNeedMore() {
        return medicineNeedMoreRepository.findMedicineNeedMore();
    }


    @Override
    public List<Profits> getAllProfitDto(String startTime, String endTime) {
        List<Profits> profitList = new ArrayList<>();
        List<ProfitDto> profitDtoList = profitRepository.getAllProfit(startTime, endTime);
        List<ProfitDto> newProfitDto = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < profitDtoList.size() - 1; i++) {
            double max = -1;
            int index = 0;
            for (int j = 1; j < profitDtoList.size(); j++) {
                if (profitDtoList.get(i).getId().equals(profitDtoList.get(j).getId()) && Double.parseDouble(profitDtoList.get(i).getDiscount()) > max) {
                    max = Double.parseDouble(profitDtoList.get(i).getDiscount());
                    index = j;
                }
            }
            indexList.add(index);


        }
        List<Integer> indexProfits = new ArrayList<>();
        for (int i = 0; i < indexList.size(); i++) {
            if(!indexProfits.contains(indexList.get(i))){
                indexProfits.add(indexList.get(i));
            }
        }
        for (Integer i: indexProfits) {
            ProfitDto profitDto = profitDtoList.get(i);
            newProfitDto.add(profitDto);
        }

        for (ProfitDto p : newProfitDto) {
            Profits profits = new Profits();
            Double total = (Double.parseDouble(p.getCurrentPrice()) - (Double.parseDouble(p.getPrice()) - (Double.parseDouble(p.getPrice()) * (Double.parseDouble(p.getRetailProfits()) + Double.parseDouble(p.getVat()) + Double.parseDouble(p.getDiscount())) / 100))) * Double.parseDouble(p.getQuantity());
            profits.setTotal(total);
            String sellDate = p.getDateTime();
            profits.setSellDate(sellDate);
            profitList.add(profits);
        }
        return profitList;
    }
}
