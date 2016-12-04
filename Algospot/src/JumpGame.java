import java.util.Arrays;
import java.util.Scanner;
public class JumpGame {
	static int boardSize;
	static int board[][];
	static int mem[][];
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		while(TC-- > 0){
			boardSize = sc.nextInt();
			board= new int[boardSize][boardSize];
			mem = new int[boardSize][boardSize];
			for(int[] sub : mem)
				Arrays.fill(sub, -1);
			
			for(int i = 0; i < boardSize; i++)
				for(int j =0; j < boardSize; j++)
					board[i][j] = sc.nextInt();
			
			boolean res = findRoute(0,0);
			System.out.println(res? "YES":"NO");
		}
		sc.close();
	}
	public static boolean findRoute(int y, int x){
		if(y == boardSize-1 && x == boardSize-1)
			return true;
		
		if(y >= boardSize || x >= boardSize)
			return false;
		
		boolean isVisited = mem[y][x] != -1;
		if(isVisited)
			return mem[y][x] == 1 ? true:false;
		int myNum = board[y][x];
		boolean rightRes = false;
		boolean downRes = false;

		rightRes = findRoute(y+myNum, x);
		downRes = findRoute(y, x+myNum);
		
		mem[y][x] = (rightRes||downRes)? 1 : 0;
		return rightRes || downRes;
	}
}
