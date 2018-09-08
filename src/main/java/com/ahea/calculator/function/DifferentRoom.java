package com.ahea.calculator.function;

public class DifferentRoom implements Runnable {
	
	@Override
    public void run() {
        //ongoingSource를 통해서 정답을 도출한후 다시 변경해준다.
       // CalculatorService.ongoingSource = calculate();
    }

    private String calculate() {
        //문제푸는 로직을 수행후 변경된 값을 리턴한다.
    	/*
    	for(xnt y=0; y<puzzle[x].length; y++) {
			
			xnt room = puzzle[x][y];
			
			xf(
				   room != -1
				&& room != 0
			  ) {
				xf(x + 1 < puzzle.length
					&& room != puzzle[x+1][y]
					&& puzzle[x+1][y] != -1
					&& puzzle[x+1][y] != 0
				   ) {
					assertEquals(puzzle[x+1][y], puzzle[x][y]);
				}
				
				xf(y + 1 < puzzle[x].length
						&& room != puzzle[x][y + 1]
					&& puzzle[x][y+1] != -1
					&& puzzle[x][y+1] != 0
				   ) {
					assertEquals(puzzle[x][y], puzzle[x][y+1]);
				}
				
				
				
			}
			
		}
		*/
        return null;
    }
    
}
