package Soncoding;

import java.util.Scanner;

public class NthDigit {
	// Source : https://leetcode.com/problems/nth-digit/
	// Author : ErickRyu
	// Date   : 2016-10-04
	
	
	/*
	 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
	 * 
	 * Note:
	 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
	 * 
	 * Example 1:
	 * Input:
	 * 3
	 * 
	 * Output:
	 * 3
	 * 
	 * Example 2:
	 * Input:
	 * 11
	 * Output:
	 * 0
	 * Explanation:
	 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
	 */
	
	
	/**
	 * Created on 2016/10/04
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println("MathSolution");
		mathSolution(n);
		
		System.out.println("findWithString");
		findNthWithStr(n);
		
		System.out.println("find with n");
		findNTh(n);
		
		sc.close();
	}

	public static void mathSolution(int n){
		Long input = (long)n;
		Long comp = 9l;
		int inputVal = input.intValue();

		int i = 0;

		Long nThNumber = -1l;
		int nThDigit = -1;
		char res = 'x';
		while (true) {
			comp = Long.valueOf((long) (Math.pow(10, i) * 9 * (i + 1)));
			if (input > comp) {
				input -= comp;
				i++;
			} else {
				input -= 1;
				nThNumber = (long) ((input / (i + 1) + Math.pow(10, i)));
				nThDigit = (int) (input % (i + 1));
				String strNth = Long.toString(nThNumber);
				char[] strNthArr = strNth.toCharArray();
				res = strNthArr[nThDigit];
				break;
			}
		}
		System.out.println("solution");
		System.out.println(res);
		
	}
	
	public static void findNTh(int n){
		int i = 1;
		int sumOfLen = 0;
		while(true){
			int len = Integer.toString(i).length();
			sumOfLen += len;
			if(sumOfLen >= n) break;
			i++;
		}
		int myLength = Integer.toString(i).length();
		int index = (myLength-1) + (n - sumOfLen);
		String res = Integer.toString(i).substring(index, index + 1);
		System.out.println("solution");
		System.out.println(res);
	}
	
	public static void findNthWithStr(int n){
		int res = 0;
		String sequence = "";
		int i = 1;
		while(true){
			sequence += i;
			if(sequence.length() >= n)	break;
			i++;
		}
		res = Integer.parseInt(sequence.substring(n-1, n));
		System.out.println("Solution");
		System.out.println(res);
	}
}
