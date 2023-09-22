package com.example.retro_care.user.service;

import com.example.retro_care.user.dto.JwtResponseUserDetails;
import com.example.retro_care.user.model.AppUser;
import com.example.retro_care.user.model.UserRole;
import com.example.retro_care.user.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService implements IAppUserService {
    @Autowired
    private IAppUserRepository appUserRepository;
    /**
     * method: loadUserByUsername
     * Creater: NhatNHH
     * Date: 15-09-2023
     * param: String userName
     * return: UserDetails userDetails
     */
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
        UserDetails userDetails = new JwtResponseUserDetails(
                appUser.getUserName(),
                appUser.getPassword(),
                appUser.getFlagOnline(),
                grantList);
        appUserRepository.updateAppUserIsOnline(appUser);
        return userDetails;
    }
    /**
     * method: existsByUsername
     * Creater: NhatNHH
     * Date: 15-09-2023
     * param: String userName
     * return: Boolean
     */
    @Override
    public Boolean existsByUsername(String userName) {
        AppUser appUser = appUserRepository.findAppUserByName(userName);
        return appUser != null;
    }
    /**
     * method: createNewAppUser
     * Creater: NhatNHH
     * Date: 15-09-2023
     * param: AppUser appUser
     * return: Boolean
     */
    @Override
    public Boolean createNewAppUser(AppUser appUser) {
      Integer amountAppUserCreated = appUserRepository.addNewAppUser(appUser);
      return amountAppUserCreated > 0;
    }
    /**
     * method: logout
     * Creater: NhatNHH
     * Date: 15-09-2023
     * param: String userName
     * return: Boolean
     */
    @Override
    public Boolean logout(String userName) {
       return appUserRepository.updateAppUserIsOffline(userName) > 0;
    }
    @Override
    public boolean existsById(Long id){
        return appUserRepository.existsById(id);
    }
}
