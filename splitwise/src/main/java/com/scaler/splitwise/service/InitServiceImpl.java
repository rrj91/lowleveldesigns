package com.scaler.splitwise.service;

import com.scaler.splitwise.model.Currency;
import com.scaler.splitwise.model.Expense;
import com.scaler.splitwise.model.Group;
import com.scaler.splitwise.model.User;
import com.scaler.splitwise.repository.ExpenseRepository;
import com.scaler.splitwise.repository.GroupRepository;
import com.scaler.splitwise.repository.UserExpenseRepository;
import com.scaler.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class InitServiceImpl implements InitService{

    private UserRepository userRepository;
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;
    private UserExpenseRepository userExpenseRepository;

    @Autowired
    public InitServiceImpl(UserRepository userRepository, GroupRepository groupRepository, ExpenseRepository expenseRepository, UserExpenseRepository userExpenseRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.userExpenseRepository = userExpenseRepository;
    }

    @Override
    public void initialize() {
        User omkar = User.builder()
                .email("omkar@gmail.com")
                .phone("987655444")
                .name("Onkar")
                .build();
        User deepan = User.builder()
                .email("deepan@gmail.com")
                .phone("987655424")
                .name("Deepan")
                .build();
        User bhakti = User.builder()
                .email("bhakti@gmail.com")
                .phone("987255444")
                .name("Bhakti")
                .build();
        List<User> users = userRepository.saveAll(Arrays.asList(omkar,deepan,bhakti));
        Group group = new Group();
        group.setDescription("Trip to manali");
        group.setDefaultCurrency(Currency.INR);
        group.setUsers(users);
        groupRepository.save(group);
    }
}
