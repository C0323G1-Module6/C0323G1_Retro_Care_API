package com.example.retro_care.user.service;

import com.example.retro_care.user.dto.AppUserDto;
import com.example.retro_care.user.model.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;

import java.util.Map;

public interface IAppUserService extends UserDetailsService {

    Boolean existsByUsername(String userName);

    Boolean createNewAppUser(AppUser appUser,String role);

    Boolean logout(String userName);
    Long findAppUserIdByUserName(String userName);


}
