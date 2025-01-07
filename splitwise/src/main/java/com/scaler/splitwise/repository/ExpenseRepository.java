package com.scaler.splitwise.repository;

import com.scaler.splitwise.model.Expense;
import com.scaler.splitwise.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findAllByGroup(Group group);
}
