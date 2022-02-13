package com.innova.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
public class _05_SecurityFormLogin extends WebSecurityConfigurerAdapter {

    //Authantication için form sayfası açılıyor -> formLogin
    //Ancak yine username ve password olmadığı için giriş yapılamıyor
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and();

    }
}