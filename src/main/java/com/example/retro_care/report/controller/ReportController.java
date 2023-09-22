package com.example.retro_care.report.controller;

import com.example.retro_care.report.common.ValidateReportInput;
import com.example.retro_care.report.dto.*;
import com.example.retro_care.report.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private IReportService reportService;

    public static final String PROFIT = "profit";

    /**
     * Author: DuyTV
     * Goal: Get data report base on start date, end date and name of report
     * Date created: 15/09/2023
     *
     * @param startDate
     * @param endDate
     * @param reportName
     * @return ResponseEntity includes report data and HttpStatus
     */


    @GetMapping("/general")
    public ResponseEntity<Object> findReport(@RequestParam(defaultValue = "") String startDate,
                                             @RequestParam(defaultValue = "") String endDate,
                                             @RequestParam(defaultValue = "", required = false) String reportName) {

        Map<String, String> errMap = new HashMap<>();
        errMap = ValidateReportInput.validate(startDate, endDate, errMap);
        if (!errMap.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(errMap);

        }
        switch (reportName) {
            case "revenue":
                List<Revenue> revenueList = reportService.findRevenue(startDate, endDate);
                if (revenueList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(revenueList, HttpStatus.OK);
            case PROFIT:
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
                List<SaleDiary> saleDiaryList = reportService.findSaleDiary(startDate, endDate);
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
     *
     * @param startDate
     * @param endDate
     * @return ResponseEntity includes revenue data, HttpStatus
     */


    @GetMapping("/chart/revenue")
    public ResponseEntity<Object> findRevenue(@RequestParam(defaultValue = "", required = false) String startDate,
                                              @RequestParam(defaultValue = "", required = false) String endDate) {
        Map<String, String> errMap = new HashMap<>();
        errMap = ValidateReportInput.validate(startDate, endDate, errMap);
        if (!errMap.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(errMap);

        }
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
     *
     * @param startDate
     * @param endDate
     * @return ResponseEntity includes revenue data, HttpStatus
     */
    @GetMapping("/chart/profit")
    public ResponseEntity<Object> findProfit(@RequestParam(defaultValue = "", required = false) String startDate,
                                             @RequestParam(defaultValue = "", required = false) String endDate) {
        Map<String, String> errMap = new HashMap<>();
        errMap = ValidateReportInput.validate(startDate, endDate, errMap);
        if (!errMap.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(errMap);

        }
        List<Profit> profitList = reportService.findProfit(startDate, endDate);
        if (profitList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(profitList, HttpStatus.OK);
    }

    @GetMapping("/sum")
    public ResponseEntity<Object> findSum(@RequestParam(defaultValue = "", required = false) String startDate,
                                          @RequestParam(defaultValue = "", required = false) String endDate) {
        Map<String, String> errMap = new HashMap<>();
        errMap = ValidateReportInput.validate(startDate, endDate, errMap);
        if (!errMap.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(errMap);

        }
        List<Profit> profitList = reportService.findProfit(startDate, endDate);
        List<Revenue> revenueList = reportService.findRevenue(startDate, endDate);
        if (profitList.isEmpty() || revenueList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        long sumProfit = 0;
        long sumRevenue = 0;
        for (int i = 0; i < profitList.size(); i++) {
            sumProfit += Math.round(Double.parseDouble(profitList.get(i).getTotal()));
            sumRevenue += Math.round(Double.parseDouble(revenueList.get(i).getTotal()));
        }
        LocalDate beginingDate = LocalDate.parse(startDate);
        LocalDate finishingDate = LocalDate.parse(endDate);
        Period startAndEndPeriod = Period.between(beginingDate, finishingDate);
        int days = startAndEndPeriod.getDays() +1;
        SumReport sumReport = new SumReport(sumProfit, sumRevenue, sumProfit / days, sumRevenue / days);
        return new ResponseEntity<>(sumReport, HttpStatus.OK);
    }

}
