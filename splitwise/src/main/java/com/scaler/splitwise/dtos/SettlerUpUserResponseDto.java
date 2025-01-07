package com.scaler.splitwise.dtos;

import com.scaler.splitwise.service.Transaction;

import java.util.List;

public class SettlerUpUserResponseDto {
    private List<Transaction> transactions;
    private String message;
    private String status;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
