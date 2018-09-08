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
		
		for(int Y=0; Y<puzzle.length; Y++) {
			for(int X=0; X<puzzle[Y].length; X++) {
				
				int room = puzzle[Y][X];
				
				if(
					   room != -1
					&& room != 0
				  ) {
					if(Y + 1 < puzzle.length
						&& room != puzzle[Y+1][X]
						&& puzzle[Y+1][X] != -1
						&& puzzle[Y+1][X] != 0
					   ) {
						assertEquals(puzzle[Y+1][X], puzzle[Y][X]);
					}
					
					if(X + 1 < puzzle[Y].length
						&& room != puzzle[Y][X + 1]
						&& puzzle[Y][X+1] != -1
						&& puzzle[Y][X+1] != 0
					   ) {
						assertEquals(puzzle[Y][X], puzzle[Y][X+1]);
					}
					
					
					
				}
				
			}
		}
		
	}
	
}
