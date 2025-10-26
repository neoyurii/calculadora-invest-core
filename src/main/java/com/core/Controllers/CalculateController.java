package com.core.Controllers;

import java.math.BigDecimal;

import com.core.Domain.Calculator.ValueObjects.Tax;
import com.core.Domain.Calculator.ValueObjects.Time;
import com.core.Kernel.Controller.BaseController;
import com.core.Kernel.Result.Result;
import com.core.Kernel.ValueObject.TimeTypes;
import com.core.Presenters.ConsoleInvestmentPresenter;
import com.core.UseCases.useCaseDefaultCalculate;

public class CalculateController implements BaseController<CalculateRequest,CalculateResponse> {

    @Override
    public Result<CalculateResponse> execute(CalculateRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

}
