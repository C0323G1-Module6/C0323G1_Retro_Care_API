package com.example.retro_care.report.controller;

import com.example.retro_care.report.dto.*;
import com.example.retro_care.report.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/report")
public class ReportController {
    @Autowired
    private IReportService reportService;

    /**
     * Author: DuyTV
     * Goal: Get data report base on start date, end date and name of report
     * Date created: 15/09/2023
     *
     * @param validateDto
     * @param bindingResult
     * @param reportName
     * @return ResponseEntity includes report data and HttpStatus
     */

    @GetMapping("/general")
    public ResponseEntity<?> findReport(@Valid @RequestBody ValidateDto validateDto, BindingResult bindingResult,
                                        @RequestParam(defaultValue = "", required = false) String reportName) {

        new ValidateDto().validate(validateDto, bindingResult);
        Map<String, String> errorsMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(errorsMap);
        }
        String startDate = validateDto.getStartDate();
        String endDate = validateDto.getEndDate();

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
     * @param validateDto
     * @param bindingResult
     * @return ResponseEntity includes revenue data, HttpStatus
     */


    @GetMapping("/chart/revenue")
    public ResponseEntity<?> findRevenue(@Valid @RequestBody ValidateDto validateDto, BindingResult bindingResult) {
        new ValidateDto().validate(validateDto, bindingResult);
        Map<String, String> errorsMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(errorsMap);
        }
        String startDate = validateDto.getStartDate();
        String endDate = validateDto.getEndDate();
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
     * @param validateDto
     * @param bindingResult
     * @return ResponseEntity includes revenue data, HttpStatus
     */
    @GetMapping("/chart/profit")
    public ResponseEntity<?> findProfit(@Valid @RequestBody ValidateDto validateDto, BindingResult bindingResult) {
        new ValidateDto().validate(validateDto, bindingResult);
        Map<String, String> errorsMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(errorsMap);
        }
        String startDate = validateDto.getStartDate();
        String endDate = validateDto.getEndDate();
        List<Profit> profitList = reportService.findProfit(startDate, endDate);
        if (profitList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(profitList, HttpStatus.OK);
    }

}
