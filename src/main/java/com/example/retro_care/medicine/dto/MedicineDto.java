package com.example.retro_care.medicine.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class MedicineDto implements Validator {
    private Long id;
//    @Size(max = 8)
//    @Pattern(regexp = "^[0-9a-zA-Z]{8}$")
    private String code;
    @NotBlank(message = "Không được để trống trường này")
//    @Pattern(regexp = "^[\\\\p{Lu}][\\\\p{Ll}]{1,8}(\\\\s([\\\\p{Lu}]|[\\\\p{Lu}][\\\\p{Ll}]{1,10})){0,5}$", message = "Tên  phải viết đầu bằng chữ hoa và theo sau là chữ thường ")
    private String name;
    @Min(value = 0, message = "Giá không được là số âm")
    private Double price;
    private Long quantity;
    @Min(value = 0, message = "vat không được nhỏ hơn 0")
    private Float vat;
    private String note;
    @Size(min = 2,max = 50, message = "Nhà sản xuất không được ít hơn 2 kí tự và dài hơn 50 kí tự")
    private String maker;
    @NotBlank(message = "Không được để trống trường này")
    private String activeElement;
    @NotBlank(message = "Không được để trống trường này")
    @Size(max = 50, message = "Xuất xứ không được vượt quá 50 kí tự")
    private String origin;
    @Min(value = 0, message = "Lợi nhuận bán lẻ không được nhỏ hơn 0")
    private Float retailProfits;
    private Boolean flagDeleted;
    private KindOfMedicineDto kindOfMedicineDto;
    private UnitDetailDto unitDetailDto;
    private ImageMedicineDto imageMedicineDto;

    public MedicineDto() {
    }


    public MedicineDto(Long id, String code, String name, Double price, Long quantity, Float vat, String note, String maker, String activeElement, String origin, Float retailProfits, Boolean flagDeleted, KindOfMedicineDto kindOfMedicineDto, UnitDetailDto unitDetailDto, ImageMedicineDto imageMedicineDto) {
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
        this.kindOfMedicineDto = kindOfMedicineDto;
        this.unitDetailDto = unitDetailDto;
        this.imageMedicineDto = imageMedicineDto;
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

    public KindOfMedicineDto getKindOfMedicineDto() {
        return kindOfMedicineDto;
    }

    public void setKindOfMedicineDto(KindOfMedicineDto kindOfMedicineDto) {
        this.kindOfMedicineDto = kindOfMedicineDto;
    }

    public UnitDetailDto getUnitDetailDto() {
        return unitDetailDto;
    }

    public void setUnitDetailDto(UnitDetailDto unitDetailDto) {
        this.unitDetailDto = unitDetailDto;
    }

    public ImageMedicineDto getImageMedicineDto() {
        return imageMedicineDto;
    }

    public void setImageMedicineDto(ImageMedicineDto imageMedicineDto) {
        this.imageMedicineDto = imageMedicineDto;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
