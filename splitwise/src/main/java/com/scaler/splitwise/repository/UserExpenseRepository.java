package com.scaler.splitwise.repository;

import com.scaler.splitwise.model.Expense;
import com.scaler.splitwise.model.User;
import com.scaler.splitwise.model.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserExpenseRepository extends JpaRepository<UserExpense,Long> {
    List<UserExpense> findAllByUser(User user);
    List<UserExpense> findAllByExpenseIn(List<Expense> expenses);
}
