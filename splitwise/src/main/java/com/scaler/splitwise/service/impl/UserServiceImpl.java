package com.scaler.splitwise.service.impl;

import com.scaler.splitwise.exceptions.UserAlreadyExistsException;
import com.scaler.splitwise.model.User;
import com.scaler.splitwise.model.UserType;
import com.scaler.splitwise.repository.UserRepository;
import com.scaler.splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String userName, String phoneNumber, String password) throws Exception {
        Optional<User> userOptional = userRepository.findByPhone(phoneNumber);
        if (userOptional.isPresent()) {
            System.out.println(userOptional.get().getName());
            if (userOptional.get().getUserType().equals(UserType.ACTIVE)) {
                throw new UserAlreadyExistsException("A user with same phone already exists");
            } else {
                User user = userOptional.get();
                user.setName(userName);
                user.setPassword(password);
                user.setUserType(UserType.ACTIVE);
                return userRepository.save(user);
            }
        }
        User user = new User();
        user.setPhone(phoneNumber);
        user.setName(userName);
        user.setPassword(password);
        user.setUserType(UserType.ACTIVE);

        return userRepository.save(user);
    }

}
