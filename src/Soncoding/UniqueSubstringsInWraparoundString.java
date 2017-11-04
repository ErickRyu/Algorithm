package Soncoding;

import java.util.Arrays;

public class UniqueSubstringsInWraparoundString {
	// Source : https://leetcode.com/problems/unique-substrings-in-wraparound-string/
	// Author : ErickRyu
	// Date   : 2016-12-06

	/*
	Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

	Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.

	Note: p consists of only lowercase English letters and the size of p might be over 10000.

	Example 1:
	Input: "a"
	Output: 1

	Explanation: Only the substring "a" of string "a" is in the string s.
	Example 2:
	Input: "cac"
	Output: 2
	Explanation: There are two substrings "a", "c" of string "cac" in the string s.
	Example 3:
	Input: "zab"
	Output: 6
	Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
	*/
	
	/**
	 * Created on 2016/12/06
	 */
	
    public static int findSubstringInWraproundString(String p) {
        if(p.length() == 0) return 0;
    	
    	int[] mem = new int[26];
        Arrays.fill(mem, 0);
        char[] pArr = p.toCharArray();
        
        int count = 1;
        mem[pArr[0] - 'a'] = 1;
        for(int i = 1; i < p.length(); i++){
        	int idx = pArr[i] - 'a';
        	
        	//count
        	if((pArr[i-1] - 'a' + 1)%26 == pArr[i] - 'a'){
        		count++;
        	}else{
        		count = 1;
        	}
        	
        	//memoization
        	mem[idx] = Math.max(mem[idx], count);
        }
        int sum = 0;
        for(int val : mem)
        	sum += val;
        
        return sum;
    }
	
	public static void main(String[] args) {
		
		System.out.println(findSubstringInWraproundString("zab"));
	}

}
