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
@RequestMapping("/api/user")
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
        User newUser = userService.creatUser(user);
        String message = newUser.getId()+" : "+ newUser.getUser()+" is created !!";
        return ResponseEntity.ok(message);
    }

    @PostMapping("/logIn")
    public ResponseEntity<?>  authenticateUser(@RequestBody User user) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUser(),user.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(user.getUser());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    // admin only
    @GetMapping("/allUser")
    public List<User> showAll(){
        return userService.findAll();
    }

    @PutMapping("/update/")
    public ResponseEntity<?> updateUser( @RequestBody User user){
        // if not found
        User newUser = userService.findOneById(user.getId());

        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.ok("User has been deleted!!");


    }

}
