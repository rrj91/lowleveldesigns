package com.scaler.splitwise.model;

import jakarta.persistence.*;

@Entity(name = "splitwise_expense_user")
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user;
    private double amount;
    @Enumerated(EnumType.ORDINAL)
    private UserExpenseType userExpenseType;
    @ManyToOne
    private Expense expense;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UserExpenseType getUserExpenseType() {
        return userExpenseType;
    }

    public void setUserExpenseType(UserExpenseType userExpenseType) {
        this.userExpenseType = userExpenseType;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }
}
