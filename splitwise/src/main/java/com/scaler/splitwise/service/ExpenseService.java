package com.scaler.splitwise.service;

import com.scaler.splitwise.exceptions.GroupNotFoundException;
import com.scaler.splitwise.exceptions.UserNotFoundException;

import java.util.List;

public interface ExpenseService {
    List<Transaction> settleUpUser(Long userId) throws UserNotFoundException;
    List<Transaction> settleUpGroup(Long groupId) throws UserNotFoundException, GroupNotFoundException;
}
