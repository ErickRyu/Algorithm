
public class IntegerReplacement {
	// Source : https://leetcode.com/problems/integer-replacement/
	// Author : ErickRyu
	// Date   : 2016-10-04
	
	
	/*
	 * Given a positive integer n and you can do operations as follow:
	 * 
	 * If n is even, replace n with n/2.
	 * If n is odd, you can replace n with either n + 1 or n - 1.
	 * What is the minimum number of replacements needed for n to become 1?
	 * 
	 * Example 1:
	 * 
	 * Input:
	 * 8
	 * 
	 * Output:
	 * 3
	 * 
	 * Explanation:
	 * 8 -> 4 -> 2 -> 1
	 * 
	 * Example 2:
	 * 
	 * Input:
	 * 7
	 * 
	 * Output:
	 * 4
	 * 
	 * Explanation:
	 * 7 -> 8 -> 4 -> 2 -> 1
	 * or
	 * 7 -> 6 -> 3 -> 2 -> 1
	 */
	
	
	/**
	 * Created on 2016/10/04
	 */
	public int integerReplacement(int n) {
		int res = 0;
		long m = n;
		while (m > 0) {
			if (m <= 3) {
				res += m - 1;
				break;
			}
			if ((m & 1) > 0) {
				if ((m & 3) >= 3) {
					m++;
				} else {
					m--;
				}
			} else {
				m /= 2;
			}
			res++;
		}
		return res;
	}
}
