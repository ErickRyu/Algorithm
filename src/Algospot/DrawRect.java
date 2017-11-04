package Algospot;

import java.util.Scanner;

public class DrawRect {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		while(TC-- > 0){
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int i = 0; i < 2;i ++){
				x ^= sc.nextInt();
				y ^= sc.nextInt();
			}
			System.out.println(x + " " + y);
		}
		sc.close();
	}
}
