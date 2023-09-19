package com.example.retro_care.user.common;

import org.springframework.validation.Errors;

public class ValidateAppUser {
    public static void checkValidateAppUserName(String name, Errors errors) {
        if (name == null || name.trim().length() == 0) {
            errors.rejectValue("userName", null, "Không để trống tài khoản");
        } else if (name.length() > 50) {
            errors.rejectValue("userName", null, "Số lượng ký tự bé hơn hoặc bằng 50");
        } else if (name.length() < 3) {
            errors.rejectValue("userName", null, "Số lượng ký tự phải lớn hơn hoặc bằng 3 ");
        }
    }

    public static void checkValidateAppUserPassword(String password, Errors errors) {
        if (password == null || password.trim().length() == 0) {
            errors.rejectValue("password", null, "Không để trống mật khẩu");
        } else if (password.length() > 50) {
            errors.rejectValue("password", null, "Số lượng ký tự bé hơn hoặc bằng 50");
        } else if (password.length() < 3) {
            errors.rejectValue("password", null, "Số lượng ký tự phải lớn hơn hoặc bằng 3 ");
        }
    }

    public static void checkValidateConfirmAppUserPassword(String confirmPassword, Errors errors) {
        if (confirmPassword == null || confirmPassword.trim().length() == 0) {
            errors.rejectValue("confirmPassword", null, "Không để trống mật khẩu");
        } else if (confirmPassword.length() > 50) {
            errors.rejectValue("confirmPassword", null, "Số lượng ký tự bé hơn hoặc bằng 50");
        } else if (confirmPassword.length() < 3) {
            errors.rejectValue("confirmPassword", null, "Số lượng ký tự phải lớn hơn hoặc bằng 3 ");
        }
    }

    public static boolean checkVerificationPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public static String checkValidateOnlyAppUserName(String name) {
        if (name == null || name.trim().length() == 0) {
            return  "Không để trống tài khoản";
        } else if (name.length() > 50) {
            return  "Số lượng ký tự bé hoặc bằng hơn 50";
        } else if (name.length() < 3) {
            return  "Số lượng ký tự phải lớn hơn hoặc bằng 3";
        }
        return "";
    }
}