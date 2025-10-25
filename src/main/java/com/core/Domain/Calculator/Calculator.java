package com.core.Domain.Calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.core.Domain.Calculator.ValueObjects.InvestmentMonth;
import com.core.Domain.Calculator.ValueObjects.Tax;
import com.core.Domain.Calculator.ValueObjects.Time;
import com.core.Kernel.Entity.BaseEntity;
import com.core.Kernel.ValueObject.TimeTypes;

public class Calculator extends BaseEntity {
    private final BigDecimal initialValue;
    private final BigDecimal monthlyValue;
    private Tax tax;
    private Time time;

    protected Calculator(BigDecimal value, BigDecimal monthlyValue, Tax tax, Time time) {
        this.initialValue = value;
        this.monthlyValue = monthlyValue;
        this.tax = tax;
        this.time = time;
    }

    public static Calculator create(BigDecimal value, BigDecimal monthlyValue, Tax tax, Time time) {
        return new Calculator(value, monthlyValue, tax, time);
    }

    public BigDecimal totalMonthlyValue() {
        BigDecimal months = time.getType() == TimeTypes.YEAR ? time.getValue().multiply(BigDecimal.valueOf(12))
                : time.getValue();
        return this.monthlyValue.multiply(months);
    }

    public BigDecimal totalMoneyInvested() {
        return totalMonthlyValue().add(this.initialValue);
    }

    public BigDecimal calculate() {
        BigDecimal tax = this.tax.getValue();
        BigDecimal time = this.time.getType() == TimeTypes.YEAR ? this.time.getValue().multiply(BigDecimal.valueOf(12))
                : this.time.getValue();
        BigDecimal taxPlus = BigDecimal.ONE.add(tax);

        BigDecimal factor = taxPlus.pow(time.intValueExact());
        BigDecimal totalInitial = this.initialValue.multiply(factor);
        BigDecimal currentMonthly = factor.subtract(BigDecimal.ONE).divide(tax, 10, RoundingMode.HALF_UP);
        BigDecimal totalCurrentMonthly = this.monthlyValue.multiply(currentMonthly);

        return totalInitial.add(totalCurrentMonthly);
    }

    public List<InvestmentMonth> generateReport() {
        List<InvestmentMonth> report = new ArrayList<>();
        BigDecimal tax = this.tax.getValue();
        BigDecimal time = this.time.getType() == TimeTypes.YEAR ? this.time.getValue().multiply(BigDecimal.valueOf(12))
                : this.time.getValue();

        BigDecimal balance = this.initialValue;

        for (int month = 1; month <= time.intValueExact(); month++) {
            BigDecimal juros = balance.multiply(tax).setScale(2, RoundingMode.HALF_UP);
            BigDecimal total = balance.add(juros);

            BigDecimal finalBalance = total.add(this.monthlyValue);

            BigDecimal monthly = month == 1 ? BigDecimal.ZERO : this.monthlyValue;

            report.add(InvestmentMonth.create(month, balance, monthly, juros, total));

            balance = finalBalance;
        }
        return report;
    }
}
