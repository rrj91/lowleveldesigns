package com.scaler.splitwise.controller;

import com.scaler.splitwise.dtos.RegisterUserRequestDto;
import com.scaler.splitwise.dtos.RegisterUserResponseDto;
import com.scaler.splitwise.model.User;
import com.scaler.splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto userRequestDto){
        User user = null;
        try {
            user = this.userService.registerUser(userRequestDto.getUsername(),userRequestDto.getPhoneNumber(),userRequestDto.getPassword());
        } catch (Exception e) {
            RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
            registerUserResponseDto.setStatus("FAILURE");
            registerUserResponseDto.setMessage(e.getMessage());
            return registerUserResponseDto;
        }
        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        registerUserResponseDto.setUserId(user.getId());
        registerUserResponseDto.setStatus("SUCCESS");

        return registerUserResponseDto;
    }
}
