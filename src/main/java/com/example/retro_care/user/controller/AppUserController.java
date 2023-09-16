//package com.example.retro_care.user.controller;
//
//import com.example.retro_care.user.config.JwtTokenUtil;
//import com.example.retro_care.user.dto.AppUserDto;
//import com.example.retro_care.user.model.AppUser;
//import com.example.retro_care.user.model.JwtResponse;
//import com.example.retro_care.user.service.IAppUserService;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseCookie;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.*;
//
//@RestController
//@CrossOrigin("*")
//@RequestMapping("/api")
//public class AppUserController {
//    /**
//     * Creater: NhatNHH
//     * Created date: 15-09-2023
//     *
//     * Function: login, logout from account, google or facebook
//     *
//     */
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private IAppUserService appUserService;
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    /**
//     * @param appUserDto:
//     * @param bindingResult
//     * @return if authortication then return jwt, roles,
//     */
//    @PostMapping("/login")
//    public ResponseEntity<?> loginByAccount(@Valid @RequestBody AppUserDto appUserDto,
//                                            BindingResult bindingResult) {
//
//        new AppUserDto().validate(appUserDto, bindingResult);
//        Map<String, String> errorsMap = new HashMap<>();
//        if (bindingResult.hasErrors()) {
//            for (FieldError fieldError : bindingResult.getFieldErrors()) {
//                errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
//            }
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorsMap);
//        }
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                    appUserDto.getUserName(), appUserDto.getPassword()));
//        } catch (DisabledException e) {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Tài khoản của bạn đã bị vô hiệu hoá");
//        } catch (BadCredentialsException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Đăng nhập thất bại");
//        }
//
//        AppUser appUser = new AppUser();
//
//        BeanUtils.copyProperties(appUserDto, appUser);
//
//        UserDetails userDetails = appUserService.loadUserByUsername(appUser.getUserName());
//        String jwtToken = jwtTokenUtil.generateToken(userDetails);
//
//        ResponseCookie cookie = ResponseCookie.from("JWT", jwtToken)
//                .httpOnly(false)
//                .secure(false)
//                .path("/")
//                .build();
//        return ResponseEntity
//                .ok()
//                .header(HttpHeaders.SET_COOKIE,cookie.toString())
//                .body(new JwtResponse(jwtToken, userDetails.getUsername(), userDetails.getAuthorities(), true));
//
//    }
//}
