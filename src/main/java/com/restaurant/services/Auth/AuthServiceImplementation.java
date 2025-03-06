package com.restaurant.services.Auth;

import com.restaurant.dtos.SignupRequest;
import com.restaurant.dtos.UserDto;
import com.restaurant.entities.User;
import com.restaurant.enums.UserRole;
import com.restaurant.repositories.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImplementation implements AuthService{

    private final UserRepo userRepo;


    public AuthServiceImplementation(UserRepo userRepo) {
        this.userRepo = userRepo;

    }

    @Override
    public UserDto createUser(SignupRequest signupRequest) {
        User user =new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setUserRole(UserRole.CUSTOMER);
        User createdUser = userRepo.save(user);
        UserDto createdUserDto = new UserDto();
        createdUserDto.setId(createdUser.getId());
        createdUserDto.setName(createdUser.getName());
        createdUserDto.setEmail(createdUser.getEmail());
        createdUserDto.setUserRole(createdUser.getUserRole());
        return createdUserDto;
    }
}
