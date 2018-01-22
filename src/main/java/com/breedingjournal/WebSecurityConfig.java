package com.breedingjournal;

/**
 * Created by b0665923 on 2017-05-08.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
              .antMatchers( "/css/**",
                      "/js/**",
                      "/**/favicon.ico",
                      "/webjars/**",
                      "/**/static/**",
                      "/img/**",
                      "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().failureUrl("/login?error")
                .defaultSuccessUrl("/addcopulation")
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        http.authorizeRequests().antMatchers("/img/**").permitAll();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
    }
}
