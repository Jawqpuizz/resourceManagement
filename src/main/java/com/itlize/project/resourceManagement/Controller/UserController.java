package com.itlize.project.resourceManagement.Controller;

import com.itlize.project.resourceManagement.Entity.User;
import com.itlize.project.resourceManagement.Service.impl.UserServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/logIn")
    public ResponseEntity<?>  authenticateUser(@RequestBody User user){
        if(userService.authenticateUser(user)){
            return ResponseEntity.ok("You are logged in");
        }
        //todo send error to users on clients side
            return ResponseEntity.ok("Invalid user or password, Please try again!!");

    }
    @GetMapping("/allUser")
    public List<User> showAll(){
        return userService.findAll();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody User user){
        User newUser = userService.findOneById(id);
        newUser.setUser(user.getUser());
        userService.save(newUser);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.ok("User has been deleted!!");


    }
}
