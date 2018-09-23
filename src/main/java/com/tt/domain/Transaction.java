package com.tt.domain;

import com.tt.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {

    private TransactionType operation;
    private BigDecimal amount;
    private LocalDate date;

    public Transaction(TransactionType operation, BigDecimal amount, LocalDate date) {
        this.operation = operation;
        this.amount = amount;
        this.date = date;
    }

    public TransactionType getOperation() {
        return operation;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal printAmount() {
        return TransactionType.DEPOSIT == operation ? amount : amount.negate();
    }




}
