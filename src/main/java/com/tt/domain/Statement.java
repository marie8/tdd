package com.tt.domain;

import com.tt.Utils.PrintUtilities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Statement {

    private List<StatementLine> statementLineList = new ArrayList<>();

    public List<StatementLine> getStatementLineList() {
        return statementLineList;
    }

    public void addTransaction(Transaction transaction, BigDecimal balance) {
        statementLineList.add(new StatementLine(transaction, balance));
    }

    /**
     * get operations history of the client
     *
     * @return operations History
     */
    public String printOperations() {
        StringBuilder operationsHistory = new StringBuilder();
        operationsHistory.append(PrintUtilities.HEADER);
        operationsHistory.append(PrintUtilities.lineSeparator());
        for (StatementLine statementLine : this.statementLineList) {
            operationsHistory.append(statementLine.getTransaction().getDate()).append(PrintUtilities.SEPARATOR);
            operationsHistory.append(statementLine.getTransaction().getOperation()).append(PrintUtilities.SEPARATOR);
            operationsHistory.append(statementLine.getTransaction().printAmount()).append(PrintUtilities.SEPARATOR);
            operationsHistory.append(statementLine.getBalance());
            operationsHistory.append(PrintUtilities.lineSeparator());
        }
        return operationsHistory.toString();
    }
}
