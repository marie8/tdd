package com.tt.domain;

import com.tt.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {
    private BigDecimal balance;
    private Statement statement;

    public Account() {
        balance = BigDecimal.ZERO;
        this.statement = new Statement();
    }

    /**
     * this constructor is used for tests
     *
     * @param balance
     */
    public Account(BigDecimal balance) {
        this.balance = balance;
        this.statement = new Statement();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * save money in account
     *
     * @param amount money to save
     */
    public void deposit(BigDecimal amount, LocalDate date) {
        balance = balance.add(amount);
        this.statement.addTransaction(new Transaction(TransactionType.DEPOSIT, amount, date), balance);
    }

    /**
     * retrieve money from account
     *
     * @param amount money to retrieve
     */
    public void withdraw(BigDecimal amount, LocalDate date) {
        balance = balance.subtract(amount);
        statement.addTransaction(new Transaction(TransactionType.WITHDRAWAL, amount, date), balance);
    }

    public String getHistory() {
        return statement.printOperations();
    }
}
