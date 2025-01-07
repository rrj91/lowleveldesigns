package com.scaler.splitwise.command.impl;

import com.scaler.splitwise.command.Command;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static com.scaler.splitwise.command.CommandKeyWords.REGISTER_USER;
import static com.scaler.splitwise.command.CommandKeyWords.UPDATE_PROFILE;
@Component
public class UpdateProfileCommand implements Command {
    @Override
    public boolean matches(String input) {
        List<String> inpWords = Arrays.stream(input.split(" ")).toList();
        return inpWords.size() == 4 && inpWords.get(0).equalsIgnoreCase(UPDATE_PROFILE);
    }

    @Override
    public void execute(String input) {

    }
}
