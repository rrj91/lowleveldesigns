package com.scaler.splitwise.command;

public interface Command {


    boolean matches(String input);
    void execute(String input);
}
