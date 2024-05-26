//package com.example.BasicSecurityAuth.Service;
//
//import com.example.BasicSecurityAuth.security.CustomUserDetails;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        if ("user@example.com".equals(email)) {
//            return new CustomUserDetails(email, new BCryptPasswordEncoder().encode("password"));
//        } else {
//            throw new UsernameNotFoundException("User not found");
//        }
//    }
//}
