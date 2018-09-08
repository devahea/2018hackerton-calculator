package com.ahea.calculator.function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

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
		
		for(int y=0; y<puzzle.length; y++) {
			for(int x=0; x<puzzle[y].length; x++) {
				
				int roomNumber = puzzle[y][x];
				
				if(
					   roomNumber != -1
					&& roomNumber != 0
				  ) {
					if(y + 1 < puzzle.length
						&& roomNumber != puzzle[y+1][x]
						&& puzzle[y+1][x] != -1
						&& puzzle[y+1][x] != 0
					   ) {
						assertEquals(puzzle[y+1][x], puzzle[y][x]);
					}
					
					if(x + 1 < puzzle[y].length
						&& roomNumber != puzzle[y][x + 1]
						&& puzzle[y][x+1] != -1
						&& puzzle[y][x+1] != 0
					   ) {
						assertEquals(puzzle[y][x], puzzle[y][x+1]);
					}
					
					
					
				}
				
			}
		}
		
	}
	
}
