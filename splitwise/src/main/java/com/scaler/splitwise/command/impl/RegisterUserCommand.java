package com.scaler.splitwise.command.impl;

import com.scaler.splitwise.command.Command;
import com.scaler.splitwise.command.CommandKeyWords;
import com.scaler.splitwise.controller.UserController;
import com.scaler.splitwise.dtos.RegisterUserRequestDto;
import com.scaler.splitwise.dtos.RegisterUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static com.scaler.splitwise.command.CommandKeyWords.REGISTER_USER;

@Component
public class RegisterUserCommand implements Command {

    private UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean matches(String input) {
        List<String> inpWords = Arrays.stream(input.split(" ")).toList();
        return inpWords.size() == 4 && inpWords.get(0).equalsIgnoreCase(REGISTER_USER);
    }

    @Override
    public void execute(String input) {
        List<String> inpWords = Arrays.stream(input.split(" ")).toList();

        String password = inpWords.get(1);
        String phoneNumber = inpWords.get(2);
        String userName = inpWords.get(3);
        RegisterUserRequestDto registerUserRequestDto = new RegisterUserRequestDto();
        registerUserRequestDto.setPassword(password);
        registerUserRequestDto.setUsername(userName);
        registerUserRequestDto.setPhoneNumber(phoneNumber);
        RegisterUserResponseDto registerUserResponseDto = this.userController.registerUser(registerUserRequestDto);
        System.out.println("User with id: "+registerUserResponseDto.getUserId()+" created!");
    }
}
