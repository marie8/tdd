package com.tt.domain;

import java.math.BigDecimal;

public class StatementLine {

    private Transaction transaction;
    private BigDecimal balance;

    public StatementLine(Transaction transaction, BigDecimal balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
