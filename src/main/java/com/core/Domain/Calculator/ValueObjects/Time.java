package com.core.Domain.Calculator.ValueObjects;

import java.math.BigDecimal;

import com.core.Kernel.Result.Result;
import com.core.Kernel.ValueObject.BaseValueObject;
import com.core.Kernel.ValueObject.TimeTypes;

public class Time extends BaseValueObject<BigDecimal> {
    private final TimeTypes type;

    protected Time(BigDecimal time, TimeTypes type) {
        super(time);
        this.type = type;
    }

    public static Result<Time> validate(BigDecimal time, TimeTypes types) {
        if (time.compareTo(BigDecimal.ZERO) < 0) {
            return Result.fail("O valor do tempo não pode ser negativo");
        }
        return Result.sucess(new Time(time, types));
    }

    public Time selectMonth() {
        return new Time(getValue(), TimeTypes.MONTH);
    }

    public Time selectYear() {
        return new Time(getValue(), TimeTypes.YEAR);
    }

    public TimeTypes getType() {
        return type;
    }

    public static Time create(BigDecimal time, TimeTypes types) {
        return validate(time, types).getValue().get();
    }
}
