package Soncoding._2017_02_23;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	// Source : https://leetcode.com/problems/contiguous-array/
	// Author : ErickRyu
	// Date   : 2017-02-23

	/*
	 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
	 * 
	 * Example 1:
	 * Input: [0,1]
	 * Output: 2
	 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
	 * 
	 * Example 2:
	 * Input: [0,1,0]
	 * Output: 2
	 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
	 * 
	 * Note: The length of the given binary array will not exceed 50,000.
	*/	
	/**
	 * Created on 2017/02/23
	 */
    public static int findMaxLength(int[] nums) {
        int sum = 0;
        int max = 0;
        Map<Integer, Integer> startIndexMap = new HashMap<>();
        startIndexMap.put(0, -1);
        for(int i = 0; i < nums.length; i++){
        	if(nums[i] == 0)
        		sum--;
        	else
        		sum++;
        	if(startIndexMap.containsKey(sum)){
        		int startIndex = startIndexMap.get(sum);
        		max = Math.max(max, i - startIndex);
        	}else
        		startIndexMap.put(sum, i);
        }
        return max;
    }
}
