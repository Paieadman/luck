package com.company.config;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class Security extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/authorization","/registration").permitAll()
                .anyRequest().permitAll();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
//    }
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username("user").password("pass").roles("USER").build();
        return new InMemoryUserDetailsManager(user);
    }
}
