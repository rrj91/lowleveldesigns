package com.scaler.splitwise.controller;

import com.scaler.splitwise.dtos.SettleUpResponseDto;
import com.scaler.splitwise.dtos.SettleUpUserRequestDto;
import com.scaler.splitwise.dtos.SettlerUpUserResponseDto;
import com.scaler.splitwise.dtos.TransactionDto;
import com.scaler.splitwise.exceptions.UserNotFoundException;
import com.scaler.splitwise.service.ExpenseService;
import com.scaler.splitwise.service.InitService;
import com.scaler.splitwise.service.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SettleUpController {

    @Autowired
    private InitService initService;

    private ExpenseService expenseService;

    @GetMapping("/hello")
    public ResponseEntity<SettleUpResponseDto> helloWorld(){
        initService.initialize();
        TransactionDto transactionDto1 = new TransactionDto();
        transactionDto1.setAmount(100);
        transactionDto1.setToUserName("Sandeep");
        transactionDto1.setToUserName("Rituraj Jain");
        TransactionDto transactionDto2 = new TransactionDto();
        transactionDto2.setAmount(100);
        transactionDto2.setToUserName("Sandeep2");
        transactionDto2.setToUserName("Rituraj Jain2");
        List<TransactionDto> transactionDtos = List.of(transactionDto1,transactionDto2);
        SettleUpResponseDto settleUpResponseDto = new SettleUpResponseDto(transactionDtos);
        return ResponseEntity.ok(settleUpResponseDto);
    }

}
