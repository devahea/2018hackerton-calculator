package com.ahea.calculator.function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class DifferentRoomTest {
	
	//puzzle	"문제( 아무것도 없는 칸 = -1, 사각형인데 빈칸 = 0, 숫자가 있는 곳 = 해당 숫자)"	

	int[][] puzzle = {
						 {1,0,0,0,0}
						,{0,0,2,0,0}
						,{2,0,0,0,0}
						,{0,0,0,0,0}
						,{6,6,0,0,0}
						,{6,0,0,0,0}
					  };
	 
	@Test
	public void cal() {
		
		for(int i=0; i<puzzle.length; i++) {
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
		}
		
	}
	
}
