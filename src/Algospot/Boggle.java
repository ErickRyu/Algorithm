package Algospot;

import java.util.Scanner;

public class Boggle {
    static int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    static int yLen, xLen;
    static char[][] board;
//    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        readBoard();
        boolean bool = false;
        String word = "PRETTYQ";
        outer:
        for(int y = 0; y < yLen; y++){
            for(int x = 0; x < xLen; x++){
                bool = hasWord(y, x, word, 0);
                if(bool)
                    break outer;
            }
        }
        if(bool){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    public static void readBoard(){
        yLen = 5;
        xLen = 5;
        String[] tmp = {"URLPM", "XPRET", "GIAET", "XTNZY", "XOQRS"};
        board = new char[yLen][xLen];
        for (int i = 0; i < 5; i++){
            board[i] = tmp[i].toCharArray();
        }
//        sc.close();
    }
    public static boolean hasWord(int y, int x, String word, int toSee){
        if(toSee >= word.length()) return false;
        if(word.charAt(toSee) != board[y][x]) return false;
        if(word.length()-1 == toSee) return true;

        for(int i = 0; i < 8; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(canMove(nextY, nextX)){
                if(hasWord(nextY, nextX, word, toSee+1)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasWord(String word){
        int toSee = 0;
        for(int y = 0; y < yLen; y++){
            for(int x = 0; x < xLen; x++){

                for(int i = 0; i < 8; i++) {

                }
                if(word.length() == toSee) return true;
            }
        }
        return false;
    }
    public static boolean canMove(int y, int x){
        return y < yLen && y >= 0 && x < xLen && x >= 0;
    }
}
