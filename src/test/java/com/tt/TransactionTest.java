package com.tt;


import com.tt.domain.Transaction;
import com.tt.enums.TransactionType;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TransactionTest {

    private BigDecimal amount;
    private LocalDate date;

    @Before
    public void setUp() {
        amount = new BigDecimal("50.30");
        date = LocalDate.now();
    }

    /**
     *test saved transaction when client deposit money to the account
     */
    @Test
    public void depositTransaction() {
        // When
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount, date);

        // Then
        assertEquals(transaction.getAmount(), amount);
        assertEquals(transaction.getDate(), date);
        assertEquals(transaction.getOperation(), TransactionType.DEPOSIT);
    }

    /**
     *test saved transaction when client retrieve money from the account
     */
    @Test
    public void withdrawTransaction() {
        // When
        Transaction transaction = new Transaction( TransactionType.WITHDRAWAL, amount, date);

        // Then
        assertEquals(transaction.getAmount(), amount);
        assertEquals(transaction.getDate(), date);
        assertEquals(transaction.getOperation(), TransactionType.WITHDRAWAL);
    }

}
