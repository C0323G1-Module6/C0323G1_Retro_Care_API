package com.example.retro_care.supplier.dto;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SupplierDto  {
    private Long id;
    @NotBlank(message = "Vui lòng không được để trống trường này.")
    @Size(max = 30, min = 3 , message = "Mã nhà cung cấp tối thiểu 3 ký tự và tối đa 30 ký tự.")
    @Pattern(regexp = "^(?!.*[^A-Z])(?!.*\\s)[A-Z]{3,30}$",message = "Các ký tự được viết hoa,không có khoảng trắng,không có ký tự đặc biệt vd: NUTINE")
    private String code;
    @NotBlank(message = "Vui lòng không được để trống trường này.")
    @Size(max = 100, min = 3,message = "Tên nhà cung cấp tối thiểu 3 ký tự và tối đa 100 ký tự.")
            @Pattern(regexp = "^[\\p{Lu}][\\p{Ll}]*([\\s][\\p{Lu}][\\p{Ll}]*)*$",message = "Vui lòng viết hoa chữ cái đầu của từng từ và có khoảng trắng giữa các từ, vd: Dược Phẩm Pharmacity")
    private String name;

    @NotBlank(message = "Vui lòng không được để trống trường này.")
    @Size(min = 12,max = 50,message = "Email tối thiểu 12 ký tự và tối đa 50 ký tự." )
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Vui lòng nhập theo định dạng: xxx@xxx.xxx với x không phải là ký tự đặc biệt ")
    private String email;
    @NotBlank(message = "Vui lòng không được để trống trường này.")
    @Size(min = 5,max = 150,message = "Địa chỉ tối thiểu 5 ký tự và tối đa 150 ký tự." )
    private String address;
    @NotBlank(message = "Vui lòng không được để trống trường này.")
    @Size(min = 10,max = 10, message = "Vui lòng nhập 10 chữ số.")
    @Pattern(regexp = "^0\\d{9}$" ,message = "Vui lòng nhập theo định dạng 0xxxxxxxxx với x là ký tự số.")
    private String phoneNumber;
    private String note;
    private Boolean flagDeleted;

    public SupplierDto() {
    }


    public SupplierDto(String code, String name, String email, String address, String phoneNumber, String note) {
        this.code = code;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.note = note;
    }

    public SupplierDto(String code, String name, String email, String address, String phoneNumber, String note, Boolean flagDeleted) {
        this.code = code;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.note = note;
        this.flagDeleted = flagDeleted;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

}
