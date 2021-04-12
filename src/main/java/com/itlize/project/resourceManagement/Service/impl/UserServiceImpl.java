package com.itlize.project.resourceManagement.Service.impl;

import com.itlize.project.resourceManagement.Entity.Project;
import com.itlize.project.resourceManagement.Entity.User;
import com.itlize.project.resourceManagement.Repository.ProjectRepository;
import com.itlize.project.resourceManagement.Repository.UserRepository;
import com.itlize.project.resourceManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public ProjectRepository projectRepository;

    public boolean authenticateUser(User user){
        final Optional<User> us = userRepository.findByUser(user.getUser());
        if(us.isPresent()){
            // todo check password
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();

    }

    @Override
    public User findOneById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user){
        return userRepository.save(user);
   }
    @Override
   public void delete(Integer id){
         userRepository.deleteById(id);
   }
}
