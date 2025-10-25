package com.core.Domain.Calculator.ValueObjects;

import java.math.BigDecimal;

public class InvestmentMonth {
    private final int month;
    private final BigDecimal initialBalance;
    private final BigDecimal monthlyDeposit;
    private final BigDecimal interestEarned;
    private final BigDecimal finalBalance;

    protected InvestmentMonth(int month,
            BigDecimal initialBalance,
            BigDecimal monthlyDeposit,
            BigDecimal interestEarned,
            BigDecimal finalBalance) {
        this.month = month;
        this.initialBalance = initialBalance;
        this.monthlyDeposit = monthlyDeposit;
        this.interestEarned = interestEarned;
        this.finalBalance = finalBalance;
    }

    public int getMonth() {
        return month;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public BigDecimal getMonthlyDeposit() {
        return monthlyDeposit;
    }

    public BigDecimal getInterestEarned() {
        return interestEarned;
    }

    public BigDecimal getFinalBalance() {
        return finalBalance;
    }

    public static InvestmentMonth create(int month,
            BigDecimal initialBalance,
            BigDecimal monthlyDeposit,
            BigDecimal interestEarned,
            BigDecimal finalBalance) {
        return new InvestmentMonth(month, initialBalance, monthlyDeposit, interestEarned, finalBalance);
    }
}
