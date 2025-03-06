package com.restaurant.controllers;

import com.restaurant.dtos.SignupRequest;
import com.restaurant.dtos.UserDto;
import com.restaurant.services.Auth.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) {
       UserDto createdUserDto =  authService.createUser(signupRequest);
       if(createdUserDto == null){
           return new ResponseEntity<>("User not created. Come again later", HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
    }
}
