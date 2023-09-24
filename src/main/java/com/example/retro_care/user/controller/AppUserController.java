package com.example.retro_care.user.controller;

import com.example.retro_care.customer.service.ICustomerService;
import com.example.retro_care.user.common.RandomStringGenerator;
import com.example.retro_care.user.common.ValidateAppUser;
import com.example.retro_care.user.config.JwtTokenUtil;
import com.example.retro_care.user.dto.AppUserDto;
import com.example.retro_care.user.dto.FacebookMailRequest;
import com.example.retro_care.user.model.AppUser;
import com.example.retro_care.user.model.JwtResponse;
import com.example.retro_care.user.service.IAppUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class AppUserController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IAppUserService appUserService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ICustomerService customerService;

    private static final String LOGIN_FAILED = "Đăng nhập thất bại";
    /**
     * method loginByAccount
     * Creater NhatNHH
     * Date 15-09-2023
     * param AppUserDto appUserDto, BindingResult bindingResult
     * return JwtResponse(jwtToken)
     */
    @PostMapping("/login-by-username")
    public ResponseEntity<Object> loginByAccount(@Valid @RequestBody AppUserDto appUserDto,
                                            BindingResult bindingResult) {

        new AppUserDto().validate(appUserDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(LOGIN_FAILED);
        }
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    appUserDto.getUserName(), appUserDto.getPassword()));
        } catch (DisabledException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Tài khoản của bạn đã bị vô hiệu hoá");
        } catch (BadCredentialsException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(LOGIN_FAILED);
        }

        AppUser appUser = new AppUser();

        BeanUtils.copyProperties(appUserDto, appUser);

        UserDetails userDetails = appUserService.loadUserByUsername(appUser.getUserName());

        String jwtToken = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity
                .ok()
                .body(new JwtResponse(jwtToken));

    }

    /**
     * method loginByFacebook
     * Creater NhatNHH
     * Date 16-09-2023
     * param FacebookMailRequest facebookMailRequest
     * return JwtResponse(jwtToken)
     */
    @PostMapping("/login-by-facebook")
    public ResponseEntity<Object> loginByFacebook(@RequestBody FacebookMailRequest facebookMailRequest) {
        if (facebookMailRequest == null ||
                facebookMailRequest.getFacebookMail() == null ||
                facebookMailRequest.getFacebookMail().trim().equals("")) {
            return ResponseEntity
                    .badRequest()
                    .body(LOGIN_FAILED);
        }

        String facebookMail = facebookMailRequest.getFacebookMail();
        boolean checkExistAppUser = appUserService.existsByUsername(facebookMail);
        if (!checkExistAppUser) {
            AppUser appUser = new AppUser();
            appUser.setUserName(facebookMail);
            String randomPassword = RandomStringGenerator.generateRandomString();
            appUser.setPassword(passwordEncoder.encode(randomPassword));
            appUserService.createNewAppUser(appUser,"ROLE_CUSTOMER");
            Long appUserId = appUserService.findAppUserIdByUserName(appUser.getUserName());
            customerService.saveCustomerForAppUser(appUserId);
        }
        UserDetails userDetails = appUserService.loadUserByUsername(facebookMail);

        String jwtToken = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity
                .ok()
                .body(new JwtResponse(jwtToken));
    }

    /**
     * method registerByCustomer
     * Creater NhatNHH
     * Date 15-09-2023
     * param AppUserDto appUserDto, BindingResult bindingResult
     * return ResponseEntity.ok(Register Success)
     */
    @PostMapping("/register-by-customer")
    public ResponseEntity<Object> registerByCustomer(@Valid @RequestBody AppUserDto appUserDto,
                                                BindingResult bindingResult) {
        new AppUserDto().validate(appUserDto, bindingResult);
        ValidateAppUser.checkValidateConfirmAppUserPassword(appUserDto.getConfirmPassword(), bindingResult);
        Map<String, String> errorsMap = new HashMap<>();
        if (!ValidateAppUser.checkVerificationPassword(appUserDto.getPassword(), appUserDto.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword","","Mật khẩu không khớp");
        }
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(errorsMap);
        }
        boolean existsByUsername = appUserService.existsByUsername(appUserDto.getUserName());
        if (existsByUsername) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Tài khoản này đã tồn tại");
        }

        AppUser appUser = new AppUser();
        BeanUtils.copyProperties(appUserDto, appUser);
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        Boolean checkAddNewAppUser = appUserService.createNewAppUser(appUser,"ROLE_CUSTOMER");
        if (Boolean.FALSE.equals(checkAddNewAppUser)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đăng ký thất bại, vui lòng chờ trong giây lất");
        }
        Long appUserId = appUserService.findAppUserIdByUserName(appUser.getUserName());
        customerService.saveCustomerForAppUser(appUserId);
        return ResponseEntity.ok("Đăng ký thành công, vui lòng bấm nút đăng nhập");
    }

    /**
     * method registerByManager
     * Creater NhatNHH
     * Date 15-09-2023
     * param String userName
     * return ResponseEntity.ok(Register Success)
     */
    @PostMapping("/register-by-manager")
    public ResponseEntity<Object> registerByManager(@RequestParam String userName) {

        String errMsg = ValidateAppUser.checkValidateOnlyAppUserName(userName);
        if (!errMsg.equals("")) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(errMsg);
        }
        boolean userNameExisted = appUserService.existsByUsername(userName);
        if (userNameExisted) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Tài khoản này đã tồn tại");
        }
        AppUser appUser = new AppUser();
        appUser.setUserName(userName);
        appUser.setPassword(passwordEncoder.encode("123"));
        boolean checkAddNewAppUser = appUserService.createNewAppUser(appUser,"ROLE_EMPLOYEE");
        if (!checkAddNewAppUser) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Đăng ký thất bại, vui lòng chờ trong giây lát");
        }
        return ResponseEntity.ok("Đăng ký thành công");
    }

    /**
     * method logout
     * Creater NhatNHH
     * Date 15-09-2023
     * param String userName
     * return ResponseEntity.ok(Logout Success)
     */
    @GetMapping("/logout/{userName}")
    public ResponseEntity<Object> logout(@PathVariable String userName) {
        boolean logout = appUserService.logout(userName);
        if (logout) {
            return ResponseEntity.ok("Đăng xuất thành công");
        }
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Đăng xuất thất bại, vui lòng chờ trong giây lát");
    }

    @GetMapping("/get-id-app-user/{userName}")
    public ResponseEntity<Object> getIdByAppUserName(@PathVariable String userName){
        Long id = appUserService.findAppUserIdByUserName(userName);
        if(id == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không có dữ liệu");
        }
        return ResponseEntity.ok().body(id);
    }
}
