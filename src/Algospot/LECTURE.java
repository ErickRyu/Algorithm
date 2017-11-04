package Algospot;

import java.util.Arrays;
import java.util.Scanner;

public class LECTURE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		while(TC-- > 0){
			String input = sc.next();
			int inputSize = input.length()/2;
			String toSortArr[] = new String[inputSize];
			for(int i = 0; i < inputSize; i++){
				toSortArr[i] = input.substring(i*2, i*2 + 2);
			}
			Arrays.sort(toSortArr);
			Arrays.stream(toSortArr).forEach(System.out::print);
			System.out.println();
		}
		sc.close();
	}
}
