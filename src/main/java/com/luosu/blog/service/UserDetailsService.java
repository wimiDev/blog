package com.luosu.blog.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
    public UserDetails loadUserByUsername(String username, String pwd);
    public UserDetails loadUserByEmail(String email, String pwd);
}
