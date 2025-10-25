package com.core.Domain.Calculator.ValueObjects;

import java.math.BigDecimal;

import com.core.Kernel.Result.Result;
import com.core.Kernel.ValueObject.BaseValueObject;
import com.core.Kernel.ValueObject.IValidate;

public class Tax extends BaseValueObject<BigDecimal> implements IValidate<BigDecimal, Tax> {

    protected Tax(BigDecimal tax) {
        super(tax);
    }

    @Override
    public Result<Tax> validate(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            return Result.fail("A taxa não pode ser negativa");
        }
        return Result.sucess(new Tax(value));
    }

    public static Result<Tax> create(BigDecimal value) {
        return new Tax(value).validate(value);
    }
}
