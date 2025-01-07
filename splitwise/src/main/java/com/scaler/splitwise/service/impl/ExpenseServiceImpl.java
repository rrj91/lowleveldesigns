package com.scaler.splitwise.service.impl;

import com.scaler.splitwise.exceptions.GroupNotFoundException;
import com.scaler.splitwise.exceptions.UserNotFoundException;
import com.scaler.splitwise.model.Expense;
import com.scaler.splitwise.model.Group;
import com.scaler.splitwise.model.User;
import com.scaler.splitwise.model.UserExpense;
import com.scaler.splitwise.repository.ExpenseRepository;
import com.scaler.splitwise.repository.GroupRepository;
import com.scaler.splitwise.repository.UserExpenseRepository;
import com.scaler.splitwise.repository.UserRepository;
import com.scaler.splitwise.service.ExpenseService;
import com.scaler.splitwise.service.Transaction;
import com.scaler.splitwise.strategy.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private UserRepository userRepository;
    private UserExpenseRepository userExpenseRepository;
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;

    private SettleUpStrategy settleUpStrategy;

    @Autowired
    public ExpenseServiceImpl(UserRepository userRepository, UserExpenseRepository userExpenseRepository, GroupRepository groupRepository, ExpenseRepository expenseRepository,
                              @Qualifier("twoSetsSettleUpStrategyImpl")
                              SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.userExpenseRepository = userExpenseRepository;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    @Override
    public List<Transaction> settleUpUser(Long userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User with id: "+userId+" not found!");
        }
        List<UserExpense> userExpenses = userExpenseRepository.findAllByUser(userOptional.get());
        List<Expense> expensesInvolvingUser = new ArrayList<>();
        for (UserExpense userExpense:userExpenses){
            expensesInvolvingUser.add(userExpense.getExpense());
        }
        List<Transaction> transactions = settleUpStrategy.settle(expensesInvolvingUser);
        List<Transaction> filteredTransactions = new ArrayList<>();
        for(Transaction transaction:transactions){
            if(transaction.getFromUser().equals(userOptional.get()) ||  transaction.getToUser().equals(userOptional.get())){
                filteredTransactions.add(transaction);
            }
        }

        return filteredTransactions;
    }

    @Override
    public List<Transaction> settleUpGroup(Long groupId) throws UserNotFoundException, GroupNotFoundException {
        Optional<Group> group = groupRepository.findById(groupId);
        if(group.isEmpty()){
            throw new GroupNotFoundException("Group with Id: "+groupId+" not found!");
        }
        List<Expense> expenses = expenseRepository.findAllByGroup(group.get());
        List<Transaction> transactions = settleUpStrategy.settle(expenses);

        return transactions;
    }
}
