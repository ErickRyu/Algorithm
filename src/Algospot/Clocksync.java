package Algospot;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;
public class Clocksync {

    static int[] clocks;
    static final int INF = Integer.MAX_VALUE;
    static LinkedList<Integer>[] switchs = new LinkedList[10];

    public int solution(int[] inputClock){
        clocks = inputClock;
        initSwitchList();
        int ret = calculateMinPush(0, 0);
        if(ret == INF) return -1;
        return ret;
    }
    public void initClock(){
        for(int clock : clocks){
            clock %= 12;
        }
    }
    public int calculateMinPush(int switchNum, int currentPushNum){
        boolean all12 = true;
        for(int i = 0; i < 16 && all12; i++){
            all12 = clocks[i] == 0;
        }
        if(all12) return currentPushNum;
        if(switchNum > 9) return INF;

        int min = INF;
        for(int pushDownNum = 0; pushDownNum < 4; pushDownNum++){
            pushDown(switchs[switchNum], pushDownNum);
            int ret = calculateMinPush(switchNum + 1, currentPushNum + pushDownNum);
            min = Math.min(min, ret);
            pushDown(switchs[switchNum], -pushDownNum);
        }

        return min;
    }
    public void initSwitchList(){
        switchs[0] = new LinkedList<>(Arrays.asList(0, 1, 2));
        switchs[1] = new LinkedList<>(Arrays.asList(3, 7, 9, 11));
        switchs[2] = new LinkedList<>(Arrays.asList(4, 10, 14, 15));
        switchs[3] = new LinkedList<>(Arrays.asList(0, 4, 5, 6, 7));
        switchs[4] = new LinkedList<>(Arrays.asList(6, 7, 8, 10, 12));
        switchs[5] = new LinkedList<>(Arrays.asList(0, 2, 14, 15));
        switchs[6] = new LinkedList<>(Arrays.asList(3, 14, 15));
        switchs[7] = new LinkedList<>(Arrays.asList(4, 5, 7, 14, 15));
        switchs[8] = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        switchs[9] = new LinkedList<>(Arrays.asList(3, 4, 5, 9, 13));
    }

    public void pushDown(LinkedList<Integer> switchList, int pushDownNum){
        for(int clock : switchList){
            clocks[clock] = modulo(clocks[clock] + (pushDownNum * 3), 12);
        }
    }
    public int modulo(int num, int modulo){
        num %= modulo;
        if(num < 0){
            num += modulo;
        }
        return num;
    }
    @Test
    public void calculateMinPush_test(){
        int[] clocks = {12, 6, 6, 6, 6, 6, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
        int ret = solution(clocks);
        assertEquals(2, ret);

        int[] clocks2 = {12, 9, 3, 12, 6, 6, 9, 3, 12, 9, 12, 9, 12, 12, 6, 6};
        ret = solution(clocks2);
        assertEquals(9, ret);
    }

    @Test
    public void modulo_test(){
        assertEquals(3, modulo(3, 4));
        assertEquals(1, modulo(-3, 4));
    }
    @Test
    public void pushDown_test(){
        clocks = new int[9];

        Arrays.fill(clocks, 0);

        LinkedList<Integer> switchList = new LinkedList<>();
        switchList.add(0);
        switchList.add(4);
        int pushDownNum = 1;
        pushDown(switchList, pushDownNum);
        int[] expect = {
                3, 0, 0,
                0, 3, 0,
                0, 0, 0
        };

        assertArrayEquals(expect, clocks);

        clocks[8] = 9;
        switchList.add(8);
        pushDownNum = 2;
        pushDown(switchList, pushDownNum);
        int[] expect2 = {
                9, 0, 0,
                0, 9, 0,
                0, 0, 3
        };
        assertArrayEquals(expect2, clocks);
    }
    @Test
    public void pushUp_test(){
        clocks = new int[9];

        Arrays.fill(clocks, 0);
        LinkedList<Integer> switchList = new LinkedList<>();
        switchList.add(0);
        switchList.add(4);
        int pushDownNum = -1;
        pushDown(switchList, pushDownNum);
        int[] expect = {
                9, 0, 0,
                0, 9, 0,
                0, 0, 0
        };
        assertArrayEquals(expect, clocks);
    }
}
