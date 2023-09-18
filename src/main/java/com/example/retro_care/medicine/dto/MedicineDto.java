package com.example.retro_care.medicine.dto;

import com.example.retro_care.kind_of_medicine.model.KindOfMedicine;
import com.example.retro_care.medicine.model.ImageMedicine;
import com.example.retro_care.medicine.model.UnitDetail;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;


public class MedicineDto implements Validator {
    private Long id;

    private String code;
    @NotBlank(message = "Không được để trống trường này")
    private String name;
    private Double price;
    private Long quantity;
    private Float vat;
    private String note;




    private String maker;
    @NotBlank(message = "Không được để trống trường này")
    private String activeElement;
    private String origin;
    private Float retailProfits;
    private Boolean flagDeleted;
    private KindOfMedicine kindOfMedicine;
    private UnitDetail unitDetail;
    private ImageMedicine imageMedicine;

    public MedicineDto() {
    }

    public MedicineDto(Long id, String code, String name, Double price, Long quantity, Float vat, String note, String maker, String activeElement, String origin, Float retailProfits, Boolean flagDeleted, KindOfMedicine kindOfMedicine, UnitDetail unitDetail, ImageMedicine imageMedicine) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.vat = vat;
        this.note = note;
        this.maker = maker;
        this.activeElement = activeElement;
        this.origin = origin;
        this.retailProfits = retailProfits;
        this.flagDeleted = flagDeleted;
        this.kindOfMedicine = kindOfMedicine;
        this.unitDetail = unitDetail;
        this.imageMedicine = imageMedicine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Float getVat() {
        return vat;
    }

    public void setVat(Float vat) {
        this.vat = vat;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getActiveElement() {
        return activeElement;
    }

    public void setActiveElement(String activeElement) {
        this.activeElement = activeElement;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Float getRetailProfits() {
        return retailProfits;
    }

    public void setRetailProfits(Float retailProfits) {
        this.retailProfits = retailProfits;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public KindOfMedicine getKindOfMedicine() {
        return kindOfMedicine;
    }

    public void setKindOfMedicine(KindOfMedicine kindOfMedicine) {
        this.kindOfMedicine = kindOfMedicine;
    }

    public UnitDetail getUnitDetail() {
        return unitDetail;
    }

    public void setUnitDetail(UnitDetail unitDetail) {
        this.unitDetail = unitDetail;
    }

    public ImageMedicine getImageMedicine() {
        return imageMedicine;
    }

    public void setImageMedicine(ImageMedicine imageMedicine) {
        this.imageMedicine = imageMedicine;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
