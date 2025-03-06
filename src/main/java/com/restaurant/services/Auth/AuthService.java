package com.restaurant.services.Auth;

import com.restaurant.dtos.SignupRequest;
import com.restaurant.dtos.UserDto;
import com.restaurant.entities.User;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);

}
