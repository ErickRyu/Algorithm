package Soncoding._2017_03_02;

import java.util.Arrays;

public class Minesweeper {
	int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	char[][] board;
    public char[][] updateBoard(char[][] board, int[] click) {
        this.board = board;
        int y = click[0];
        int x = click[1];
        
        if(board[y][x] == 'M'){
        	board[y][x] = 'X';
        	return board;
        }
        revealBoard(y, x);
        return this.board;
    }
    public void revealBoard(int y, int x){
    	int nearMines = 0;
    	for(int i = 0; i < 8; i++){
    		int nextY = y + dy[i];
    		int nextX = x + dx[i];
    		if(isInbound(nextY, nextX) && (board[nextY][nextX] == 'M' ||board[nextY][nextX] == 'X')){
    			nearMines++;
    		}
    	}
    	if(nearMines > 0){
    		board[y][x] = (char)(nearMines + '0');
    		return;
    	}
    	
    	board[y][x] = 'B';
    	for(int i = 0; i < 8; i++){
    		int nextY = y + dy[i];
    		int nextX = x + dx[i];
    		if(isInbound(nextY,nextX) && board[nextY][nextX] == 'E'){
    			revealBoard(nextY, nextX);
    		}
    	}
    }
    public boolean isInbound(int y ,int x){
    	return y > -1 && y < board.length && x > -1 && x < board[0].length;
    }
    public static void main(String[] args){
    	String[] boardStr = {"EEEEE","EEMEE","EEEEE","EEEEE"};
    	char[][] board = new char[boardStr.length][boardStr[0].length()];
    	for(int i = 0; i < boardStr.length; i++){
    		board[i] = boardStr[i].toCharArray();
    	}
    	for(char[] b : board){
    		System.out.println(Arrays.toString(b));
    	}
    	System.out.println();
    	int click[] = {3, 0};
    	Minesweeper ms = new Minesweeper();
    	ms.updateBoard(board, click);
    	for(char[] b : board){
    		System.out.println(Arrays.toString(b));
    	}
    }
}
