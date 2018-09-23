package com.tt.model;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;

    public Account(){
        balance = BigDecimal.ZERO;
    }

    public Account(BigDecimal balance){
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * save money in account
     * @param amount mony to save
     */
    public void deposit(BigDecimal amount){
       balance = balance.add(amount);
    }

    /**
     * retrieve money from account
     * @param amount mony to retrieve
     */
    public void withdraw(BigDecimal amount){
        balance = balance.subtract(amount);
    }



}
