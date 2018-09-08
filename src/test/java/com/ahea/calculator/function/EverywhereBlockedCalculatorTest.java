package com.ahea.calculator.function;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class EverywhereBlockedCalculatorTest {

	OneRoomCalculator oneRoomCalculator = new OneRoomCalculator();
	
	int[][] puzzle = {{0,1,0,0,0}};
	int[][] calculate = oneRoomCalculator.calculate(puzzle);
	int[][] output = {{-1, 1, -1, 0, 0}};
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
        
        assertThat(calculate).isEqualTo(output);
	}
}
