package com.example.retro_care.user.service;

import com.example.retro_care.user.common.ValidateAppUser;
import com.example.retro_care.user.dto.AppUserDto;
import com.example.retro_care.user.model.AppUser;
import com.example.retro_care.user.model.UserRole;
import com.example.retro_care.user.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AppUserService implements IAppUserService {
    @Autowired
    private IAppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findAppUserByName(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("User name or password is wrong");
        }
        List<GrantedAuthority> grantList = new ArrayList<>();
        for (UserRole userRole : appUser.getUserRoleSet()) {
            grantList.add(new SimpleGrantedAuthority(userRole.getAppRole().getName()));
        }

        UserDetails userDetails = new User(appUser.getUserName(),
                appUser.getPassword(), grantList);
        return userDetails;
    }

    @Override
    public UserDetails loadUserByAppUserDto(AppUser appUser) {
        return null;
    }

    @Override
    public Boolean existsByUsername(String userName) {
        AppUser appUser = appUserRepository.findAppUserByName(userName);
        return appUser != null;
    }

    @Override
    public Boolean createNewAppUser(AppUser appUser) {
      Integer amountAppUserCreated = appUserRepository.addNewAppUser(appUser);
      return amountAppUserCreated > 0;
    }

}
