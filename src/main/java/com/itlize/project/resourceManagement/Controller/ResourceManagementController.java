package com.itlize.project.resourceManagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResourceManagementController {
    @RequestMapping("/home")
    public void home(){
        System.out.println("hi");
    }
}
