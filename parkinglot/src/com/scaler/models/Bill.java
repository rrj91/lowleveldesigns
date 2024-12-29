package com.scaler.models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseEntity{
    private Date exitTime;
    private Ticket ticket;
    private double amount;
    private Operator operator;
    private Gate gate;
    private List<Payment> payments;
    private BillStatus billStatus;
}
