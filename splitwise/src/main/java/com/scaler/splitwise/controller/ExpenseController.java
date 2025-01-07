package com.scaler.splitwise.controller;

import com.scaler.splitwise.dtos.SettleUpGroupRequestDto;
import com.scaler.splitwise.dtos.SettleUpUserRequestDto;
import com.scaler.splitwise.dtos.SettlerUpGroupResponseDto;
import com.scaler.splitwise.dtos.SettlerUpUserResponseDto;
import com.scaler.splitwise.exceptions.UserNotFoundException;
import com.scaler.splitwise.model.Expense;
import com.scaler.splitwise.service.ExpenseService;
import com.scaler.splitwise.service.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public SettlerUpUserResponseDto settleUpUser(SettleUpUserRequestDto settleUpUserRequestDto){
        List<Transaction> transactions = null;
        try {
            transactions = this.expenseService.settleUpUser(settleUpUserRequestDto.getUserId());
        } catch (UserNotFoundException e) {
            SettlerUpUserResponseDto settleUpUserResponseDto =new SettlerUpUserResponseDto();
            settleUpUserResponseDto.setMessage(e.getMessage());
            settleUpUserResponseDto.setStatus("FAILURE");
            return settleUpUserResponseDto;
        }
        SettlerUpUserResponseDto settleUpUserResponseDto =new SettlerUpUserResponseDto();
        settleUpUserResponseDto.setTransactions(transactions);
        settleUpUserResponseDto.setStatus("SUCCESS");
        return settleUpUserResponseDto;
    }

    public SettlerUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto settleUpGroupRequestDto){
        return null;
    }
}
