package com.ahea.calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @Test
    public void calculate() {
    }

    @Test
    public void parse() {
        String data = "[[1,0,0,0,0],[0,0,2,0,0]]";
        int[][] parse = calculatorService.parse(data);

        assertThat(parse[0][0]).isEqualTo(1);
        assertThat(parse[1][2]).isEqualTo(2);
    }
}