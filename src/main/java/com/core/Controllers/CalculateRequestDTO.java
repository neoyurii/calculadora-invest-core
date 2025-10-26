package com.core.Controllers;

import java.math.BigDecimal;

import com.core.Domain.Calculator.ValueObjects.Tax;
import com.core.Domain.Calculator.ValueObjects.Time;
import com.core.Kernel.ValueObject.TimeTypes;

public class CalculateRequestDTO {
    private BigDecimal initialValue = new BigDecimal("100");
    private BigDecimal monthlyValue = new BigDecimal("200");
    private Tax tax = Tax.create(new BigDecimal("0.01")).getValue().get();
    private Time time = Time.create(new BigDecimal("6"), TimeTypes.MONTH);

    public BigDecimal getInitialValue() {
        return initialValue;
    }

    public BigDecimal getMonthlyValue() {
        return monthlyValue;
    }

    public Tax getTax() {
        return tax;
    }

    public Time getTime() {
        return time;
    }
}
