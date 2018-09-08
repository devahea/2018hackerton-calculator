package com.ahea.calculator.function;

import com.ahea.calculator.CalculatorService;

public class EverywhereBlockedCalculator implements Runnable {
	 	
		private static final int ROOM_TYPE = -1;
	    private static final int POOL_TYPE = -2;

	    @Override
	    public void run() {
	        //ongoingSource를 통해서 정답을 도출한후 다시 변경해준다.
	        CalculatorService.ongoingSource = calculate();
	    }

	    private int[][] calculate() {

	        int[][] puzzle = CalculatorService.ongoingSource;

			int width = puzzle[0].length;
	        int height = puzzle.length;

	        
	        for (int i = 0; i < height - 2; i++) {
	        	for (int j = 0; j < width - 2; j++) {
					
					if(puzzle[i][j] == POOL_TYPE 
					 && puzzle[i][j+2] == POOL_TYPE) {
						puzzle[i][j+1] = ROOM_TYPE;
					}
					
					if(puzzle[i][j] == POOL_TYPE 
					&& puzzle[i+2][j] == POOL_TYPE) {
						puzzle[i+1][j] = ROOM_TYPE;
					}
					
					
					if(puzzle[i][j] == ROOM_TYPE 
							&& puzzle[i][j+2] == ROOM_TYPE) {
						puzzle[i][j+1] = POOL_TYPE;
					}
					
					if(puzzle[i][j] == ROOM_TYPE 
							&& puzzle[i+2][j] == ROOM_TYPE) {
						puzzle[i+1][j] = POOL_TYPE;
					}
					
				}
			}
	        return puzzle;
	    }
}
