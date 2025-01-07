package com.scaler.splitwise.strategy;

import com.scaler.splitwise.model.Expense;
import com.scaler.splitwise.service.Transaction;

import java.util.List;

public interface SettleUpStrategy {
    List<Transaction> settle(List<Expense> expenses);
}
