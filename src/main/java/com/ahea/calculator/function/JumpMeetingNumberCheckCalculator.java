package com.ahea.calculator.function;

import com.ahea.calculator.CalculatorService;

/*
6번
숫자가 서로 한칸 떨어져있으면 그 사이는 우물이 된다
 */
public class JumpMeetingNumberCheckCalculator implements Runnable {

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

        for (int i = 0; i < myMap.length - 2; i++) {
            for (int j = 0; j < myMap[0].length - 2; j++) {

                if ( myMap[i][j] == ROOM_TYPE) {


                    if(myMap[i][j+2] == ROOM_TYPE && myMap[i][j+1] != ROOM_TYPE) {
                        myMap[i][j+1] = POOL_TYPE;
                    }

                    if(myMap[i+2][j] == ROOM_TYPE && myMap[i+1][j] != ROOM_TYPE) {
                        myMap[i+1][j] = POOL_TYPE;
                    }
                }

            }
        }


        //문제푸는 로직을 수행후 변경된 값을 리턴한다.
        return myMap;
    }
}