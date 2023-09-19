package com.example.retro_care.user.controller;

import com.example.retro_care.user.common.ValidateAppUser;
import com.example.retro_care.user.config.JwtTokenUtil;
import com.example.retro_care.user.dto.AppUserDto;
import com.example.retro_care.user.dto.FacebookLoginRequest;
import com.example.retro_care.user.model.AppUser;
import com.example.retro_care.user.model.JwtResponse;
import com.example.retro_care.user.service.IAppUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class AppUserController {
    /**
     * Creater: NhatNHH
     * Created date: 15-09-2023
     * <p>
     * Function: login, logout from account, google or facebook
     */
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IAppUserService appUserService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * @param appUserDto:
     * @param bindingResult
     * @return if authortication then return jwt, roles,
     */
    @PostMapping("/login-by-username")
    public ResponseEntity<?> loginByAccount(@Valid @RequestBody AppUserDto appUserDto,
                                            BindingResult bindingResult) {

        new AppUserDto().validate(appUserDto, bindingResult);
        Map<String, String> errorsMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(errorsMap);
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
                    .body("Đăng nhập thất bại");
        }

        AppUser appUser = new AppUser();

        BeanUtils.copyProperties(appUserDto, appUser);

        UserDetails userDetails = appUserService.loadUserByUsername(appUser.getUserName());
        String jwtToken = jwtTokenUtil.generateToken(userDetails);

        ResponseCookie cookie = ResponseCookie.from("JWT", jwtToken)
                .httpOnly(false)
                .secure(false)
                .path("/")
                .maxAge(60*60*60)
                .build();



        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new JwtResponse(jwtToken, userDetails.getUsername(), userDetails.getAuthorities(), true));

    }

    @GetMapping("/login-by-facebook")
    public ResponseEntity<?> loginByFacebook(@RequestBody FacebookLoginRequest facebookLoginRequest) {
        System.out.println(facebookLoginRequest.getAccessTokenFacebook());
        return ResponseEntity
                .ok()
                .body(facebookLoginRequest
                        .getAccessTokenFacebook());
    }

    @PostMapping("/register-by-customer")
    public ResponseEntity<?> register(@Valid @RequestBody AppUserDto appUserDto,
                                      BindingResult bindingResult) {
        new AppUserDto().validate(appUserDto, bindingResult);
        ValidateAppUser.checkValidateConfirmAppUserPassword(appUserDto.getConfirmPassword(), bindingResult);
        Map<String, String> errorsMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(errorsMap);
        }
        if (!ValidateAppUser.checkVerificationPassword(appUserDto.getPassword(), appUserDto.getConfirmPassword())) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Mật khẩu không khớp, vui lòng nhập lại");
        }

        Boolean existsByUsername = appUserService.existsByUsername(appUserDto.getUserName());
        if (existsByUsername) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Tài khoản này đã tồn tại");
        }

        AppUser appUser = new AppUser();
        BeanUtils.copyProperties(appUserDto, appUser);
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        Boolean checkAddNewAppUser = appUserService.createNewAppUser(appUser);
        if (!checkAddNewAppUser) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đăng ký thất bại, vui lòng chờ trong giây lất");
        }
        return ResponseEntity.ok("Đăng ký thành công, vui lòng bấm nút đăng nhập");
    }

    @PostMapping("/register-by-manager")
    public ResponseEntity<?> registerByManager(@RequestParam String userName) {
        //check validate userName
        String errMsg = ValidateAppUser.checkValidateOnlyAppUserName(userName);
        if (!errMsg.equals("")){
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(errMsg);
        }
        Boolean userNameExisted = appUserService.existsByUsername(userName);
        if (userNameExisted) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Tài khoản này đã tồn tại");
        }

        AppUser appUser = new AppUser();
        appUser.setUserName(userName);
        appUser.setPassword(passwordEncoder.encode("123"));
        Boolean checkAddNewAppUser = appUserService.createNewAppUser(appUser);
        if (!checkAddNewAppUser) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Đăng ký thất bại, vui lòng chờ trong giây lất");
        }
        return ResponseEntity.ok("Đăng ký thành công, vui lòng đăng nhập");
    }



}
