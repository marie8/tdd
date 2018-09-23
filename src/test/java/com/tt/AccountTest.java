package com.tt;

import com.tt.Utils.PrintUtilities;
import com.tt.domain.Account;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    private Account account;
    private LocalDate date;

    @Before
    public void setUp() {
        account = new Account();
        date = LocalDate.of(2018, 9, 23);
    }

    /**
     * make a deposit in a new account
     */
    @Test
    public void depositAccount() {
        // When
        account.deposit(new BigDecimal("500.30"), date);

        // Then
        assertEquals(account.getBalance(), new BigDecimal("500.30"));
    }

    /**
     * make a deposit in an existing account
     */
    @Test
    public void depositToExistingAccount() {
        //Given
        Account existingAccount = new Account(new BigDecimal("100.10"));

        // When
        existingAccount.deposit(new BigDecimal("500.30"), date);

        // Then
        assertEquals(existingAccount.getBalance(), new BigDecimal("600.40"));
    }

    /**
     * make a withdrawal from an account
     */
    @Test
    public void withrawAccount() {
        // When
        account.withdraw(new BigDecimal("200.50"), date);

        // Then
        assertEquals(account.getBalance(), new BigDecimal("200.50").negate());
    }

    /**
     * make a withdraw from an existing account
     */
    @Test
    public void withdrawFromExistingAccount() {
        //Given
        Account existingAccount = new Account(new BigDecimal("100.10"));

        // When
        existingAccount.withdraw(new BigDecimal("58.30"), date);

        // Then
        assertEquals(existingAccount.getBalance(), new BigDecimal("41.80"));
    }

    /**
     * check operations
     */
    @Test
    public void checkOperations() {
        // When
        account.deposit(new BigDecimal("150.20"), date);
        account.withdraw(new BigDecimal("20.30"), date);

        // Then
        assertEquals(account.getBalance(), new BigDecimal("129.90"));
        assertEquals(account.getHistory(), getHistory());
    }

    private String getHistory() {
        return PrintUtilities.HEADER + PrintUtilities.lineSeparator()
                + "2018-09-23 || DEPOSIT || 150.20 || 150.20" + PrintUtilities.lineSeparator()
                + "2018-09-23 || WITHDRAWAL || -20.30 || 129.90" + PrintUtilities.lineSeparator();
    }
}
