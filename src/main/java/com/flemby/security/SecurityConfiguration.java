//package com.flemby.security;
//
///**
// * Created by Paul on 20/08/2016.
// */
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//import org.springframework.security.web.csrf.CsrfTokenRepository;
//import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
//
//@Configuration
//@EnableWebMvcSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .httpBasic().and()
//                .authorizeRequests()
//                .antMatchers("/index.html", "/home.html", "/login.html", "/", "previousEventsURL.html").permitAll().anyRequest()
//                .authenticated().and()
//                .csrf().disable();
//    }
//
//    private CsrfTokenRepository csrfTokenRepository() {
//        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//        repository.setHeaderName("X-XSRF-TOKEN");
//        return repository;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // @formatter:off
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("pwd")
//                .roles("USER", "ADMIN")
//                .and()
//                .withUser("user")
//                .password("pwd")
//                .roles("USER");
//        // @formatter:on
//    }
//}