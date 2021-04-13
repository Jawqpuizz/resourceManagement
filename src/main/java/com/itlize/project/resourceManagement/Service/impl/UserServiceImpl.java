package com.itlize.project.resourceManagement.Service.impl;

import com.itlize.project.resourceManagement.Entity.Project;
import com.itlize.project.resourceManagement.Entity.User;
import com.itlize.project.resourceManagement.Repository.ProjectRepository;
import com.itlize.project.resourceManagement.Repository.UserRepository;
import com.itlize.project.resourceManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<User> findAll() {
        return userRepository.findAll();

    }

    @Override
    public User findOneById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User creatUser(User user){
        User newUser = new User();
        newUser.setUser(user.getUser());
        newUser.setRole(user.getRole());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return  userRepository.save(newUser);
   }
    @Override
   public void delete(Integer id){
         userRepository.deleteById(id);
   }


    public User updateUser(User user){
        User newUser = findOneById(user.getId());
        if(user.getUser() != null) {
            newUser.setUser(user.getUser());
        }
        if(user.getRole() != null) {
            newUser.setRole(user.getRole());
        }
        if(user.getPassword() != null) {
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return  userRepository.save(newUser);
    }
}
