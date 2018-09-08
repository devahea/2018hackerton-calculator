package com.ahea.calculator.function;

import com.ahea.calculator.CalculatorService;

public class ExampleCalculator implements Runnable {
    @Override
    public void run() {
        //ongoingSource를 통해서 정답을 도출한후 다시 변경해준다.
        CalculatorService.ongoingSource = calculate();
    }

    private String calculate() {
        //문제푸는 로직을 수행후 변경된 값을 리턴한다.
        return null;
    }
}
