package com.core.UseCases;

import java.util.List;

import com.core.Controllers.CalculateRequestDTO;
import com.core.Controllers.CalculateResponse;
import com.core.Controllers.CalculateResponseDTO;
import com.core.Domain.Calculator.Calculator;
import com.core.Domain.Calculator.ValueObjects.InvestmentMonth;

public class useCaseDefaultCalculate {

    public static CalculateResponse create(CalculateRequestDTO req){
        Calculator calc = Calculator.create(req.getInitialValue(), req.getMonthlyValue(), req.getTax(), req.getTime());
        List<InvestmentMonth> report =  calc.generateReport();
        CalculateResponseDTO data = CalculateResponseDTO.create(report);
        if(data == null || data.getReport().isEmpty()){
            return CalculateResponse.create(data, "A lista está vazia", false, null);
        }
        return CalculateResponse.create(data, "sucesso", true, null);
    }
}
