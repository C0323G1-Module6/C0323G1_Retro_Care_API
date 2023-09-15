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

    @GetMapping("/general")
    public ResponseEntity<List<?>> findReport(@RequestParam(defaultValue = "") String startDate,
                                              @RequestParam(defaultValue = "") String endDate,
                                              @RequestParam(defaultValue = "") String reportName) {
        switch (reportName) {
            case "revenue":
                List<Revenue> revenueList = reportService.findRevenue(startDate, endDate);
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
                List<SaleDiary> saleDiaryList = reportService.findSaleDiary();
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

    @GetMapping("/chart/revenue")
    public ResponseEntity<List<Revenue>> findRevenue(@RequestParam(defaultValue = "") String startDate,
                                                     @RequestParam(defaultValue = "") String endDate) {
        List<Revenue> revenueList = reportService.findRevenue(startDate, endDate);
        if (revenueList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(revenueList, HttpStatus.OK);
    }

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
