package Soncoding._2017_02_16;

public class Base7 {
	// Source : https://leetcode.com/problems/base-7/
	// Author : ErickRyu
	// Date   : 2017-02-16

	/*
	 * Given an integer, return its base 7 string representation.
	 * 
	 * Example 1:
	 * Input: 100
	 * Output: "202"
	 * 
	 * Example 2:
	 * Input: -7
	 * Output: "-10"
	 * 
	 * Note: The input will be in range of [-1e7, 1e7].
	*/	
	/**
	 * Created on 2017/02/16
	 */
	public static String convertToBase7(int num) {
		StringBuilder sb = new StringBuilder();
		boolean isMinus = num < 0? true : false;
		num = Math.abs(num);
		do{
			int remainder = num % 7;
			sb.insert(0, remainder);
			num /= 7;
		}while(num > 0);
		if(isMinus)
			sb.insert(0, "-");
		return sb.toString();
	}
}
