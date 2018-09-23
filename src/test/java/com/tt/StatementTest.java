package com.tt;

import com.tt.Utils.PrintUtilities;
import com.tt.domain.Statement;
import com.tt.domain.Transaction;
import com.tt.enums.TransactionType;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class StatementTest {

    private Statement statement;
    private LocalDate date;

    @Before
    public void setUp() {
        statement = new Statement();
        date = LocalDate.of(2018, 9, 23);
    }

    @Test
    public void addTransactions() {

        // When
        statement.addTransaction(new Transaction(TransactionType.DEPOSIT, new BigDecimal("60.00"), date), new BigDecimal("100.00"));
        statement.addTransaction(new Transaction(TransactionType.WITHDRAWAL, new BigDecimal("50.20"),date), new BigDecimal("49.80"));

        // Then
        assertEquals(2, statement.getStatementLineList().size());
        assertEquals(statement.printOperations(), getOperations());
    }

    private String getOperations() {
        return PrintUtilities.HEADER + PrintUtilities.lineSeparator()
                + "2018-09-23 || DEPOSIT || 60.00 || 100.00" + PrintUtilities.lineSeparator()
                + "2018-09-23 || WITHDRAWAL || -50.20 || 49.80" + PrintUtilities.lineSeparator();
    }

}
