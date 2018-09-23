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

    public void deposit(BigDecimal amount){
       balance = balance.add(amount);
    }

}
