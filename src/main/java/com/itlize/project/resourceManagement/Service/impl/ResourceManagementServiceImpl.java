package com.itlize.project.resourceManagement.Service.impl;

import com.itlize.project.resourceManagement.Entity.User;
import com.itlize.project.resourceManagement.Repository.UserRepository;
import com.itlize.project.resourceManagement.Service.ResourceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceManagementServiceImpl implements ResourceManagementService {
    @Autowired
    public UserRepository userRepository;


    @Override
    public User save(User user){
        return userRepository.save(user);
    };
}
