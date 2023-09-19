package com.example.retro_care.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private UserDetailsService jwtUserDetailService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    /**
     * method: configureGlobal
     * Creater: NhatNHH
     * Date: 15-09-2023
     * param: AuthenticationManagerBuilder auth
     * return: void
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * method: authenticationManagerBean
     * Creater: NhatNHH
     * Date: 15-09-2023
     * return: AuthenticationManager
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();

    }

    /**
     * method: passwordEncoder
     * Creater: NhatNHH
     * Date: 15-09-2023
     * return: PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * method: configure
     * Creater: NhatNHH
     * Date: 15-09-2023
     * return: void
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable().cors().and()
//                .authorizeRequests()
//                .antMatchers(
//                        //All role
//                        "/api/user/login-by-username/**",
//                        "/api/user/login-by-facebook/**",
//                        "/api/user/register-by-customer/**",
//                        "/api/user/logout/**",
//                        "/api/home",
//                        "/api/home/search/**",
//                        "api/home/favorite/**"
//
//                ).permitAll()
//                .antMatchers(
//                        //Authen Role admin, manager
//                        "/api/user/register-by-manager/**"
//                )
//                .hasAnyRole("ROLE_ADMIN","ROLE_MANAGER")
//                .antMatchers(
//                        //Authen Role admin, manager, employee
//                        "/api/orders",
//                        "/api/orders/list/**",
//                        "/api/orders",
//                        "/api/orders/{id}"
//
//
//
//
//
//
//
//
//
//
//                ).hasAnyRole("ROLE_ADMIN","ROLE_EMPLOYEE","ROLE_MANAGER")
//                .antMatchers(
//                        //Authen Role admin and manager
//                        "/api/invoice",
//                        "/api/invoice/delete/{id}/**",
//                        "/api/invoice/search/**",
//                        "/api/invoice/create",
//                        "/api/invoice/{invoiceId}",
//                        "/api/invoice/edit",
//                        "/api/invoice/code",
//                        "/api/kindOfMedicine",
//                        "/api/kindOfMedicine/{id}",
//                        "/api/kindOfMedicine/create",
//                        "/api/kindOfMedicine/edit/{id}",
//                        "/api/kindOfMedicine/get",
//                        "/api/medicine/{id}",
//                        "/api/medicine",
//                        "/api/medicine/"
//
//
//
//
//
//
//
//
//
//                ).hasAnyRole("ROLE_ADMIN","ROLE_MANAGER")
//                .antMatchers(
//                        //Authen Role customer
//
//                ).hasAnyRole("ROLE_CUSTOMER")
//
//
//                .anyRequest()
//                .authenticated()
//                .and()
//                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        httpSecurity
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .csrf().disable();
    }

}
