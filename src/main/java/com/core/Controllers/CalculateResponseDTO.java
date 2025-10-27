package com.core.Controllers;

import java.util.List;

import com.core.Domain.Calculator.ValueObjects.InvestmentMonth;

public class CalculateResponseDTO{
    private final List<InvestmentMonth> report;

    protected CalculateResponseDTO(List<InvestmentMonth> report){
        this.report = report;
    }

    public static CalculateResponseDTO create(List<InvestmentMonth> report){
        return new CalculateResponseDTO(report);
    }

    public List<InvestmentMonth> getReport(){
        return this.report;
    }
}
