package com.example.retro_care.supplier.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SupplierDto implements Validator {
    private Long idSupplier;
    @NotBlank(message = "Không được để trống trường này")
    @Size(max = 30, min = 3 , message = "Mã nhà cung cấp tối thiểu 3 ký tự và tối đa 30 ký tự")
    @Pattern(regexp = "^(?!.*[^A-Z])(?!.*\\s)[A-Z]{3,30}$",message = "Các ký tự được viết hoa,không có khoảng trắng,không có ký tự đặc biệt vd: NUTINE")
    private String codeSupplier;
    @NotBlank(message = "Không được để trống trường này")
    @Size(max = 100, min = 3,message = "Tên nhà cung cấp tối thiểu 3 ký tự và tối đa 100 ký tự")
    @Pattern(regexp = "^[\\p{Lu}][\\p{Ll}]*([\\s][\\p{Lu}][\\p{Ll}]*)*$",message = "Bạn phải viết hoa chữ cái đầu của từng từ và có khoảng trắng giữa các từ, vd: Dược Phẩm Pharmacity")
    private String nameSupplier;

    @NotBlank(message = "Không được để trống trường này")
    @Size(min = 12,max = 50,message = "Email tối thiểu 12 ký tự và tối đa 50 ký tự" )
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Nhập theo định dạng: xxx@xxx.xxx với x không phải là ký tự đặc biệt ")
    private String emailSupplier;
    private String addressSupplier;
    @Pattern(regexp = "^(\\(+(84)-)|(0)[1-9][0-9]{8}$" ,message = "Nhập theo định dạng +84xxxxxxxxx hoặc 0xxxxxxxxx với x là ký tự số")
    private String telSupplier;
    private String noteSupplier;
    private Boolean flagDelete;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
