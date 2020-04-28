package com.membership.system.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import com.membership.system.security.JwtSecurityConfigurer;
import com.membership.system.security.JwtTokenProvider;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().authorizeRequests().antMatchers("/auth/signin").permitAll()
        .antMatchers("/auth/register").permitAll()
        .antMatchers("/**").hasRole("USER")
        .anyRequest().authenticated()
        .and().apply(new JwtSecurityConfigurer(jwtTokenProvider));
    }
    
    @Bean
    public PasswordEncoder delegatingPasswordEncoder() {
        PasswordEncoder defaultEncoder = new StandardPasswordEncoder();
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        
        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", encoders);
        
        passwordEncoder.setDefaultPasswordEncoderForMatches(defaultEncoder);
        
        return passwordEncoder;
    }
    
}
