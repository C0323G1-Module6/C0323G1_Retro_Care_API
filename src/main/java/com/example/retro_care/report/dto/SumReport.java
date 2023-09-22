package com.example.retro_care.report.dto;

public class SumReport {
    private Long sumProfit;
    private Long sumRevenue;
    private Long averageProfit;
    private Long averageRevenue;

    public Long getSumProfit() {
        return sumProfit;
    }

    public void setSumProfit(Long sumProfit) {
        this.sumProfit = sumProfit;
    }

    public Long getSumRevenue() {
        return sumRevenue;
    }

    public void setSumRevenue(Long sumRevenue) {
        this.sumRevenue = sumRevenue;
    }

    public Long getAverageProfit() {
        return averageProfit;
    }

    public void setAverageProfit(Long averageProfit) {
        this.averageProfit = averageProfit;
    }

    public Long getAverageRevenue() {
        return averageRevenue;
    }

    public void setAverageRevenue(Long averageRevenue) {
        this.averageRevenue = averageRevenue;
    }

    public SumReport(Long sumProfit, Long sumRevenue, Long averageProfit, Long averageRevenue) {
        this.sumProfit = sumProfit;
        this.sumRevenue = sumRevenue;
        this.averageProfit = averageProfit;
        this.averageRevenue = averageRevenue;
    }
}
