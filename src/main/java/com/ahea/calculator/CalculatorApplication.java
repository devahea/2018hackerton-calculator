package com.ahea.calculator;

import java.io.IOException;

public class CalculatorApplication {
	public static void main(String[] args) throws IOException, InterruptedException {
		CalculatorService calculatorService = new CalculatorService();
		calculatorService.execute(7, 2, 5);
	}
}
