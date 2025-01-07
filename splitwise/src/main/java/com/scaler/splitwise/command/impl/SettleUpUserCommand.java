package com.scaler.splitwise.command.impl;

import com.scaler.splitwise.command.Command;
import org.springframework.stereotype.Component;

@Component
public class SettleUpUserCommand implements Command {
    @Override
    public boolean matches(String input) {
        return false;
    }

    @Override
    public void execute(String input) {

    }
}
