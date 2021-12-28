package com.revature.web;


import com.revature.entity.User;
import com.revature.repository.UserRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;


@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
   // @Autowired
   // private UserService userService;



    @PostMapping(value="/api/edit-profile",
                    consumes ="application/json")
    public ResponseEntity<?> post(@RequestBody User user){
       //Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        //UserDetails userDetails=(UserDetails) authentication.getPrincipal();
       //user.setUsername(userDetails.getUsername());//inserts user
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping(value="/api/edit-profile/{userId}",
            consumes ="application/json")
    public ResponseEntity<?> put(@PathVariable ObjectId userId, @RequestBody User user){
        user.setId(userId);
        user=userRepository.save(user); //updates user
        return ResponseEntity.ok(user);
    }
    @DeleteMapping(value="/api/edit-profile/{userId}")
    public ResponseEntity<?>delete(@PathVariable ObjectId userId){
        userRepository.deleteById(userId);
        return ResponseEntity.ok().build();
    }

}
