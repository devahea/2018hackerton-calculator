package com.ahea.calculator.function;

import org.junit.Test;

public class EverywhereBlockedCalculatorTest {

	//puzzle	"문제( 아무것도 없는 칸 = -1, 사각형인데 빈칸 = 0, 숫자가 있는 곳 = 해당 숫자)"
	int[][] puzzle = {
			 {1,0,0,0,0}
			,{0,0,2,0,0}
			,{2,0,0,0,0}
			,{0,0,0,0,0}
			,{6,6,0,0,0}
			,{6,0,0,0,0}
		  };
	
    private static final int ROOM_TYPE = -2;	// 방
    private static final int POOL_TYPE = -1;    // 벽
    
	@Test
	public void cal() {
		
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
	}
}
