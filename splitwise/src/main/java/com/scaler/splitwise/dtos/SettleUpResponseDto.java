package com.scaler.splitwise.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class SettleUpResponseDto {
    private List<TransactionDto> transactionList;

    public SettleUpResponseDto(List<TransactionDto> transactionList) {
        this.transactionList = transactionList;
    }

    public List<TransactionDto> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<TransactionDto> transactionList) {
        this.transactionList = transactionList;
    }
}
