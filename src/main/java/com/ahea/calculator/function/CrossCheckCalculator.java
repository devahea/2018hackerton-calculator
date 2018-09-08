package com.ahea.calculator.function;

import com.ahea.calculator.CalculatorService;

/*
대각선에 숫자가 있으면 처리 (5번)
 */
public class CrossCheckCalculator implements Runnable {

    private static final int ROOM_TYPE = -1;
    private static final int POOL_TYPE = -2;

    @Override
    public void run() {

        //ongoingSource를 통해서 정답을 도출한후 다시 변경해준다.
        CalculatorService.ongoingSource = calculate();
    }

    private int[][] calculate() {

        int[][] myMap = CalculatorService.ongoingSource;
        int width = myMap[0].length;
        int height = myMap.length;

        for(int i = 0 ; i < myMap.length; i++) {
            for(int j = 0 ; j < myMap[0].length; j++) {
                //대각선 오른쪽 아래 체크
//                indexCheck
                if(!(i+1 == height) && !(j + 1 == width)){
                    if(myMap[i][j] > 0 && myMap[i+1][j+1] > 0) {
                        myMap[i+1][j] = POOL_TYPE;
                        myMap[i][j+1] = POOL_TYPE;
                    }
                }

                //대각선 왼쪽 아래 체크
                if(!(i-11 == 0) && !(j-1 == width)){
                    if(myMap[i][j] > 0 && myMap[i+1][j-1] > 0) {
                        myMap[i][j-1] = POOL_TYPE;
                        myMap[i+1][j] = POOL_TYPE;
                    }
                }
            }
        }


        //문제푸는 로직을 수행후 변경된 값을 리턴한다.
        return myMap;
    }
}
