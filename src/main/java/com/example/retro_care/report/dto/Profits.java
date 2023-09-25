package com.example.retro_care.report.dto;

public class Profits {
    private String sellDate;
    private Double total;

    public Profits() {
    }

    public Profits(String sellDate, Double total) {
        this.sellDate = sellDate;
        this.total = total;
    }

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
