package com.core.Presenters;

import java.text.DecimalFormat;
import java.util.List;

import com.core.Domain.Calculator.ValueObjects.InvestmentMonth;

public class ConsoleInvestmentPresenter {

    private static DecimalFormat df = new DecimalFormat("#,##0.00");

    public static void show(List<InvestmentMonth> report){
        for(InvestmentMonth month : report){
            System.out.println(
                "Mês " + month.getMonth() +
                " | Saldo: " + df.format(month.getInitialBalance()) +
                " | Aporte: " + df.format(month.getMonthlyDeposit()) +
                " | Juros: " + df.format(month.getInterestEarned()) +
                " | Final: " + df.format(month.getFinalBalance())
            );
        }
    }
}