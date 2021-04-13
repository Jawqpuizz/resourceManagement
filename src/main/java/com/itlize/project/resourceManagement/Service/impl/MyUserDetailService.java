package com.itlize.project.resourceManagement.Service.impl;

import com.itlize.project.resourceManagement.Entity.User;
import com.itlize.project.resourceManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUser(username).orElse(null);
        return new org.springframework.security.core.userdetails.User(user.getUser(), user.getPassword(), new ArrayList<>());
    }
}
