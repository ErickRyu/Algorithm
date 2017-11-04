package Algospot;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardCover {
    static int[][] block_dy = {
            {0, 1, 1},
            {0, 0, 1},
            {0, 0, 1},
            {0, 1, 1}
    };
    static int[][] block_dx = {
            {0, 0, 1},
            {0, 1, 1},
            {0, 1, 0},
            {0, -1, 0}
    };
    static int yLen;
    static int xLen;
    static char[][] board;
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(count);

    }

    public int solution(int y, int x, String[] lines) {
        yLen = y;
        xLen = x;
        board = new char[y][x];
        for (int i = 0; i < yLen; i++) {
            board[i] = lines[i].toCharArray();
        }
        countBoardCover(0, 0);
        return count;
    }

    public static void countBoardCover(int y, int x) {
        boolean fullBoard = true;
        //흠.. 왜 여기는 안되는건지 이해가 안가는데??
        // i = 0부터 시작해서 y에 할당해주는거랑 마지막에 변경한놈부터 이렇게 타고 들어가는거랑 무슨 차이가 있길래 이건 답이 안 나오는걸까????
        outer:
        for (; y < yLen; y++) {
            for (; x < xLen; x++) {
                if (board[y][x] == '.') {
                    fullBoard = false;
                    break outer;
                }
            }
        }
//
//
//        outer:
//        for (int i = 0; i < yLen; i++) {
//            for (int j = 0; j < xLen; j++) {
//                if (board[i][j] == '.') {
//                    fullBoard = false;
//                    break outer;
//                }
//            }
//        }

        if (fullBoard){
            count++;
            return;
        }

        for (int blockNum = 0; blockNum < 4; blockNum++) {
            boolean canFill = false;
            for (int i = 0; i < 3; i++) {
                int nextY = y + block_dy[blockNum][i];
                int nextX = x + block_dx[blockNum][i];
                canFill = isReach(nextY, nextX) && board[nextY][nextX] == '.';
                if(!canFill) break;
            }
            if (canFill) {
                for (int i = 0; i < 3; i++) {
                    int nextY = y + block_dy[blockNum][i];
                    int nextX = x + block_dx[blockNum][i];
                    board[nextY][nextX] = '#';
                }
                countBoardCover(y, x);
                for (int i = 0; i < 3; i++) {
                    int nextY = y + block_dy[blockNum][i];
                    int nextX = x + block_dx[blockNum][i];
                    board[nextY][nextX] = '.';
                }
            }
        }
    }

    public static boolean isReach(int y, int x) {
        return y < yLen && y >= 0 && x < xLen && x >= 0;
    }

    @Test
    public void should_zero() {
        String[] lines = {
                "#.....#",
                "#.....#",
                "##...##"
        };
        solution(3, 7, lines);
        assertEquals(0, count);
    }
    @Test
    public void should_two() {
        String[] lines = {
                "#.....#",
                "#.....#",
                "##..###"
        };
        solution(3, 7, lines);
        assertEquals(2, count);
    }
}
