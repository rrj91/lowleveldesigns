package com.scaler.splitwise.strategy;

import com.scaler.splitwise.model.Expense;
import com.scaler.splitwise.model.User;
import com.scaler.splitwise.model.UserExpense;
import com.scaler.splitwise.model.UserExpenseType;
import com.scaler.splitwise.repository.UserExpenseRepository;
import com.scaler.splitwise.service.Transaction;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.lang.Math.abs;

@Component
public class TwoSetsSettleUpStrategyImpl implements SettleUpStrategy{
    private UserExpenseRepository userExpenseRepository;

    @Autowired
    public TwoSetsSettleUpStrategyImpl(UserExpenseRepository userExpenseRepository) {
        this.userExpenseRepository = userExpenseRepository;
    }

    @Override
    public List<Transaction> settle(List<Expense> expenses) {
        List<UserExpense> allUserExpenses = userExpenseRepository.findAllByExpenseIn(expenses);
        HashMap<User,Double> moneyPaidExtra = new HashMap<>();
        for(UserExpense userExpense: allUserExpenses){
            User user = userExpense.getUser();
            double amount = 0.0;
            if(moneyPaidExtra.containsKey(user)){
                amount = moneyPaidExtra.get(user);
            }
            if(userExpense.getUserExpenseType().equals(UserExpenseType.PAID)){
                amount += userExpense.getAmount();
            }else{
                amount -= userExpense.getAmount();
            }
            moneyPaidExtra.put(user,amount);
        }
        Set<Pair<User,Double>> extraPaid = new HashSet<>();
        TreeSet<Pair<User,Double>> lessPaid = new TreeSet<>();
        for(Map.Entry<User,Double> entry: moneyPaidExtra.entrySet()){
            if(entry.getValue() < 0){
                lessPaid.add(new Pair<>(entry.getKey(),entry.getValue()));
            }else{
                extraPaid.add(new Pair<>(entry.getKey(),entry.getValue()));
            }
        }
        List<Transaction> transactions = new ArrayList<>();
        while(!lessPaid.isEmpty()){
            Pair<User,Double> lessPaidPair = lessPaid.pollFirst();
            Pair<User,Double> extraPaidPair = lessPaid.pollFirst();
            Transaction transaction = new Transaction();
            transaction.setFromUser(lessPaidPair.a);
            transaction.setToUser(extraPaidPair.a);
            if(abs(lessPaidPair.b) < extraPaidPair.b){
                transaction.setAmount(abs(lessPaidPair.b));
                if(extraPaidPair.b-abs(lessPaidPair.b) != 0.0) {
                    extraPaid.add(new Pair<>(extraPaidPair.a, extraPaidPair.b - abs(lessPaidPair.b)));
                }
            }else{
                transaction.setAmount(extraPaidPair.b);
                if(lessPaidPair.b+extraPaidPair.b != 0.0) {
                    lessPaid.add(new Pair<>(extraPaidPair.a, lessPaidPair.b + extraPaidPair.b));
                }
            }
            transactions.add(transaction);
        }
        return transactions;
    }
}
