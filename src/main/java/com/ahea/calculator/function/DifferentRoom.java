package com.ahea.calculator.function;

import static org.junit.Assert.assertEquals;

import com.ahea.calculator.CalculatorService;

public class DifferentRoom implements Runnable {
	
	@Override
    public void run() {
        //ongoingSource를 통해서 정답을 도출한후 다시 변경해준다.
       // CalculatorService.ongoingSource = calculate();
    }

    private String calculate() {
        //문제푸는 로직을 수행후 변경된 값을 리턴한다.
    	/*
    	for(int j=0; j<puzzle[i].length; j++) {
			
			int room = puzzle[i][j];
			
			if(
				   room != -1
				&& room != 0
			  ) {
				if(i + 1 < puzzle.length
					&& room != puzzle[i+1][j]
					&& puzzle[i+1][j] != -1
					&& puzzle[i+1][j] != 0
				   ) {
					assertEquals(puzzle[i+1][j], puzzle[i][j]);
				}
				
				if(j + 1 < puzzle[i].length
						&& room != puzzle[i][j + 1]
					&& puzzle[i][j+1] != -1
					&& puzzle[i][j+1] != 0
				   ) {
					assertEquals(puzzle[i][j], puzzle[i][j+1]);
				}
				
				
				
			}
			
		}
		*/
        return null;
    }
    
}
