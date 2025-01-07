package com.scaler.splitwise.service;

import com.scaler.splitwise.model.User;

public interface UserService {
    User registerUser(String userName, String phoneNumber, String passwoord) throws Exception;
}
