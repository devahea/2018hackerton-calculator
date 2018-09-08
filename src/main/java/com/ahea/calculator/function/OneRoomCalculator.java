package com.ahea.calculator.function;

import com.ahea.calculator.CalculatorService;

public class OneRoomCalculator implements Runnable {
    @Override
    public void run() {
        CalculatorService.ongoingSource = calculate(CalculatorService.ongoingSource);
    }

    int[][] calculate(int[][] input) {

        for (int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[i].length; j++){
                if(input[i][j] == 1) {
                    try {
                        input[i - 1][j] = -1;
                    }catch (ArrayIndexOutOfBoundsException e) {}
                    try {
                        input[i + 1][j] = -1;
                    }catch (ArrayIndexOutOfBoundsException e) {}
                    try {
                        input[i][j + 1] = -1;
                    }catch (ArrayIndexOutOfBoundsException e) {}
                    try {
                        input[i][j - 1] = -1;
                    }catch (ArrayIndexOutOfBoundsException e) {}
                }
            }
        }
        return input;
    }
}
