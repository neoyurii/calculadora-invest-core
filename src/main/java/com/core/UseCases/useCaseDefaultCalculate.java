package com.core.UseCases;

import java.math.BigDecimal;
import java.util.List;

import com.core.Domain.Calculator.Calculator;
import com.core.Domain.Calculator.ValueObjects.InvestmentMonth;
import com.core.Domain.Calculator.ValueObjects.Tax;
import com.core.Domain.Calculator.ValueObjects.Time;

public class useCaseDefaultCalculate {

    private final List<InvestmentMonth> report;

    protected useCaseDefaultCalculate(List<InvestmentMonth> report) {
        this.report = report;
    }

    public List<InvestmentMonth> getReport(){
        return this.report;
    }

    public static useCaseDefaultCalculate create(BigDecimal balance, BigDecimal monthly, Tax tax, Time time){
        Calculator calc = Calculator.create(balance, monthly, tax, time);
        List<InvestmentMonth> report =  calc.generateReport();
        return new useCaseDefaultCalculate(report);
    }
}
