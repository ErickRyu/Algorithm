package Algospot;

import java.util.Scanner;

public class CSBaesball {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		while(TC-- > 0){
			int csScore = sc.nextInt();
			int pinScore = sc.nextInt();
			int toGetScore = 4;
			if(csScore > pinScore)
				toGetScore = 0;
			else
				toGetScore += pinScore - csScore;
			System.out.println(toGetScore);
		}
		sc.close();
	}
}
