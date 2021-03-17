package com.project.user.security;

import com.project.user.entity.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").hasAnyRole("ADMIN","USER")
                .antMatchers("/users/").hasRole("ADMIN")
                .antMatchers("/invoices/").hasRole( "USER")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
              //.antMatchers("/invoices/").hasAuthority("USER")
              // .antMatchers("/invoices/**").hasAuthority("USER")
              //  .antMatchers("/invoices/new").hasAuthority("USER")
               // .antMatchers("/invoices/update/**").hasAuthority("USER")
               // .antMatchers("/invoices/delete/**").hasAuthority("USER")
               // .antMatchers("/invoices/searchMonthly/****/**").hasAuthority("USER")
               // .antMatchers("/invoices/searchYearly/****").hasAuthority("USER")
                //.antMatchers("/invoices/searchYearly/****").hasAuthority("USER")

               // .antMatchers("/users/").hasAuthority("ADMIN")
              //  .antMatchers("/users/**").hasAuthority("ADMIN")
              //  .antMatchers("/users/new").hasAuthority("ADMIN")
               // .antMatchers("/users/update/**").hasAuthority("ADMIN")
               // .antMatchers("/users/delete/**").hasAuthority("ADMIN")
                //.anyRequest().authenticated()
            //    .and()
              //  .formLogin().permitAll()
             //   .and()
              //  .logout().permitAll()
              //  .and()
              //  .exceptionHandling().accessDeniedPage("/403")

