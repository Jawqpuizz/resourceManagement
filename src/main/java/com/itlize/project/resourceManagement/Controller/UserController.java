package com.itlize.project.resourceManagement.Controller;

import com.itlize.project.resourceManagement.Entity.AuthenticationResponse;
import com.itlize.project.resourceManagement.Entity.User;
import com.itlize.project.resourceManagement.Service.impl.MyUserDetailService;
import com.itlize.project.resourceManagement.Service.impl.UserServiceImpl;
import com.itlize.project.resourceManagement.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailService userDetailsService;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/logIn")
    public ResponseEntity<?>  authenticateUser(@RequestBody User user) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUser(),user.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            System.out.println("Invalid user");
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(user.getUser());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
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
