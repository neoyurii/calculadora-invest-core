package com.core.Calculator;

import org.junit.jupiter.api.Test;

import com.core.Domain.Calculator.Calculator;
import com.core.Domain.Calculator.ValueObjects.Tax;
import com.core.Domain.Calculator.ValueObjects.Time;
import com.core.Kernel.Result.Result;
import com.core.Kernel.ValueObject.TimeTypes;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void deveCalcularRendimentoCorretamente() {
        // Arrange (prepara os dados)
        Tax tax = Tax.create(new BigDecimal("0.01")).getValue().get(); // 1% ao mês
        Time time = Time.create(new BigDecimal("6"), TimeTypes.MONTH);
        Calculator calc = Calculator.create(
            new BigDecimal("1000.00"),
            new BigDecimal("200.00"),
            tax,
            time
        );

        // Act (executa)
        BigDecimal resultado = calc.calculate();

        // Assert (verifica)
        assertNotNull(resultado);
        assertTrue(resultado.compareTo(BigDecimal.ZERO) > 0);
        assertEquals(0, resultado.compareTo(new BigDecimal("2291.91")), 
            "O valor final deve bater com o cálculo esperado");
    }

    @Test
    void deveGerarRelatorioMensalCom6Meses() {
        // Arrange
        Tax tax = Tax.create(new BigDecimal("0.01")).getValue().get();
        Time time = Time.create(new BigDecimal("6"), TimeTypes.MONTH);
        Calculator calc = Calculator.create(
            new BigDecimal("1000.00"),
            new BigDecimal("200.00"),
            tax,
            time
        );

        // Act
        var relatorio = calc.generateReport();

        // Assert
        assertEquals(6, relatorio.size(), "Deve ter 6 registros (um por mês)");
        assertTrue(relatorio.get(0).getFinalBalance().compareTo(BigDecimal.ZERO) > 0);
    }
}
