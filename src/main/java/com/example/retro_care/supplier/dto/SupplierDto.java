package com.example.retro_care.supplier.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SupplierDto implements Validator {
    private Long idSupplier;
    @NotBlank(message = "Vui lòng không được để trống trường này")
    @Size(max = 30, min = 3 , message = "Mã nhà cung cấp tối thiểu 3 ký tự và tối đa 30 ký tự")
    @Pattern(regexp = "^(?!.*[^A-Z])(?!.*\\s)[A-Z]{3,30}$",message = "Các ký tự được viết hoa,không có khoảng trắng,không có ký tự đặc biệt vd: NUTINE")
    private String codeSupplier;
    @NotBlank(message = "Vui lòng không được để trống trường này")
    @Size(max = 100, min = 3,message = "Tên nhà cung cấp tối thiểu 3 ký tự và tối đa 100 ký tự")
    @Pattern(regexp = "^[\\p{Lu}][\\p{Ll}]*([\\s][\\p{Lu}][\\p{Ll}]*)*$",message = "Vui lòng viết hoa chữ cái đầu của từng từ và có khoảng trắng giữa các từ, vd: Dược Phẩm Pharmacity")
    private String nameSupplier;

    @NotBlank(message = "Vui lòng không được để trống trường này")
    @Size(min = 12,max = 50,message = "Email tối thiểu 12 ký tự và tối đa 50 ký tự" )
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Vui lòng nhập theo định dạng: xxx@xxx.xxx với x không phải là ký tự đặc biệt ")
    private String emailSupplier;
    @NotBlank(message = "Vui lòng không được để trống trường này")
    @Size(min = 5,max = 150,message = "Email tối thiểu 5 ký tự và tối đa 150 ký tự" )
    @Pattern(regexp = "^[a-zA-Z0-9\\s\\-.,]*$", message = "Vui lòng không nhập ký tự đặc biệt")
    private String addressSupplier;
    @NotBlank(message = "Vui lòng không được để trống trường này")
    @Size(min = 10,max = 10, message = "Vui lòng nhập 10 chữ số")
    @Pattern(regexp = "^0[1-9]{9}$" ,message = "Vui lòng nhập theo định dạng 0xxxxxxxxx với x là ký tự số")
    private String telSupplier;
    private String noteSupplier;
    private Boolean flagDelete;

    public SupplierDto() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
