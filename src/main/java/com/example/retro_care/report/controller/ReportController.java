package com.example.retro_care.report.controller;

import com.example.retro_care.report.dto.*;
import com.example.retro_care.report.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/report")
public class ReportController {
    @Autowired
    private IReportService reportService;

    /**
     * Author: DuyTV
     * Goal: Get data report base on start date, end date àn name of report
     * Date created: 15/09/2023
     * @param startDate
     * @param endDate
     * @param reportName
     * @return ResponseEntity includes report data and HttpStatus
     */

    @GetMapping("/general")
    public ResponseEntity<List<?>> findReport(@RequestParam(defaultValue = "",required = false) String startDate,
                                              @RequestParam(defaultValue = "",required = false) String endDate,
                                              @RequestParam(defaultValue = "",required = false) String reportName) {
        switch (reportName) {
            case "revenue":
                List<Revenue> revenueList = reportService.findRevenue(startDate, endDate);
                System.out.println(revenueList);
                if (revenueList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(revenueList, HttpStatus.OK);
            case "profit":
                List<Profit> profitList = reportService.findProfit(startDate, endDate);
                if (profitList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(profitList, HttpStatus.OK);
            case "debt":
                List<Debt> debtList = reportService.findDebt();
                if (debtList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(debtList, HttpStatus.OK);
            case "expireMedicine":
                List<ExpireMedicine> expireMedicineList = reportService.findExpireMedicine();
                if (expireMedicineList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(expireMedicineList, HttpStatus.OK);
            case "bestSellerMedicine":
                List<BestSellerMedicine> bestSellerMedicineList = reportService.findBestSellerMedicine();
                if (bestSellerMedicineList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(bestSellerMedicineList, HttpStatus.OK);
            case "saleDiary":
                List<SaleDiary> saleDiaryList = reportService.findSaleDiary(startDate,endDate);
                if (saleDiaryList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(saleDiaryList, HttpStatus.OK);
            case "medicineNeedMore":
                List<MedicineNeedMore> medicineNeedMoreList = reportService.findMedicineNeedMore();
                if (medicineNeedMoreList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(medicineNeedMoreList, HttpStatus.OK);
            default:
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    /**
     * Author: DuyTV
     * Goal: Get data report of revenue to make revenue - profit chart
     * Date created: 15/09/2023
     * @param startDate
     * @param endDate
     * @return ResponseEntity includes revenue data, HttpStatus
     */

    @GetMapping("/chart/revenue")
    public ResponseEntity<List<Revenue>> findRevenue(@RequestParam(defaultValue = "") String startDate,
                                                     @RequestParam(defaultValue = "") String endDate) {
        List<Revenue> revenueList = reportService.findRevenue(startDate, endDate);
        if (revenueList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(revenueList, HttpStatus.OK);
    }

    /**
     * Author: DuyTV
     * Goal: Get data report of profit to make revenue - profit chart
     * Date created: 15/09/2023
     * @param startDate
     * @param endDate
     * @return ResponseEntity includes revenue data, HttpStatus
     */
    @GetMapping("/chart/profit")
    public ResponseEntity<List<Profit>> findProfit(@RequestParam(defaultValue = "") String startDate,
                                                   @RequestParam(defaultValue = "") String endDate) {
        List<Profit> profitList = reportService.findProfit(startDate, endDate);
        if (profitList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(profitList, HttpStatus.OK);
    }


}
