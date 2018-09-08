package com.ahea.calculator;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorServiceTest {

    private CalculatorService calculatorService = new CalculatorService();

    @Test
    public void calculate() {
    }

    @Test
    public void parse() throws IOException {
        String data = "[[1,0,0,0,0],[0,0,2,0,0]]";
        int[][] parse = this.calculatorService.parse(data);

        assertThat(parse[0][0]).isEqualTo(1);
        assertThat(parse[1][2]).isEqualTo(2);
    }

    @Test
    public void getSource() throws IOException {
        int[][] source = this.calculatorService.getSource(2);
        System.out.println(source);
    }

    @Test
    public void putSource() throws JsonProcessingException, InterruptedException {
        Map markResult = this.calculatorService.putSource(7, 2, 5, "[[0,0,0,1],[0,2,0,0]]");
        System.out.println(markResult);
    }

    @Test
    public void isFinish_true() {
        CalculatorService.ongoingSource = new int[][]{{1, 2}, {2, 2}};
        assertThat(this.calculatorService.isFinish()).isTrue();
    }

    @Test
    public void isFinish_false() {
        CalculatorService.ongoingSource = new int[][]{{0,0}, {0,0}};
        assertThat(this.calculatorService.isFinish()).isFalse();
    }
}