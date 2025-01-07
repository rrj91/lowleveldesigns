package com.scaler.splitwise.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "splitwise_group")
public class Group extends BaseModel {
    private String name;
    private String description;
    @ManyToMany
    private List<User> users;
    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;
    private double totalAmountSpend;
    @Enumerated(EnumType.ORDINAL)
    private Currency defaultCurrency;
    @ManyToOne
    private User createdBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public double getTotalAmountSpend() {
        return totalAmountSpend;
    }

    public void setTotalAmountSpend(double totalAmountSpend) {
        this.totalAmountSpend = totalAmountSpend;
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }
}
