package com.company.config;

import com.company.entity.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Optional;

public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByName(username);
        UserBuilder builder = null;
        if(user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(user.getPassword()); //new BCryptPasswordEncoder().encode(user.getPassword()));
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

//    public UserDetails loadUserByUsernameAndPassword(String name, String pass) {
//        User user = userRepository.findByNameAndPassword(name,pass);
//        return new org.springframework.security.core.userdetails.User(user.getLogin(),
//                user.getPassword(), user.getRole(), DummyAuthority.getAuth());
//    }

//    private UserDetails toUserDetails(User user) {
//        return new org.springframework.security.core.userdetails
//                .User.withUsername(user.getLogin())
//                .password(user.getPassword())
//                .roles(user.getRole()).build();
//    }


}
