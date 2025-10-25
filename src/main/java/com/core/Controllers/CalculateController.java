package com.core.Controllers;

import java.math.BigDecimal;

import com.core.Domain.Calculator.ValueObjects.Tax;
import com.core.Domain.Calculator.ValueObjects.Time;
import com.core.Kernel.ValueObject.TimeTypes;
import com.core.Presenters.ConsoleInvestmentPresenter;
import com.core.UseCases.useCaseDefaultCalculate;

public class CalculateController {

    public void execute() {
        useCaseDefaultCalculate useCase = useCaseDefaultCalculate.create(
                new BigDecimal("100"),
                new BigDecimal("200"),
                Tax.create(new BigDecimal("0.01")).getValue().get(),
                Time.create(new BigDecimal("6"), TimeTypes.MONTH));

        ConsoleInvestmentPresenter.show(useCase.getReport());
    }

}
