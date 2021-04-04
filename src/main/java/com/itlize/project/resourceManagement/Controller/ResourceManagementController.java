package com.itlize.project.resourceManagement.Controller;

import com.itlize.project.resourceManagement.Entity.User;
import com.itlize.project.resourceManagement.Service.ResourceManagementService;
import com.itlize.project.resourceManagement.Service.impl.ResourceManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ResourceManagementController {
    @Autowired
    private ResourceManagementServiceImpl service;

    @GetMapping("/user")
    public void insertUser(){

        User user = new User();
        user.setUser("John");
        user.setPassword("*2p3u4h5");
        user.setRole("Manager");
        service.save(user);

        System.out.println("User is created!!");
    }

    @GetMapping("/project/{id}")
    public void getProject(){
        System.out.println("hi");
    }
}
