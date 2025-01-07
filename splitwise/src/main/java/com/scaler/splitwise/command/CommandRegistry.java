package com.scaler.splitwise.command;

import com.scaler.splitwise.command.impl.RegisterUserCommand;
import com.scaler.splitwise.command.impl.SettleUpUserCommand;
import com.scaler.splitwise.command.impl.UpdateProfileCommand;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRegistry {
    private List<Command> commands;
    public CommandRegistry(RegisterUserCommand registerUserCommand,UpdateProfileCommand updateProfileCommand,SettleUpUserCommand settleUpUserCommand){
        commands = new ArrayList<>();
        this.commands.add(registerUserCommand);
        this.commands.add(updateProfileCommand);
        this.commands.add(settleUpUserCommand);
    }
    public void execute(String input){
        for (Command command:commands){
            if(command.matches(input)) {
                command.execute(input);
            }
        }
    }
}
