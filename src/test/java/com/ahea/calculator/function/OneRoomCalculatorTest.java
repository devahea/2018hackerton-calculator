package com.ahea.calculator.function;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OneRoomCalculatorTest {

    @Test
    public void calculate() {
        OneRoomCalculator oneRoomCalculator = new OneRoomCalculator();

        int [][] input = {{0,1,0,0,0}};
        int[][] calculate = oneRoomCalculator.calculate(input);

        int[][] output = {{-1, 1, -1, 0, 0}};
        assertThat(calculate).isEqualTo(output);
    }

    @Test
    public void calculate_2() {
        OneRoomCalculator oneRoomCalculator = new OneRoomCalculator();

        int [][] input = {{0,0,0,0,0},{0,0,1,0,0},{0,0,0,0,0}};
        int[][] calculate = oneRoomCalculator.calculate(input);

        int[][] output = {{0,0,-1,0,0},{0,-1,1,-1,0},{0,0,-1,0,0}};
        assertThat(calculate).isEqualTo(output);
    }
}