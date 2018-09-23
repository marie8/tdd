package com.tt;

import com.tt.model.Account;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    private Account account;
    private BigDecimal amount;

    @Before
    public void setUp() {
      account = new Account();
    }

    /**
     *  make a deposit in a new account
     */
    @Test
    public void depositAccount() {
        // When
        account.deposit(new BigDecimal("500.30"));

        // Then
        assertEquals(account.getBalance(), new BigDecimal("500.30"));
    }

    /**
     *  make a deposit in an existing account
     */
    @Test
    public void depositToExistingAccount() {
        //Given
        Account existingAccount = new Account(new BigDecimal("100.10"));

        // When
        existingAccount.deposit(new BigDecimal("500.30"));

        // Then
        assertEquals(existingAccount.getBalance(), new BigDecimal("600.40"));
    }

}
